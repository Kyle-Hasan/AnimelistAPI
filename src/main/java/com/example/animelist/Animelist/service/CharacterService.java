package com.example.animelist.Animelist.service;

import com.example.animelist.Animelist.dto.CharacterRoleDTO;
import com.example.animelist.Animelist.entity.Character;
import com.example.animelist.Animelist.entity.Person;
import com.example.animelist.Animelist.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CharacterService {

    private CharacterRepository characterRepository;
    @Autowired
    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public Character save(Character character) {
        return this.characterRepository.save(character);
    }

    public void delete(String id) {
        this.characterRepository.deleteById(id);
    }

    public Character getById(String id){
        Optional<Character> query = this.characterRepository.findById(id);
        return query.orElse(null);

    }

    public List<Character> getById(List<String> ids) {
        return this.characterRepository.findAll(ids);
    }

    public List<CharacterRoleDTO> getCharacterRoleDTOList(List<String> ids) {
       return this.characterRepository.getCharacterRoles(ids);
    }

    public List<CharacterRoleDTO> getCharacterRoleDTOListAnime(List<String> animeIds) {
        return this.characterRepository.getCharacterRolesAnime(animeIds);
    }

    public List<CharacterRoleDTO> getCharacterRoleDTOListVoiceActor(List<String> voiceActorIds) {
        return this.characterRepository.getCharacterRolesVoiceActor(voiceActorIds);
    }


}
