package model;

public class Battery{
    
    private String name;
    private double voltaje;
    private double cost;
    private double capacity;


    public Battery(String name, double voltaje, double cost, double capacity) {
        this.name = name;
        this.voltaje = voltaje;
        this.cost = cost;
        this.capacity = capacity;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getVoltaje() {
        return this.voltaje;
    }

    public void setVoltaje(double voltaje) {
        this.voltaje = voltaje;
    }

    public double getCost() {
        return this.cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getCapacity() {
        return this.capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }


}
