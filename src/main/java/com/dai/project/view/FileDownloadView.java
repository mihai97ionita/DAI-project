package com.dai.project.view;

import org.primefaces.model.DefaultStreamedContent;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.inject.Named;

import javax.faces.context.FacesContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

@Named
@RequestScoped
public class FileDownloadView {

    private DefaultStreamedContent file;

    public void setFile(DefaultStreamedContent file) {
        this.file = file;
    }

    public DefaultStreamedContent getFile() throws Exception {
        System.out.println("GET = " + file.getName());
        return file;
    }

    public FileDownloadView() throws Exception {
        InputStream input = getClass().getResourceAsStream("/META-INF/resources/oferta.pdf");
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        setFile(new DefaultStreamedContent(input,"pdf", "oferta.pdf"));
        System.out.println("PREP = " + file.getName());
    }
}
