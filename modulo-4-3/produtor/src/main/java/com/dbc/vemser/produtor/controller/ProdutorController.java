package com.dbc.vemser.produtor.controller;

import com.dbc.vemser.produtor.service.ProdutorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProdutorController {

    private final ProdutorService produtorService;

    @PostMapping("/enviar")
    public void enviarMensagem(@RequestBody String mensagem) throws JsonProcessingException {
        produtorService.enviarMensagemParaOTopico(mensagem);
    }
}
