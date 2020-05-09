package com.dai.project.view;

import com.dai.project.model.Rezervare;

import javax.inject.Named;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Named("dtBasicView")
@ViewScoped
public class BasicView implements Serializable {

    private List<Rezervare> rezervares;

    @Inject
    private RezervareViewService service;

    @PostConstruct
    public void init() {
        rezervares = service.createRezervares(3);
    }

    public List<Rezervare> getRezervares() {
        return rezervares;
    }

    public void setService(RezervareViewService service) {
        this.service = service;
    }
}
