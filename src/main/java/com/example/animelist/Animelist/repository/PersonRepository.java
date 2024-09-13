package com.example.animelist.Animelist.repository;

import com.example.animelist.Animelist.dto.StaffDTO;
import com.example.animelist.Animelist.entity.Person;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PersonRepository extends BaseRepository<Person> {
    public List<StaffDTO> getStaffDtos(List<ObjectId> staffIDs);
}
