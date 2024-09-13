package com.example.animelist.Animelist.repository;

import com.example.animelist.Animelist.dto.FullAnimeDTO;
import com.example.animelist.Animelist.entity.Anime;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnimeRepository extends BaseRepository<Anime> {

}
