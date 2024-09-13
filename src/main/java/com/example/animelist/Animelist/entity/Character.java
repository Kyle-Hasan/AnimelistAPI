package com.example.animelist.Animelist.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("character")
public class Character {
    @Id
    private String id;
    private String name;
    private String japaneseName;
    private String characterName;
    private String pictureURL;
    public List<VoiceActorRole> voiceActorRoleList;
    private String description;

    public Character() {

    }

    public Character(String name, String japaneseName, String characterName, String pictureLink, List<VoiceActorRole> voiceActorRoleList,String description) {
        this.name = name;
        this.japaneseName = japaneseName;
        this.characterName = characterName;
        this.pictureURL = pictureLink;
        this.voiceActorRoleList = voiceActorRoleList;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJapaneseName() {
        return japaneseName;
    }

    public void setJapaneseName(String japaneseName) {
        this.japaneseName = japaneseName;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public List<VoiceActorRole> getVoiceActorRoleList() {
        return voiceActorRoleList;
    }

    public void setVoiceActorRoleList(List<VoiceActorRole> voiceActorRoleList) {
        this.voiceActorRoleList = voiceActorRoleList;
    }


    public static class AnimeRole {
        private String animeId;
        private String role;

        public AnimeRole() {

        }

        public AnimeRole(String animeId, String role) {
            this.animeId = animeId;
            this.role = role;
        }

        public String getAnimeId() {
            return animeId;
        }

        public void setAnimeId(String animeId) {
            this.animeId = animeId;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }

    public static class VoiceActorRole {
        private ObjectId voiceActorId;
        private String language;
        private ObjectId animeId;
        public VoiceActorRole() {

        }

        public VoiceActorRole(ObjectId voiceActorId, String language, ObjectId animeId) {
            this.voiceActorId = voiceActorId;
            this.language = language;
            this.animeId = animeId;
        }


        public ObjectId getVoiceActorId() {
            return voiceActorId;
        }

        public void setVoiceActorId(ObjectId voiceActorId) {
            this.voiceActorId = voiceActorId;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public ObjectId getAnimeId() {
            return animeId;
        }

        public void setAnimeId(ObjectId animeId) {
            this.animeId = animeId;
        }
    }

}
