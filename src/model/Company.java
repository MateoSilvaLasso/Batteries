package model;

public class Company{
	
    public static final int MAX_BATTERIES = 10;
	private Battery[] batteries;

	public Company() {
        this.batteries = new Battery[MAX_BATTERIES];
	}

    public Company(Battery[] batteries){
        this.batteries = batteries;
    }
	

    public void registerBattery(String name, double voltage, double cost, double capacity){
        int emtyPos = getEmtyPosition();
        batteries[emtyPos] = new Battery(name, voltage, cost, capacity);

    }

    public void registerRechargeableBattery(String name, double voltage, double cost, double capacity, int chargerNumber, char type) {
        int emtyPos = getEmtyPosition();
        batteries[emtyPos] = new RechargeableBattery(name, voltage, cost, capacity, chargerNumber ,type);
        
    }
    
    private int getEmtyPosition() {
        int pos = -1;
        for (int i = 0; i < MAX_BATTERIES && pos == -1; i++) {
            if (batteries[i] == null) {
                pos = i;
            }
        }
        return pos;
    }
    
    public String showBatteriesInfo() {
    	String str = "";
        for(int i=0; i<MAX_BATTERIES; i++){
            if(batteries[i]!=null && batteries[i] instanceof RechargeableBattery){
                str+="bateria recargable \n"+ batteries[i].getName()+"\n"+((RechargeableBattery)batteries[i]).calculateUsefulLifeCost()+"\n";
            }else if(batteries[i]!=null && batteries[i] instanceof Battery) {
                str+="bateria no recargable \n"+ batteries[i].getName()+"\n"+"no tiene vida util\n";
            }
        }
    	return str;
    }
    

	public double calculateUsefulPromLifeCost(){
        double life=0;
        int total=0;
        double prom=0;
		for(int i=0; i<MAX_BATTERIES; i++){
            if(batteries[i]!=null &&  batteries[i] instanceof RechargeableBattery){
                life+=(((RechargeableBattery)batteries[i]).calculateUsefulLifeCost());
                total++;
            }
        }

        prom=life/total;
       return prom;
	}

    public String showTotalBatteries(){
        int amountR=0;
        int amountN=0;
        for(int i=0; i<MAX_BATTERIES; i++){
            if(batteries[i] instanceof RechargeableBattery){
                amountR++;
            }else{
                amountN++;
            }
        }

        return "In this moment there are/is "+ amountR+" Rechargeable batteries and there are/is "+amountN+" normal batteries";
    }

}
