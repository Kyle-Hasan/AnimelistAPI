package com.example.animelist.Animelist.dto;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Date;

public record UserProfilePageDTO(ObjectId userID, String userName, int score, Date joinedDate, List<RatingAndAnimeJoinedDTO> ratings, String profilePictureLink  ) {
}
