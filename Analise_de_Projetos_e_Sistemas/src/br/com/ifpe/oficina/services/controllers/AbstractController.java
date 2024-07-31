package br.com.ifpe.oficina.services.controllers;

import br.com.ifpe.oficina.persistence.Logger;

public abstract class AbstractController<T> {
    public void insert(T object) {
        this.validateInsert();
        Logger.info("Inserindo entidade: " + object.toString() + "\n");

    }
}
