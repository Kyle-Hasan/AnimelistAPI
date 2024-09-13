package com.example.animelist.Animelist.repository;

import com.example.animelist.Animelist.dto.StudioDTO;
import com.example.animelist.Animelist.entity.Character;
import com.example.animelist.Animelist.entity.Studio;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StudioRepository extends BaseRepository<Studio> {
    public List<StudioDTO> getStudioDTO(List<ObjectId> ids);
}
