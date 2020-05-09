package com.dai.project.service;

import com.dai.project.exception.DataNotFoundException;
import com.dai.project.model.Camera;
import com.dai.project.repository.CameraRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CamereService {

    @Autowired
    CameraRepo cameraRepo;

    public List<Camera> getRooms(){
        return cameraRepo.findAll();
    }

    public Camera findByName(String string){
        Optional<Camera> optionalCamera=cameraRepo.findByDescription(string);
        if(!optionalCamera.isPresent())
            throw new DataNotFoundException(Camera.class.getName());
        return cameraRepo.findByDescription(string).get();
    }



}