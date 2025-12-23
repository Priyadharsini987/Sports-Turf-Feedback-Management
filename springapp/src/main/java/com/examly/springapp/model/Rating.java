package com.examly.springapp.model;

import jakarta.persistence.*;

@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ratingId;

    private int score;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Constructors
    public Rating() {}
    public Rating(int score, User user) {
        this.score = score;
        this.user = user;
    }

    // Getters & Setters
    public Long getRatingId() { return ratingId; }
    public void setRatingId(Long ratingId) { this.ratingId = ratingId; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
