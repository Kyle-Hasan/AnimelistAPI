package com.example.animelist.Animelist.repository;

import com.example.animelist.Animelist.entity.Session;

public interface SessionRepository extends BaseRepository<Session> {
    public Session validateToken(String token);
}
