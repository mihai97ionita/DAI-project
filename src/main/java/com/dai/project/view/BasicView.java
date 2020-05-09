package com.dai.project.view;

import com.dai.project.model.Rezervare;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
    private String id;

    @Inject
    private RezervareViewService service;

    @PostConstruct
    public void init() {
        rezervares = service.getRezervares();
    }

    public List<Rezervare> getRezervares() {
        return rezervares;
    }

    public void setService(RezervareViewService service) {
        this.service = service;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void save() {
        boolean ok=true;
        try
        {
            Long longID=Long.parseLong(getId());
        }
        catch (Exception e)
        {
            ok=false;
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Erroare ID-ul trebuie din lista de ID-uri si un numar"));
        }
        if(ok)
            service.delete(Long.parseLong(getId()));
        rezervares=service.getRezervares();
    }
}
