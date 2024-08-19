package br.com.ifpe.oficina.services.controllers;

import br.com.ifpe.oficina.persistence.GenericDAO;
import br.com.ifpe.oficina.persistence.Logger;

import java.util.List;
import java.util.NoSuchElementException;

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
            Logger.info("Inserting entity: " + object.toString() + "\n");
            dao.insert(object);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    protected T genericRead(T object) {
        if (object == null) {
            throw new NoSuchElementException("Search: Entity not found");
        }
        Logger.info("Search: Entity found: " + object.toString());
        return object;
    }

    protected void genericUpdate(int index, T object) {
        try {
            this.validateUpdate(object);
            Logger.info("Updating entity: " + dao.listAll().get(index).toString() + " -> " + object.toString());
            dao.update(index, object);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    protected void genericDelete(T object) {
        try {
            if (object == null) {
                throw new RuntimeException("Delete Error: Entity not found");
            }
            Logger.info("Deleting entity: " + object.toString());
            dao.delete(object);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    protected List<T> genericListAll() {
        return dao.listAll();
    }
}