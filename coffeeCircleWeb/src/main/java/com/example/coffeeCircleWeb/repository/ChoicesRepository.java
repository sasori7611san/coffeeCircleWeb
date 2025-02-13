package com.example.coffeeCircleWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.coffeeCircleWeb.model.Choices;

public interface ChoicesRepository extends JpaRepository<Choices, Integer> {

}
