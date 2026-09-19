package logistics;

public class Truck implements Transport{
    @Override
    public void deliever(String cargo, String destination){
        System.out.println("Truck delievers" + cargo + "to" + destination);
        System.out.println("Delievery goes by road.");
    }
}
