package com.dbc.chat.service;

import com.dbc.chat.dto.NomeChat;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProdutorService {

    private final ObjectMapper objectMapper;
    public void sendTo(String mensagem, NomeChat nome) {
    }
}