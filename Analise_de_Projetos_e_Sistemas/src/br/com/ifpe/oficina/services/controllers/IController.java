package br.com.ifpe.oficina.services.controllers;

import java.util.List;

public interface IController<T> {
    void create(T object);

    T read(String unique_key);

    void update(T object);

    void delete(String unique_key, boolean deleteAssociation);

    List<T> viewAll();
}