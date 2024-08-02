package br.com.ifpe.oficina.services.controllers;

import br.com.ifpe.oficina.persistence.GenericDAO;
import br.com.ifpe.oficina.persistence.Logger;

import java.util.NoSuchElementException;
import java.util.function.Predicate;

public abstract class GenericController<T> {

    protected GenericDAO<T> dao;

    public GenericController(GenericDAO<T> dao) {
        this.dao = dao;
    }

    protected abstract void validateInsert(T object);

    protected abstract void validateUpdate(T object);

    protected void genericInsert(T object) {
        try {
            this.validateInsert(object);
            Logger.info("Inserindo entidade: " + object.toString() + "\n");
            dao.insert(object);

        } catch (Exception e) {
            Logger.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    protected T genericRead(Predicate <T> filter) {
        T object = dao.read(filter);
        if (object == null){
            throw new NoSuchElementException("Enidade não encontrada");
        }
        return object;
    }

    protected void genericUpdate(int index, T object) {
        try {
            this.validateUpdate(object);
            Logger.info("Atualizando entidade: " + dao.viewAll().get(index).toString() + " -> " + object.toString());
            dao.viewAll().set(index, object);

        } catch (Exception e) {
            Logger.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    protected void genericDelete() {

    }
}