package com.example.animelist.Animelist.repository;

import com.example.animelist.Animelist.dto.CharacterRoleDTO;
import com.example.animelist.Animelist.entity.Character;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CharacterRepository extends BaseRepository<Character> {
    public List<CharacterRoleDTO> getCharacterRoles(List<String> ids);
    public List<CharacterRoleDTO> getCharacterRolesAnime(List<String> animeIds);
    public List<CharacterRoleDTO> getCharacterRolesVoiceActor(List<String> voiceActorIds);
}
