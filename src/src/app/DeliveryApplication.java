package app;
import gui.Button;
import gui.Checkbox;
import gui.GUIFactory;
import logistics.Logistics;
public class DeliveryApplication {
    private GUIFactory guiFactory;
    private Logistics logistics;
    public DeliveryApplication(GUIFactory guiFactory, Logistics logistics){
        this.guiFactory = guiFactory;
        this.logistics = logistics;
    }

    public void start(){
        Button button = guiFactory.createButton();
        Checkbox checkbox = guiFactory.createCheckbox();
        System.out.println("\n--- User Interface ---");
        button.paint();
        checkbox.paint();

        System.out.println("\n--- Delivery ---");
        logistics.planDelievery(
                "labaratory equipment",
                "Aktau warehouse"
        );
    }
}
