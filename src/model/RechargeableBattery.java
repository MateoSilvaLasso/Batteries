package model;

public class RechargeableBattery extends Battery implements Rechargeable{

    public static final char BATTERY_LITIO='l';
    public static final char BATTERY_NIQUEL_CADIO='n';
    public static final double FACTOR_LITIO=0.92;
    public static final double FACTOR_NIQUEL_CADIO=0.8;
    
    private int chargerNumber;
    private char type;

    public RechargeableBattery(String name, double voltaje, double cost, double capacity, int chargerNumber, char type){
        super(name, voltaje, cost, capacity);
        this.chargerNumber = chargerNumber;
        this.type=type;
    }

    public int getChargerNumber() {
        return this.chargerNumber;
    }

    public void setChargerNumber(int chargerNumber) {
        this.chargerNumber = chargerNumber;
    }

    public double calculateUsefulLifeCost(){
        double cost=0;
        if(type=='l'){
             cost= (super.getCost()*super.getVoltaje()*super.getCapacity())/(1000*chargerNumber*FACTOR_LITIO) ;
        }else if(type=='n'){
             cost= (super.getCost()*super.getVoltaje()*super.getCapacity())/(1000*chargerNumber*FACTOR_NIQUEL_CADIO) ;
        }
        
        
        return cost;
    }


    
}
