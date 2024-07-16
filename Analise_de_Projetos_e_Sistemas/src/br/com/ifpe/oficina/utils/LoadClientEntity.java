package br.com.ifpe.oficina.utils;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import br.com.ifpe.oficina.entities.abstractclasses.Car;
import br.com.ifpe.oficina.entities.concreteclasses.Client;
import br.com.ifpe.oficina.entities.concreteclasses.JeepCar;
import br.com.ifpe.oficina.entities.concreteclasses.SilkCar;
import br.com.ifpe.oficina.services.controllers.CarController;
import br.com.ifpe.oficina.services.controllers.ClientController;
import br.com.ifpe.oficina.services.factories.EletricCarFactory;
import br.com.ifpe.oficina.services.factories.JeepFactory;
import br.com.ifpe.oficina.services.factories.NewAbstractFactory;
import br.com.ifpe.oficina.services.factories.SilkFactory;

public class LoadClientEntity {
	
	private static final LoadClientEntity instance = new LoadClientEntity();
	
	private CarController carController = CarController.getInstance();
	private ClientController clientController =  ClientController.getInstance();
	
	private LoadClientEntity() {}

	public static LoadClientEntity getinstance() {
		return instance;
	}
	
	Random random = new Random();
	
    public void createRandomData() {
        generateClients(50);
        generateCars(50);
    }

    private void generateClients(int quantity) {
        Set<String> usedCpfs = new HashSet<>();

        for (int i = 0; i < quantity; i++) {
            String cpf;
            do {
                cpf = String.format("%011d", 111248547 + i);
            } while (!usedCpfs.add(cpf));
            Client client = Client.ClientBuilder()
                    .age(20 + i)
                    .affiliate(i % 3 == 0)
                    .cpf(cpf)
                    .email("cliente" + i + "@gmail.com")
                    .name("cliente" + i)
                    .build();
            
            clientController.viewAll().add(client);
        }
    }

    private void generateCars(int quantity) {
        for (int i = 0; i < quantity; i++) {
            int key = random.nextInt(3);
            Client client = clientController.viewAll().get(i);

            switch (key) {
                case 0: {
                    Car car = EletricCarFactory.eletricCarFactory().create();
                    car.setClient(client);
                    car.setPlate("ABC-" + i);
                    car.setTraction("4x2");
                    carController.viewAll().add(car);
                    client.setCar(car);
                    break;
                }
                case 1: {
                    Car car = JeepFactory.jeepFactory().create();
                    car.setClient(client);
                    car.setPlate("DEF-" + i);
                    car.setTraction("4x4");
                    ((JeepCar) car).setDifferentialLock(false);

                    carController.viewAll().add(car);
                    client.setCar(car);
                    break;
                }
                case 2: {
                    Car car = SilkFactory.silkFactory().create();
                    car.setClient(client);
                    car.setPlate("GHI-" + i);
                    car.setTraction("4x2");

                    carController.viewAll().add(car);
                    client.setCar(car);
                    break;
                }
                default:
                    System.out.println("Unexpected value: " + key);
            }
        }
    }
}