package com.example.animelist.Animelist.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document("anime")
public class Anime {
    @Id
    private String id;
    private String name;
    private String japaneseName;
    private int ranking;
    private int popularity;


    public String pictureURL;

    private List<ObjectId> staffId;
    private List<ObjectId> studioId;
    private String type;
    private int favourites;
    private Related related;
    private DateRange aired;
    private List<CharacterRole> characters;
    private List<String> genre;



    private String synopsis;

    public Anime() {

    }

    public Anime(String name, String japaneseName, int ranking, int popularity, List<ObjectId> staffId, List<ObjectId> studioId, String type, int favourites, Related related, DateRange aired, List<CharacterRole> characters,
                 String pictureURL,String synopsis,List<String> genre) {
        this.name = name;
        this.japaneseName = japaneseName;
        this.ranking = ranking;
        this.popularity = popularity;
        this.staffId = staffId;
        this.studioId = studioId;
        this.type = type;
        this.favourites = favourites;
        this.related = related;
        this.aired = aired;
        this.characters = characters;
        this.synopsis = synopsis;
        this.pictureURL = pictureURL;
        this.genre = genre;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
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

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public List<ObjectId> getStaffId() {
        return staffId;
    }

    public void setStaffId(List<ObjectId> staffId) {
        this.staffId = staffId;
    }

    public List<ObjectId> getStudioId() {
        return studioId;
    }

    public void setStudioId(List<ObjectId> studioId) {
        this.studioId = studioId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getFavourites() {
        return favourites;
    }

    public void setFavourites(int favourites) {
        this.favourites = favourites;
    }

    public Related getRelated() {
        return related;
    }

    public void setRelated(Related related) {
        this.related = related;
    }

    public DateRange getAired() {
        return aired;
    }

    public void setAired(DateRange aired) {
        this.aired = aired;
    }

    public List<CharacterRole> getCharacters() {
        return characters;
    }

    public void setCharacters(List<CharacterRole> characters) {
        this.characters = characters;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public static class DateRange {
        private Date from;
        private Date to;

        public DateRange() {

        }

        public DateRange(Date from, Date to) {
            this.from = from;
            this.to = to;
        }

        public Date getFrom() {
            return from;
        }

        public void setFrom(Date from) {
            this.from = from;
        }

        public Date getTo() {
            return to;
        }

        public void setTo(Date to) {
            this.to = to;
        }
    }

    public static class CharacterRole{
        private String characterId;
        private String role;

        public CharacterRole() {

        }

        public CharacterRole(String characterId, String role) {
            this.characterId = characterId;
            this.role = role;
        }

        public String getCharacterId() {
            return characterId;
        }

        public void setCharacterId(String characterId) {
            this.characterId = characterId;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }

    public static class Related {
        private List<String> prequels;
        private List<String> sequels;
        private List<String> spinOffs;
        private List<String> sideStories;

        public Related() {

        }

        public Related(List<String> prequels, List<String> sequels, List<String> spinOffs, List<String> sideStories) {
            this.prequels = prequels;
            this.sequels = sequels;
            this.spinOffs = spinOffs;
            this.sideStories = sideStories;
        }


        public List<String> getPrequels() {
            return prequels;
        }

        public void setPrequels(List<String> prequels) {
            this.prequels = prequels;
        }

        public List<String> getSequels() {
            return sequels;
        }

        public void setSequels(List<String> sequels) {
            this.sequels = sequels;
        }

        public List<String> getSpinOffs() {
            return spinOffs;
        }

        public void setSpinOffs(List<String> spinOffs) {
            this.spinOffs = spinOffs;
        }

        public List<String> getSideStories() {
            return sideStories;
        }

        public void setSideStories(List<String> sideStories) {
            this.sideStories = sideStories;
        }
    }

}
