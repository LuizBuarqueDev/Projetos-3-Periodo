package br.com.ifpe.oficina.interfaces;

public interface ICarFactory {
	Engine createEngineType();
	Traction createTraction();
}
