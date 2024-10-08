package br.com.ifpe.oficina.persistence;

import java.util.List;
import java.util.function.Predicate;

public interface IGenericDAO<T> {
    void insert(T object);

    T read(Predicate<T> filter);

    void update(int index, T object);

    void delete(T object);

    List<T> listAll();
}