package com.example.animelist.Animelist.service;

import com.example.animelist.Animelist.entity.Session;
import com.example.animelist.Animelist.repository.SessionRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionService {

    private SessionRepository sessionRepository;
    @Autowired
    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }
    public boolean checkUserOrAdmin(HttpSession session,String tryingToAccessId) {


            String userId = (String) session.getAttribute("userId");
            List<String> roles = (List<String>) session.getAttribute("roles");
            boolean isAdmin = roles.stream().anyMatch(r -> r.toLowerCase().contains("admin"));
            return isAdmin || userId.equals(tryingToAccessId);


    }

    public Session save(Session s) {
        return sessionRepository.save(s);
    }
}
