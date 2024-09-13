package com.example.animelist.Animelist.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("people")
public class Person {


    @Id
    private String id;
    private String name;
    private String givenName;
    private String familyName;
    private Date birthDate;
    private String language;
    private int favourites;
    private String biography;
    private String pictureURL;
    private String homeTown;
    private String type;



    public Person(String name, String givenName, String familyName, Date birthDate, String language, int favourites, String biography, String pictureURL, String homeTown, String type) {

        this.name = name;
        this.familyName = familyName;
        this.givenName = givenName;
        this.birthDate = birthDate;
        this.language = language;
        this.favourites = favourites;
        this.biography = biography;
        this.pictureURL = pictureURL;
        this.homeTown = homeTown;
        this.type = type;
    }

    public Person() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
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

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getFavourites() {
        return favourites;
    }

    public void setFavourites(int favourites) {
        this.favourites = favourites;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }


    public static class characterRoles {
        private ObjectId characterId;
        private ObjectId animeId;

        public characterRoles(ObjectId characterId, ObjectId animeId) {
            this.characterId = characterId;
            this.animeId = animeId;
        }

        public characterRoles() {

        }

        public ObjectId getAnimeId() {
            return animeId;
        }

        public void setAnimeId(ObjectId animeId) {
            this.animeId = animeId;
        }

        public ObjectId getCharacterId() {
            return characterId;
        }

        public void setCharacterId(ObjectId characterId) {
            this.characterId = characterId;
        }
    }





}
