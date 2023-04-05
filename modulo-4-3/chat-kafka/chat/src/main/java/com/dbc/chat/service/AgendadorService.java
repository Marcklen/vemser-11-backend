package com.dbc.chat.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
@Slf4j
public class AgendadorService {

    @Scheduled(fixedDelay = 10000)
    public void darParabénsProMarcklenACada10Segundos(){
        log.info("Parabéns Marcklen!" + SimpleDateFormat.getDateTimeInstance().format(System.currentTimeMillis()));
    }

    @Scheduled(cron = "0 0 3 1 * ?")
    public void darParabénsProMarcklenTodoDia3(){
        log.info("Parabéns Marcklen pelo seu aniversário! " + SimpleDateFormat.getDateTimeInstance().format(System.currentTimeMillis()));
    }
}