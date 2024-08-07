package br.com.ifpe.oficina.entities.abstractclasses;

public class CarEngine {
    private String type;
    private int cv;
    private int rpm;

    public CarEngine(int cv, int rpm, String type) {
        this.cv = cv;
        this.rpm = rpm;
        this.type = type;
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    public int getRpm() {
        return rpm;
    }

    public void setRpm(int rpm) {
        this.rpm = rpm;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
