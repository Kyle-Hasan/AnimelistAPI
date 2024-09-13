package com.example.animelist.Animelist.dto;

import org.bson.types.ObjectId;

public record CharacterRoleDTO(String characterId, String voiceActorId, String characterName, String characterPictureURL,
                               String voiceActorGivenName, String voiceActorFamilyName, String voiceActorPictureURL, String language, String animeId, String animeName, String animePictureURL) {
}
