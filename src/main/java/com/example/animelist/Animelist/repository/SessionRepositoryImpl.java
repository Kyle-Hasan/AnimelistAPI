package com.example.animelist.Animelist.repository;


import com.example.animelist.Animelist.entity.Session;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SessionRepositoryImpl extends BaseRepositoryImpl<Session> implements SessionRepository {
    private MongoTemplate mongoTemplate;
    @Autowired
    public SessionRepositoryImpl(MongoTemplate mongoTemplate) {
        super(mongoTemplate, Session.class);
    }

    @Override
    public Session validateToken(String token) {

        Query query = new Query(Criteria.where("token").is(token));
        List<Session> sessions = mongoTemplate.find(query,Session.class);

       if(!sessions.isEmpty()) {
           return sessions.getFirst();
       }
       else {
           return null;
       }

    }
}
