package com.dai.project;

import com.dai.project.model.Camera;

import java.util.ArrayList;
import java.util.List;

public class Mocks {

    public static List<Camera>  getSomeTarife()
    {
        List<Camera> list=new ArrayList<>();
        Camera tmp1= Camera.builder().description("Camera dubla*** cu baie proprie, tv, internet, minibar ").price(100.0).build();
        Camera tmp2= Camera.builder().description("Camera single*** cu baie proprie, tv, internet, minibar ").price(80.0).build();
        Camera tmp3= Camera.builder().description("Camera dubla*** cu baie proprie, tv, internet, minibar ").price(120.0).build();
        Camera tmp4= Camera.builder().description("Camera single*** cu baie proprie, tv, internet, minibar  ").price(95.0).build();
        list.add(tmp1);
        list.add(tmp2);
        list.add(tmp3);
        list.add(tmp4);
        return list;
    }
}
