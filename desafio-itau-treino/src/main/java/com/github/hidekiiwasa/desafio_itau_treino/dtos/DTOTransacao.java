package com.github.hidekiiwasa.desafio_itau_treino.dtos;

import java.time.OffsetDateTime;

public record DTOTransacao(double valor, OffsetDateTime dataHora) {}