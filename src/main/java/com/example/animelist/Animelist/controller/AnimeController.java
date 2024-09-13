package com.example.animelist.Animelist.controller;

import com.example.animelist.Animelist.dto.FullAnimeDTO;
import com.example.animelist.Animelist.entity.Anime;
import com.example.animelist.Animelist.service.AnimeService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/animes")
public class AnimeController {

    private AnimeService animeService;
    @Autowired
    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    @GetMapping("/{id}")
    public Anime getAnimeById(@PathVariable String id) {
        Anime anime = animeService.getById(id);
        return anime;
    }

    @GetMapping("/full/{id}")
    public FullAnimeDTO FullAnimeById(@PathVariable String id) {
        FullAnimeDTO dto = animeService.getFullAnime(id);
        return dto;
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        animeService.delete(id);
    }

    @PostMapping("")
    public Anime create(@RequestBody Anime anime) {
        return animeService.save(anime);
    }

    @PatchMapping("")
    public Anime update(@RequestBody Anime anime) {
        return animeService.save(anime);
    }




}
