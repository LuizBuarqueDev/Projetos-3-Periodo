package br.com.ifpe.oficina.services.factories;

import br.com.ifpe.oficina.persistence.GenericDAO;

public class DAOFactory {
    public static <T> GenericDAO<T> createDAO(Class<T> type) {
        return new GenericDAO<>();
	}
}