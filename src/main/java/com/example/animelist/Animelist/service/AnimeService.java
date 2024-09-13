package com.example.animelist.Animelist.service;

import com.example.animelist.Animelist.dto.*;
import com.example.animelist.Animelist.entity.Anime;
import com.example.animelist.Animelist.repository.*;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnimeService {
    private AnimeRepository animeRepository;
    private CharacterRepository characterRepository;
    private ReviewRepository reviewRepository;
    private PersonRepository personRepository;
    private StudioRepository studioRepository;
    @Autowired
    public AnimeService(AnimeRepository animeRepository, CharacterRepository characterRepository,ReviewRepository reviewRepository, PersonRepository personRepository, StudioRepository studioRepository) {
        this.animeRepository = animeRepository;
        this.characterRepository = characterRepository;
        this.reviewRepository = reviewRepository;
        this.personRepository = personRepository;
        this.studioRepository = studioRepository;
    }

    public void delete(String id) {
        this.animeRepository.deleteById(id);
    }
    public Anime save(Anime anime) {
        return this.animeRepository.save(anime);
    }

    public Anime getById(String id) {
        Optional<Anime> query = this.animeRepository.findById(id);
        return query.orElse(null);

    }

    public FullAnimeDTO getFullAnime(String id) {
        Anime anime = getById(id);
        if (anime == null) {
            return  null;
        }
        List<String> idList=  new ArrayList<>();
        idList.add(id);
        List<CharacterRoleDTO> characterRoleDTOS = characterRepository.getCharacterRolesAnime(idList);
        List<ReviewForAnimePageDTO> reviewForAnimePageDTOS = reviewRepository.reviewsForAnime(id);
        List<ObjectId> staffIds =  anime.getStaffId();
        List<StaffDTO> staffDTOS = personRepository.getStaffDtos(staffIds);
        List<ObjectId> studioIds = anime.getStudioId();
        List<StudioDTO> studioDTOS = studioRepository.getStudioDTO(studioIds);
        FullAnimeDTO dto = new FullAnimeDTO(anime.getName(),anime.getJapaneseName()
                ,anime.getRanking(),anime.getPopularity(),anime.getPictureURL(),anime.getType(),characterRoleDTOS,anime.getAired(),
                anime.getRelated(),anime.getSynopsis(),staffDTOS,studioDTOS,reviewForAnimePageDTOS);
        return dto;
    }

}
