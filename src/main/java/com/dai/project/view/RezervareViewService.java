package com.dai.project.view;

import com.dai.project.model.Camera;
import com.dai.project.model.Facilitate;
import com.dai.project.model.Rezervare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class RezervareViewService {

    private final static String[] name;
    private final static String[] mail;
    private final static String[] period;

    static {
        name = new String[3];
        name[0] = "Irina-Gabriela Nedelcu";
        name[1] = "Mihai Ionita";
        name[2] = "Catalin Negru";

        mail = new String[3];
        mail[0] = "irina.nedelcu@stud.acs.upb.ro";
        mail[1] = "mihai.ionita@stud.acs.upb.ro";
        mail[2] = "catalin.negru@acs.upb.ro";

        period = new String[3];
        period[0] = "2.10.2020 - 8.10.2020";
        period[1] = "1.05.2021 - 15.05.2021";
        period[2] = "20.12.2020 - 3.12.2021";

    }

    public List<Rezervare> createRezervares(int size) {
        Camera camera = new Camera((long)1,"Camera dubla ***", 123.0);

        List<Facilitate> facilitate = new ArrayList<Facilitate>();
        facilitate.add(new Facilitate((long)1, "Mic Dejun", 100.0, null ));

        List<Rezervare> list = new ArrayList<Rezervare>();
        for(int i = 0 ; i < size ; i++) {
            list.add(new Rezervare((long)i+1,name[i], mail[i], period[i], camera, facilitate));
        }

        return list;
    }

    public static String[] getName() {
        return name;
    }

    public static String[] getMail() {
        return mail;
    }

    public static String[] getPeriod() {
        return period;
    }

}