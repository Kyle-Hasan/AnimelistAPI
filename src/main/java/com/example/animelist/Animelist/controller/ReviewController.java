package com.example.animelist.Animelist.controller;

import com.example.animelist.Animelist.entity.Review;
import com.example.animelist.Animelist.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private ReviewService reviewService;
    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable String id) {
        Review review = reviewService.getById(id);
        return review;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        reviewService.delete(id);
    }

    @PostMapping("")
    public Review create(@RequestBody Review review) {
        return reviewService.save(review);
    }

    @PatchMapping("")
    public Review update(@RequestBody Review review) {
        return reviewService.save(review);
    }

    @GetMapping
    public List<Review> getList(@RequestBody List<String> ids) {
        return reviewService.getById(ids);
    }






}