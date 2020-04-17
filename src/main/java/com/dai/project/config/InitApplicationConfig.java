package com.dai.project.config;

import com.dai.project.Mocks;
import com.dai.project.model.Camera;
import com.dai.project.model.Facilitate;
import com.dai.project.model.Rezervare;
import com.dai.project.repository.CameraRepo;
import com.dai.project.repository.FacilitateRepo;
import com.dai.project.repository.RezervareRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Slf4j
public class InitApplicationConfig {

    @Autowired
    private CameraRepo cameraRepo;

    @Autowired
    private RezervareRepo rezervareRepo;

    @Autowired
    private FacilitateRepo facilitateRepo;

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        List<Camera> cameraList = Mocks.getSomeTarife();
        for(Camera t: cameraList)
            cameraRepo.save(t);
        log.info("Baza de date initializata");
        log.info(cameraRepo.findAll().toString());
        List<Facilitate> facilitates=new ArrayList<>();

        facilitates.add( facilitateRepo.save(Facilitate.builder().name("nume").price(20.0).build()));
        Rezervare rezervare=Rezervare.builder().personName("Mihai").camera(cameraList.get(0)).period("perioada...").facilitate(facilitates).build();
        rezervare=rezervareRepo.save(rezervare);
        log.info(rezervare.toString());
    }

}