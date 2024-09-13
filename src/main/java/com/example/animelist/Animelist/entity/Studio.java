package com.example.animelist.Animelist.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("studio")
public class Studio {
    @Id

    private String id;
    private String name;
    private String description;
    private List<ObjectId> staff;
    private List<ObjectId> anime;

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    private String pictureURL;

    public Studio() {

    }

    public Studio(String name, String description, List<ObjectId> staff, List<ObjectId> anime,String pictureURL) {
        this.name = name;
        this.description = description;
        this.staff = staff;
        this.anime = anime;
        this.pictureURL = pictureURL;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ObjectId> getStaff() {
        return staff;
    }

    public void setStaff(List<ObjectId> staff) {
        this.staff = staff;
    }

    public List<ObjectId> getAnime() {
        return anime;
    }

    public void setAnime(List<ObjectId> anime) {
        this.anime = anime;
    }
}
