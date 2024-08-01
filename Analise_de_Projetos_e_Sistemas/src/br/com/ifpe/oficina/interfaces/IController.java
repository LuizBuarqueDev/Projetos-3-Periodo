package br.com.ifpe.oficina.interfaces;

import java.util.List;

public interface IController<T> {
    void create(String... attributes);

    T read(String unique_key);

    void update(String... attributes);

    void delete(String unique_key);

    List<T> viewAll();
}