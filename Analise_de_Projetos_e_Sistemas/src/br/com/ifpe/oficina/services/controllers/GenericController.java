package br.com.ifpe.oficina.services.controllers;

import br.com.ifpe.oficina.persistence.GenericDAO;
import br.com.ifpe.oficina.persistence.Logger;

import java.util.List;
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

    protected T genericRead(T object) {
        if (object == null) {
            throw new NoSuchElementException("Busca: Entidade não encontrada");
        }
        Logger.info("Busca: Entidade encontrada: " + object.toString());
        return object;
    }

    protected void genericUpdate(int index, T object) {
        try {
            this.validateUpdate(object);
            Logger.info("Atualizando entidade: " + dao.listAll().get(index).toString() + " -> " + object.toString());
            dao.listAll().set(index, object);
        } catch (Exception e) {
            Logger.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    protected void genericDelete(T object) {
        try {
            if (object == null) {
                throw new RuntimeException("Delete: entidade não encontrada");
            }
            Logger.info("Deletando entidade: " + object.toString());
            dao.delete(object);
        } catch (Exception e) {
            Logger.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    protected List<T> genericListAll() {
        return dao.listAll();
    }
}