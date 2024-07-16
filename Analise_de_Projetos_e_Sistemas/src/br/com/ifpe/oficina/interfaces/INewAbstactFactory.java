package br.com.ifpe.oficina.interfaces;

public interface INewAbstactFactory<T> {
	T create(Class<T> objectType);
}
