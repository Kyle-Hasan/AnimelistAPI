package com.example.animelist.Animelist.controller;

import com.example.animelist.Animelist.dto.CharacterRoleDTO;
import com.example.animelist.Animelist.entity.Character;
import com.example.animelist.Animelist.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    private CharacterService characterService;
    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/{id}")
    public Character getCharacterById(@PathVariable String id) {
        Character character = characterService.getById(id);
        return character;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        characterService.delete(id);
    }

    @PostMapping("")
    public Character create(@RequestBody Character character) {
        return characterService.save(character);
    }

    @PatchMapping("")
    public Character update(@RequestBody Character character) {
        return characterService.save(character);
    }

    @GetMapping
    public List<Character> getList(@RequestBody List<String> ids) {
        return characterService.getById(ids);
    }

    @PostMapping ("characterRoles")
    public List<CharacterRoleDTO> getCharacterRoleDTOs(@RequestBody List<String> ids) {
        return characterService.getCharacterRoleDTOList(ids);
    }
    // given an anime, get the character roles
    @PostMapping("characterRolesAnime")
    public List<CharacterRoleDTO> getCharacterRoleDTOsAnime(@RequestBody List<String> animeIds){
        return characterService.getCharacterRoleDTOListAnime(animeIds);
    }

    @PostMapping("characterRolesVoiceActor")
    public List<CharacterRoleDTO> getCharacterRoleDTOsVoiceActor(@RequestBody List<String> voiceActorIds){
        return characterService.getCharacterRoleDTOListVoiceActor(voiceActorIds);
    }






}