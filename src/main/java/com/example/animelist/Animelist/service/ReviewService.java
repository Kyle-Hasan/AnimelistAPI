package com.example.animelist.Animelist.service;

import com.example.animelist.Animelist.entity.Review;
import com.example.animelist.Animelist.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    private ReviewRepository reviewRepository;
    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review save(Review review) {
        return this.reviewRepository.save(review);
    }

    public void delete(String id) {
        this.reviewRepository.deleteById(id);
    }

    public Review getById(String id){
        Optional<Review> query = this.reviewRepository.findById(id);
        return query.orElse(null);

    }

    public List<Review> getById(List<String> ids) {
        return this.reviewRepository.findAll(ids);
    }
}
