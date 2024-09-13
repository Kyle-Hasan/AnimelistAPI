package com.example.animelist.Animelist.repository;

import com.example.animelist.Animelist.dto.ReviewForAnimePageDTO;
import com.example.animelist.Animelist.entity.Review;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ReviewRepository extends BaseRepository<Review> {
    public List<ReviewForAnimePageDTO> reviewsForAnime(String animeId);
}
