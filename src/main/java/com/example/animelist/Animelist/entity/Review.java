package com.example.animelist.Animelist.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("review")
public class Review
{
    @Id
    private String id;
    private ObjectId ratingId;
    private ObjectId userId;
    private ObjectId animeId;
    private String comment;
    private Date created;
    private int helpfulCount;

    public Review() {

    }

    public Review(ObjectId ratingId, ObjectId userId, ObjectId animeId, String comment,Date created, int helpfulCount) {
        this.ratingId = ratingId;
        this.userId = userId;
        this.animeId = animeId;
        this.comment = comment;
        this.created = created;
        this.helpfulCount = helpfulCount;
    }

    public int getHelpfulCount() {
        return helpfulCount;
    }

    public void setHelpfulCount(int helpfulCount) {
        this.helpfulCount = helpfulCount;
    }

    public Date getDate() {
        return created;
    }

    public void setDate(Date created) {
        this.created = created;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ObjectId getRatingId() {
        return ratingId;
    }

    public void setRatingId(ObjectId ratingId) {
        this.ratingId = ratingId;
    }

    public ObjectId getUserId() {
        return userId;
    }

    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }

    public ObjectId getAnimeId() {
        return animeId;
    }

    public void setAnimeId(ObjectId animeId) {
        this.animeId = animeId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
