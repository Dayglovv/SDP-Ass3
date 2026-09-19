package logistics;

public abstract class Logistics {
    public abstract Transport createTransport();
    public void planDelievery(String cargo, String destination){
        System.out.println("\nPreparing delivery");
        Transport transport = createTransport();
        transport.deliver(cargo , destination);
        System.out.println("Delivery planned successfully.");
    }
}
