package com.example.coffeeCircleWeb.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AnswerResult {
    private boolean correct;
    private int score;
}
