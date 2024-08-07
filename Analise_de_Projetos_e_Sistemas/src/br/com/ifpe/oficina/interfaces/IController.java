package br.com.ifpe.oficina.interfaces;

import java.util.List;

public interface IController<T> {
    void create(T object, String... accessories);

    T read(String unique_key);

    void update(T object, String...accessories);

    void delete(String unique_key);

    List<T> viewAll();
}