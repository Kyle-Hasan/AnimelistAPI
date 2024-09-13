package com.example.animelist.Animelist.repository;

import com.example.animelist.Animelist.dto.ReviewForAnimePageDTO;
import com.example.animelist.Animelist.entity.Review;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewRepositoryImpl extends BaseRepositoryImpl<Review> implements ReviewRepository {
    private MongoTemplate mongoTemplate;
    @Autowired
    public ReviewRepositoryImpl(MongoTemplate mongoTemplate) {
        super(mongoTemplate,Review.class);
    }


    @Override
    public List<ReviewForAnimePageDTO> reviewsForAnime(String animeId) {
        ObjectId animeObjectId = new ObjectId(animeId);
        MatchOperation matchOperation = Aggregation.match(Criteria.where("animeId").is(animeObjectId));
        LookupOperation lookupUserOperation =  Aggregation.lookup("users","userId","_id","userDetails");
        UnwindOperation unwindRatings = Aggregation.unwind("userDetails.ratings");
        MatchOperation matchRatings = Aggregation.match(Criteria.where("userDetails.ratings.animeId").is(animeObjectId));


        ProjectionOperation projectionOperation = Aggregation.project()
                .and("_id").as("id")
                .and("comment").as("comment")
                .and("created").as("created")
                .and("helpfulCount").as("helpfulCount")
                .and("userPictureURL").as("userDetails.profilePictureURL")
                .and("username").as("userDetails.username")
                .and("userDetails.ratings.score").as("score");
        Aggregation aggregation = Aggregation.newAggregation(matchOperation,lookupUserOperation,projectionOperation);
        AggregationResults<ReviewForAnimePageDTO> results = mongoTemplate.aggregate(aggregation,"review",ReviewForAnimePageDTO.class);
        return  results.getMappedResults();
    }
}
