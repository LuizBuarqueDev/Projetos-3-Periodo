package br.com.ifpe.oficina.services.controllers;

import br.com.ifpe.oficina.persistence.GenericDAO;
import br.com.ifpe.oficina.persistence.Logger;

import java.util.List;

public abstract class GenericController<T> {

    protected GenericDAO<T> dao;
        public GenericController(GenericDAO<T> dao) {
        this.dao = dao;
    }

    protected void insert(T object) {
        try {
            this.validateInsert(object);
            Logger.info("Inserindo entidade: " + object.toString() + "\n");
            dao.insert(object);

        } catch (Exception e) {
            Logger.error(e.getMessage());
        }
    }

    protected void update(T object){

    }

    protected void read () {

    }

    protected void delete (){

    }

    protected List<T> listAll(){
            return dao.viewAll();
    }

    protected abstract void validateInsert (T object);
}