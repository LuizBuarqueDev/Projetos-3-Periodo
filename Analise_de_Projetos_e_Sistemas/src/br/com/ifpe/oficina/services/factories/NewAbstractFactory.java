package br.com.ifpe.oficina.services.factories;

import br.com.ifpe.oficina.interfaces.INewAbstactFactory;

public class NewAbstractFactory<T> implements INewAbstactFactory<T> {
	
	@Override
	public T create(Class<T> objectType) {
		try {
			return objectType.getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
