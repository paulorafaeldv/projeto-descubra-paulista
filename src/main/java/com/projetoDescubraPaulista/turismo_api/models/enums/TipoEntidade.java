package com.projetoDescubraPaulista.turismo_api.models.enums;

/**
 * Identifica qual entidade está sendo avaliada ou favoritada
 * (relacionamento polimórfico: avaliação serve para vários tipos).
 */
public enum TipoEntidade {
    PONTO_TURISTICO,
    EVENTO,
    ROTEIRO
}
