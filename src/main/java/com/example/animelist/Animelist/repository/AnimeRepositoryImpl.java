package com.example.animelist.Animelist.repository;


import com.example.animelist.Animelist.dto.FullAnimeDTO;
import com.example.animelist.Animelist.entity.Anime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AnimeRepositoryImpl extends BaseRepositoryImpl<Anime> implements AnimeRepository {
    private MongoTemplate mongoTemplate;
    @Autowired
    public AnimeRepositoryImpl(MongoTemplate mongoTemplate) {
        super(mongoTemplate, Anime.class);
    }



}
