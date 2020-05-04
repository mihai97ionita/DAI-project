package com.dai.project.view;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

@Named
@RequestScoped
public class UserView {

    private String name;
    private String mail;
    private String period;

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
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Am inregistrat cererea ta,  " + name));
    }

    private String camera;
    private Map<String, String> camere;

    @PostConstruct
    public void init() {
        camere = new HashMap<String, String>();
        camere.put("Camera dubla ***", "Camera dubla ***");
        camere.put("Camera single ***", "Camera single ***");
        camere.put("Camera dubla ****", "Camera dubla ****");
        camere.put("Camera single ****", "Camera single ****");
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
