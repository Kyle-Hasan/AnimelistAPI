package com.example.animelist.Animelist.repository;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;

public abstract class BaseRepositoryImpl<T> implements BaseRepository<T> {
    protected MongoTemplate mongoTemplate;
    protected Class<T> entityClass;
    public BaseRepositoryImpl(MongoTemplate mongoTemplate, Class<T> entityClass) {
        this.mongoTemplate = mongoTemplate;
        this.entityClass = entityClass;
    }
    @Override
    public void deleteById(String id) {
         mongoTemplate.remove(where("_id").is(id));
    }
    @Override
    public Optional<T> findById(String id) {
        T entity = mongoTemplate.findById(id, entityClass);
        return Optional.ofNullable(entity);
    }
    @Override
    public List<T> findAll(List<String> id) {
        List<T> entities = mongoTemplate.find(new Query(where("_id").in(id)),entityClass);
        return entities;
    }
    @Override
    public T save(T entity) {
        return mongoTemplate.save(entity);
    }



}
