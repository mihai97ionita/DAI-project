package com.dai.project.view;

import org.primefaces.event.SelectEvent;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class InputTextareaView {

    public List<String> completeArea(String query) {
        List<String> results = new ArrayList<String>();

        if(query.equals("PrimeFaces")) {
            results.add("PrimeFaces Rocks!!!");
            results.add("PrimeFaces has 100+ components.");
            results.add("PrimeFaces is lightweight.");
            results.add("PrimeFaces is easy to use.");
            results.add("PrimeFaces is developed with passion!");
        }
        else {
            for(int i = 0; i < 10; i++) {
                results.add(query + i);
            }
        }

        return results;
    }

    public void onSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "select", (String) event.getObject()));
    }
}
