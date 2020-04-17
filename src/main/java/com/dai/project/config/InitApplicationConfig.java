package com.dai.project.config;

import com.dai.project.model.Shop;
import com.dai.project.model.Tarife;
import com.dai.project.repository.TarifeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.web.client.RestTemplate;

@Configuration
@Slf4j
public class InitApplicationConfig {

    @Autowired
    private TarifeRepository tarifeRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void init() {

        tarifeRepository.save(Tarife.builder().id(1L).description("Camera dubla*** cu baie proprie, tv, internet, minibar ").price("100 RON").build());
        tarifeRepository.save(Tarife.builder().id(2L).description("Camera single*** cu baie proprie, tv, internet, minibar ").price("80 RON").build());
        tarifeRepository.save(Tarife.builder().id(3L).description("Camera dubla*** cu baie proprie, tv, internet, minibar ").price("120 RON").build());
        tarifeRepository.save(Tarife.builder().id(4L).description("Camera single*** cu baie proprie, tv, internet, minibar  ").price("95 RON").build());
        log.info("Baza de date initializata");
    }

}