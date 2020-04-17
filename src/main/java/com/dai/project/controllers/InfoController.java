package com.dai.project.controllers;


import com.dai.project.dto.TarifeDTO;
import com.dai.project.model.Shop;
import com.dai.project.model.Tarife;
import com.dai.project.repository.TarifeRepository;
import com.dai.project.service.TarifeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/info")
public class InfoController {

    @Autowired
    TarifeService tarifeService;

    @GetMapping("/tarife")
    public ResponseEntity<List<TarifeDTO>> getAllTarife() {
        return new ResponseEntity<List<TarifeDTO>>(tarifeService.getAll(),HttpStatus.OK);
    }
}