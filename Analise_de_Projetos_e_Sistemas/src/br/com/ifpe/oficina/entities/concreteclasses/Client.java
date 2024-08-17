package br.com.ifpe.oficina.entities.concreteclasses;

import br.com.ifpe.oficina.entities.decorator.IBasicCar;

public class Client {
    private String name;
    private String cpf;
    private int age;
    private String email;
    private IBasicCar car;

    private Client(int age, IBasicCar car, String cpf, String email, String name) {
        this.age = age;
        this.car = car;
        this.cpf = cpf;
        this.email = email;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", car plate=" + car.getInnerCar().getPlate() +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public IBasicCar getCar() {
        return car;
    }

    public void setCar(IBasicCar car) {
        this.car = car;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static final class ClientBuilder {
        private int age;
        private String name;
        private String cpf;
        private String email;
        private IBasicCar car;

        private ClientBuilder() {
        }

        public static ClientBuilder aClient() {
            return new ClientBuilder();
        }

        public ClientBuilder age(int age) {
            this.age = age;
            return this;
        }

        public ClientBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ClientBuilder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public ClientBuilder email(String email) {
            this.email = email;
            return this;
        }

        public ClientBuilder car(IBasicCar car) {
            this.car = car;
            return this;
        }

        public Client build() {
            return new Client(age, car, cpf, email, name);
        }
    }
}