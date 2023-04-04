package com.dbc.chat.controller;

import com.dbc.chat.dto.NomeChat;
import com.dbc.chat.service.ProdutorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProdutorController {

    private final ProdutorService produtorService;

    @PostMapping("/send-to")
    public void sendTo(@RequestParam List<NomeChat> chats, @RequestParam String mensagem) throws JsonProcessingException {
        for (NomeChat nome : chats) {
            produtorService.sendTo(mensagem, nome);
        }
    }
}
