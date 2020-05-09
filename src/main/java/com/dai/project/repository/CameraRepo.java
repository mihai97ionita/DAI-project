package com.dai.project.repository;
import com.dai.project.model.Camera;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CameraRepo extends JpaRepository<Camera, Long> {

    Optional<Camera> findByDescription(String description);

}
