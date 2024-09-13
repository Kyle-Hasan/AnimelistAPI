package com.example.animelist.Animelist.dto;

import com.example.animelist.Animelist.entity.Anime;

import java.util.List;

public record FullAnimeDTO(String name, String japaneseName, int ranking, int popularity, String pictureLink, String type,
                           List<CharacterRoleDTO> characterRoles, Anime.DateRange aired, Anime.Related related, String synopsis,List<StaffDTO> staff,
                           List<StudioDTO> studios,
                           List<ReviewForAnimePageDTO> reviews) {
}
