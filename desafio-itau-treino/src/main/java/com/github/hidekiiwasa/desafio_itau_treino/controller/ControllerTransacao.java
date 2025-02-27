package com.github.hidekiiwasa.desafio_itau_treino.controller;

import com.github.hidekiiwasa.desafio_itau_treino.dtos.DTOTransacao;
import com.github.hidekiiwasa.desafio_itau_treino.service.ServiceTransacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class ControllerTransacao {

    @Autowired
    private ServiceTransacao service;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody DTOTransacao transacao) {
        return service.cadastrar(transacao);
    }
}
