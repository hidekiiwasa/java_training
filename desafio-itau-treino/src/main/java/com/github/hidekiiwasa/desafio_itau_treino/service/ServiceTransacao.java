package com.github.hidekiiwasa.desafio_itau_treino.service;

import com.github.hidekiiwasa.desafio_itau_treino.domain.Transacao;
import com.github.hidekiiwasa.desafio_itau_treino.dtos.DTOTransacao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceTransacao {

    private final List<Transacao> transacoes = new ArrayList<>();
    
    public ResponseEntity<?> cadastrar(DTOTransacao transacao) {
        OffsetDateTime diaAtual = OffsetDateTime.now();

        if (transacao.dataHora() == null && transacao.valor() == 0) {
            return ResponseEntity.status(400).build();
        }

        if (transacao.dataHora().isAfter(diaAtual)) {
            return ResponseEntity.status(422).body("Erro: A data não é válida.");
        }

        if (transacao.valor() < 0) {
            return ResponseEntity.status(422).body("Erro: Valor negativo.");
        }

        transacoes.add(new Transacao(transacao.valor(), transacao.dataHora()));
        return ResponseEntity.status(201).build();
    }
}
