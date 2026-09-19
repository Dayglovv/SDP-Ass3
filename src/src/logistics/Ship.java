package logistics;

public class Ship implements Transport {
    @Override
    public void deliever (String cargo, String destination){
        System.out.println("Ship delievers " + cargo + "to " +destination);
        System.out.println("Delievery goes by sea.");
    }
}
