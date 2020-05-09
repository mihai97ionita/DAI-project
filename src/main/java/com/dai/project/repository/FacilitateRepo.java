package com.dai.project.repository;

import com.dai.project.model.Camera;
import com.dai.project.model.Facilitate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FacilitateRepo extends JpaRepository<Facilitate, Long> {

    Optional<Facilitate> findByName(String name);
}
