package com.example.animelist.Animelist.repository;

import com.example.animelist.Animelist.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Repository
public class UserRepositoryImpl extends BaseRepositoryImpl<User> implements UserRepository {
    private MongoTemplate template;
    @Autowired
    public UserRepositoryImpl(MongoTemplate mongoTemplate) {
        super(mongoTemplate,User.class);
    }

    @Override
    public User userByUsername(String username) {
        Query query = new Query(where("username").is(username));
        User user =  mongoTemplate.findOne(query,User.class);
        return user;
    }
}
