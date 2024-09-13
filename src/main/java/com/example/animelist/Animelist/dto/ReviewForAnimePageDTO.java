package com.example.animelist.Animelist.dto;

import org.bson.types.ObjectId;

import java.util.Date;

public record ReviewForAnimePageDTO(ObjectId id, String comment, Date created, int helpfulCount,String username, String userPictureURL, int score) {
}
