package com.dai.project.service;

import com.dai.project.exception.DataNotFoundException;
import com.dai.project.model.Camera;
import com.dai.project.model.Facilitate;
import com.dai.project.model.Rezervare;
import com.dai.project.repository.FacilitateRepo;
import com.dai.project.repository.RezervareRepo;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class RezervareService {

    @Autowired
    RezervareRepo re;

   public Rezervare createNewRezervare(Camera camera, String numePers, String mailPers, String perioada, List<Facilitate> facilitateList) {
         return re.save(Rezervare.builder().camera(camera).period(perioada).personName(numePers).personMail(mailPers).facilitate(facilitateList).build());
   }

   public List<Rezervare> getReservations()
   {
       List<Rezervare> list= re.findAll();
       log.info(list.toString());
       return list;
   }

   public void delete(Long id)
   {
       Optional<Rezervare> rezervare=re.findById(id);
       if(rezervare.isPresent())
        re.delete(rezervare.get());
   }
}