package com.dai.project.service;

import com.dai.project.repository.CameraRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CamereService {

    @Autowired
    CameraRepo cameraRepo;



}