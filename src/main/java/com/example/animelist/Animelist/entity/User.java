package com.example.animelist.Animelist.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Document(collection = "users")
public class User implements UserDetails {
    @Id
    private String id;
    @Indexed(unique = true)
    private String username;
    private String email;
    private String passwordHash;
    private String passwordSalt;
    private Date joinedDate;
    private List<ObjectId> watchList;
    private List<ObjectId> reviews;
    private List<ObjectId> ratings;
    private Collection<? extends GrantedAuthority> authorities;



    private String profilePictureURL;

    public User(){

    }

    public User(String userName,String email,String passwordHash) {
        this.username = userName;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public User(String userName, String email, String passwordHash, String passwordSalt, Date joinedDate, List<ObjectId> watchList, List<ObjectId> reviews, List<ObjectId> ratings,String profilePicture) {
        this.username = userName;
        this.email = email;
        this.passwordHash = passwordHash;
        this.passwordSalt = passwordSalt;
        this.joinedDate = joinedDate;
        this.watchList = watchList;
        this.reviews = reviews;
        this.ratings = ratings;
        this.profilePictureURL = profilePicture;
    }

    public String getProfilePictureURL() {
        return profilePictureURL;
    }

    public void setProfilePictureURL(String profilePictureURL) {
        this.profilePictureURL = profilePictureURL;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public List<ObjectId> getWatchList() {
        return watchList;
    }

    public void setWatchList(List<ObjectId> watchList) {
        this.watchList = watchList;
    }

    public List<ObjectId> getReviews() {
        return reviews;
    }

    public void setReviews(List<ObjectId> reviews) {
        this.reviews = reviews;
    }

    public List<ObjectId> getRatings() {
        return ratings;
    }

    public void setRatings(List<ObjectId> ratings) {
        this.ratings = ratings;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return passwordHash;
    }

    @Override
    public String getUsername() {
        return username;
    }


    private static class Rating {
        private ObjectId animeId;
        private int score;

        public Rating() {

        }

        public Rating(ObjectId animeId, int score) {
            this.animeId = animeId;
            this.score = score;
        }

        public ObjectId getAnimeId() {
            return animeId;
        }

        public void setAnimeId(ObjectId animeId) {
            this.animeId = animeId;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

    }


    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
