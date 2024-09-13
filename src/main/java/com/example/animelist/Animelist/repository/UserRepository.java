package com.example.animelist.Animelist.repository;

import com.example.animelist.Animelist.entity.Character;
import com.example.animelist.Animelist.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User> {
    public User userByUsername(String username);
}
