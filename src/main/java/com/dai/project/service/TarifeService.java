package com.dai.project.service;

import com.dai.project.dto.TarifeDTO;
import com.dai.project.exception.DataNotFoundException;
import com.dai.project.model.Tarife;
import com.dai.project.repository.TarifeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TarifeService {

    @Autowired
    TarifeRepository tarifeRepository;


    public List<TarifeDTO> getAll() {
        List<Tarife> tarifeList = tarifeRepository.findAll();
        System.out.println(tarifeList);

        if(tarifeList.isEmpty())
            throw new DataNotFoundException(Tarife.class.toString());

        List<TarifeDTO> tarifeDTOList = new ArrayList<>();
        for(Tarife tarife: tarifeList){
            TarifeDTO tarifeDTO= TarifeDTO.builder()
                    .description(tarife.getDescription())
                    .price(tarife.getPrice())
                    .build();
            tarifeDTOList.add(tarifeDTO);
        }
        return tarifeDTOList;
    }

}