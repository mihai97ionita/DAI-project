package com.dai.project.view;

import com.dai.project.model.Camera;
import com.dai.project.model.Facilitate;
import com.dai.project.model.Rezervare;
import com.dai.project.service.RezervareService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class RezervareViewService {

    @Autowired
    RezervareService rezervareService;

    public List<Rezervare> getRezervares() {
        return rezervareService.getReservations();
    }

    public void delete(Long id)
    {
        rezervareService.delete(id);
    }

}