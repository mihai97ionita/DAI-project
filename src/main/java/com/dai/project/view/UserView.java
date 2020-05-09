package com.dai.project.view;

import com.dai.project.model.Camera;
import com.dai.project.model.Facilitate;
import com.dai.project.model.Rezervare;
import com.dai.project.service.CamereService;
import com.dai.project.service.FacilitatiService;
import com.dai.project.service.RezervareService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
@RequestScoped
public class UserView {

    private String name;
    private String mail;
    private String period;

    @Autowired
    CamereService camereService;

    @Autowired
    FacilitatiService facilitatiService;

    @Autowired
    RezervareService rezervareService;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public void save() {
        List<Facilitate> facilitateList=new ArrayList<>();
        if(micDejun)
            facilitateList.add(facilitatiService.micDejun());
        if(patSuplimentar)
            facilitateList.add(facilitatiService.patSuplimentar());
        if(!micDejun && !patSuplimentar)
            facilitateList.add(facilitatiService.noFacilitate());
        Camera room=camereService.findByName(camera);
        System.out.println(facilitateList+"facilitati salvete");
        Rezervare r=rezervareService.createNewRezervare(room,name,mail,period,facilitateList);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Am inregistrat cererea ta,  " + name));

    }

    private String camera;
    private Map<String, String> camere;

    @PostConstruct
    public void init() {
        List<Camera> listOfCamere=camereService.getRooms();
        camere = new HashMap<String, String>();
        for(Camera c:listOfCamere)
            camere.put(c.getDescription(),c.getDescription());
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamere(Map<String, String> camere) {
        this.camere = camere;
    }

    public Map<String, String> getCamere() {
        return camere;
    }

    private boolean micDejun;
    private boolean patSuplimentar;

    public boolean isMicDejun() {
        return micDejun;
    }

    public void setMicDejun(boolean micDejun) {
        this.micDejun = micDejun;
    }

    public boolean isPatSuplimentar() {
        return patSuplimentar;
    }

    public void setPatSuplimentar(boolean patSuplimentar) {
        this.patSuplimentar = patSuplimentar;
    }

    public void addMessage() {
        String summary1 = micDejun ? "Checked" : "Unchecked";
        if (summary1.equals("Checked"))
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ati adaugat mic dejun."));
        String summary2 = patSuplimentar ? "Checked" : "Unchecked";
        if (summary2.equals("Checked"))
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ati adaugat pat suplimentar."));
    }


}
