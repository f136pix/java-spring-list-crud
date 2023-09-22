package com.f136px.toDoList.repository;

import com.f136px.toDoList.model.Afazer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AfazerRepository extends JpaRepository<Afazer, Integer> {

    public List<Afazer> findByUsername(String username);
}
