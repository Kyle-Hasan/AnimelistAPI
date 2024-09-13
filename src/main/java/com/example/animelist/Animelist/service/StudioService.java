package com.example.animelist.Animelist.service;

import com.example.animelist.Animelist.entity.Studio;
import com.example.animelist.Animelist.repository.StudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudioService {
    private StudioRepository studioRepository;
    @Autowired
    public StudioService(StudioRepository studioRepository) {
        this.studioRepository = studioRepository;
    }

    public Studio save(Studio studio) {
        return this.studioRepository.save(studio);
    }

    public void delete(String id) {
        this.studioRepository.deleteById(id);
    }

    public Studio getById(String id){
        Optional<Studio> query = this.studioRepository.findById(id);
        return query.orElse(null);

    }

    public List<Studio> getById(List<String> ids) {
        return this.studioRepository.findAll(ids);
    }
}
