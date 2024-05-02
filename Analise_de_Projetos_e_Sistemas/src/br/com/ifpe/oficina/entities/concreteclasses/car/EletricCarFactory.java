package br.com.ifpe.oficina.entities.concreteclasses.car;

import br.com.ifpe.oficina.entities.abstractclasses.Car;
import br.com.ifpe.oficina.interfaces.ICarFactory;

public class EletricCarFactory extends Car implements ICarFactory {

    private static EletricCarFactory instance = new EletricCarFactory();
    private int batteryCapacity; // Novo atributo

    public static EletricCarFactory getInstance() {
        return instance;
    }

    public EletricCarFactory() {
        // Construtor padrão
    }

    public EletricCarFactory(String plate, String chassis, int age, int batteryCapacity) {
        super(plate, chassis, age);
        this.engine = "Electric engine";
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public Car createCar(String plate, String chassis, int age) {
        return new EletricCarFactory(plate, chassis, age, batteryCapacity);
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public String toString() {
        return "EletricCarFactory [plate=" + plate + ", chassis=" + chassis + ", age=" + age + ", engine=" + engine
                + ", batteryCapacity=" + batteryCapacity + "]"; // Atualização para incluir o novo atributo
    }
}