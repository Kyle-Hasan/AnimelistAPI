package com.example.animelist.Animelist.repository;

import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;

public interface BaseRepository<T> {
    public void deleteById(String id);

    public Optional<T> findById(String id);

    public List<T> findAll(List<String> id);

    public T save(T entity);
}
