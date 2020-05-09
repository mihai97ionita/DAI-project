package com.dai.project.service;

import com.dai.project.exception.DataNotFoundException;
import com.dai.project.model.Camera;
import com.dai.project.model.Facilitate;
import com.dai.project.repository.CameraRepo;
import com.dai.project.repository.FacilitateRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class FacilitatiService {

    @Autowired
    FacilitateRepo facilitateRepo;

    public Facilitate micDejun() {

        return facilitateRepo.findByName("Mic Dejun").get();
    }

    public Facilitate patSuplimentar() {
        return facilitateRepo.findByName("Pat Suplimentar").get();
    }

    public Facilitate noFacilitate()
    {
        return facilitateRepo.findByName("Fara facilitate").get();
    }


}