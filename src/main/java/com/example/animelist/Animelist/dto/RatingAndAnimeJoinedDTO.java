package com.example.animelist.Animelist.dto;

import org.bson.types.ObjectId;

public record RatingAndAnimeJoinedDTO(ObjectId id, int score, AnimeBasicInfoDTO animeInfo) {
}
