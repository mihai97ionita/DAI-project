package com.dai.project.config;

import com.dai.project.model.Camera;
import com.dai.project.model.Facilitate;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {

    public static List<Camera> getAvailableRooms()
    {
        List<Camera> list=new ArrayList<>();
        Camera tmp1= Camera.builder().description("Camera dubla***").price(100.0).build();
        Camera tmp2= Camera.builder().description("Camera single***").price(80.0).build();
        Camera tmp3= Camera.builder().description("Camera dubla****").price(120.0).build();
        Camera tmp4= Camera.builder().description("Camera single****").price(95.0).build();
        list.add(tmp1);
        list.add(tmp2);
        list.add(tmp3);
        list.add(tmp4);
        return list;
    }

    public static List<Facilitate> getAvailableFacilities()
    {
        List<Facilitate> list=new ArrayList<>();
        Facilitate tmp1= Facilitate.builder().name("Mic Dejun").price(20.0).build();
        Facilitate tmp2= Facilitate.builder().name("Pat Suplimentar").price(30.0).build();
        Facilitate tmp3= Facilitate.builder().name("Fara facilitate").price(0.0).build();
        list.add(tmp1);
        list.add(tmp2);
        list.add(tmp3);
        return list;
    }
}
