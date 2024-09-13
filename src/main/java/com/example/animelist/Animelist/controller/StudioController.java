package com.example.animelist.Animelist.controller;

import com.example.animelist.Animelist.entity.Studio;
import com.example.animelist.Animelist.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/studios")
public class StudioController {

    private StudioService studioService;
    @Autowired
    public StudioController(StudioService studioService) {
        this.studioService = studioService;
    }

    @GetMapping("/{id}")
    public Studio getStudioById(@PathVariable String id) {
        Studio studio = studioService.getById(id);
        return studio;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        studioService.delete(id);
    }

    @PostMapping("")
    public Studio create(@RequestBody Studio studio) {
        return studioService.save(studio);
    }

    @PatchMapping("")
    public Studio update(@RequestBody Studio studio) {
        return studioService.save(studio);
    }

    @GetMapping
    public List<Studio> getList(@RequestBody List<String> ids) {
        return studioService.getById(ids);
    }






}