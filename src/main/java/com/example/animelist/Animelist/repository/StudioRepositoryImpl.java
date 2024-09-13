package com.example.animelist.Animelist.repository;

import com.example.animelist.Animelist.dto.StaffDTO;
import com.example.animelist.Animelist.dto.StudioDTO;
import com.example.animelist.Animelist.entity.Person;
import com.example.animelist.Animelist.entity.Studio;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudioRepositoryImpl extends BaseRepositoryImpl<Studio> implements StudioRepository {
    private MongoTemplate mongoTemplate;
    public StudioRepositoryImpl(MongoTemplate mongoTemplate) {
        super(mongoTemplate,Studio.class);
    }


    @Override
    public List<StudioDTO> getStudioDTO(List<ObjectId> ids) {
        List<Studio> studios = mongoTemplate.find(new Query(Criteria.where("_id").in(ids)),Studio.class);
        return studios.stream().map(
                studio -> {
                    return new StudioDTO(studio.getName());
                }
        ).toList();
    }
}
