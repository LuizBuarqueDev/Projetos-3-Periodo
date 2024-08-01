package br.com.ifpe.oficina.services.controllers;

import br.com.ifpe.oficina.persistence.Logger;

public abstract class AbstractController<T> {

    protected void insert(T object) {
        this.validateInsert(object);
        Logger.info("Inserindo entidade: " + object.toString() + "\n");
    }

    protected abstract void validateInsert (T object);
}
