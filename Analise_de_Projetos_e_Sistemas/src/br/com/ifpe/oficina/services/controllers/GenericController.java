package br.com.ifpe.oficina.services.controllers;

import br.com.ifpe.oficina.persistence.GenericDAO;
import br.com.ifpe.oficina.persistence.Logger;

import java.util.List;
import java.util.NoSuchElementException;

public abstract class GenericController<T> implements IController<T>{

    protected GenericDAO<T> dao;

    public GenericController(GenericDAO<T> dao) {
        this.dao = dao;
    }

    protected abstract T search(String unique_key);

    protected abstract void validateInsert(T object);

    protected abstract T validateUpdate(T object);

    protected abstract void afterDelete(T object, boolean deleteAssociation);

    protected abstract void fixInsert(T object);


    @Override
    public void insert(T object) {
        try {
            this.validateInsert(object);
            Logger.info("Inserting entity: " + object.toString() + "\n");
            dao.insert(object);

        } catch (Exception e) {
            fixInsert(object);
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public T read(String unique_key) {
        T object = search(unique_key);
        if (object == null) {
            throw new NoSuchElementException("Search: Entity not found");
        }
        Logger.info("Search: Entity found: " + object.toString());
        return object;
    }

    @Override
    public void update(T object) {
        try {
            T oldObject = this.validateUpdate(object);
            int index = viewAll().indexOf(oldObject);
            Logger.info("Updating entity: " + dao.listAll().get(index).toString() + " -> " + object.toString());
            dao.update(index, object);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void delete(String unique_key, boolean deleteAssociation) {
        try {
            T object = search(unique_key);
            if (object == null) {
                throw new RuntimeException("Delete Error: Entity not found");
            }
            Logger.info("Deleting entity: " + object.toString());
            dao.delete(object);
            afterDelete(object, deleteAssociation);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<T> viewAll() {
        return dao.listAll();
    }
}