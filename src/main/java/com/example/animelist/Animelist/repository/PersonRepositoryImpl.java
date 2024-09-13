package com.example.animelist.Animelist.repository;

import com.example.animelist.Animelist.dto.StaffDTO;
import com.example.animelist.Animelist.entity.Person;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepositoryImpl extends BaseRepositoryImpl<Person> implements  PersonRepository{
    private MongoTemplate mongoTemplate;
    @Autowired
    public PersonRepositoryImpl(MongoTemplate mongoTemplate) {
        super(mongoTemplate,Person.class);
    }


    @Override
    public List<StaffDTO> getStaffDtos(List<ObjectId> staffIDs) {
        List<Person> people = mongoTemplate.find(new Query(Criteria.where("_id").in(staffIDs)),Person.class);
        return people.stream().map(
                person -> {
                    return new StaffDTO(person.getName(),person.getType(),person.getPictureURL());
                }
        ).toList();
    }
}
