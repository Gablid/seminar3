package view;

import controller.Controller;

/**
 * placeholder for the view that contains hardcoded calls to the controller.
 */
public class View {  
    private Controller contr;
    
    /**
     * Creates a new instance.
     * 
     * @param contr  The controller that is used for all operations.
     */
    public View(Controller contr) {
        this.contr = contr;
    }
    
    /**
     * Simulates user input that generates calls to 
     * the different system operations.
     */
    public void sampleExecution() {
        System.out.println("Starting sample execution");
        contr.startSale();
        System.out.println("After call to startSale()");
        
        System.out.println(contr.enterItemID("Apple"));
        System.out.println(contr.enterItemIDAndQuantity("Pear", 2));
        System.out.println(contr.enterItemIDAndQuantity("Banana", 3));
        System.out.println(contr.enterItemIDAndQuantity("Apple", 2));
        System.out.println(contr.enterItemID("Pear"));
        System.out.println(contr.enterItemID("Banana"));
        System.out.println(contr.enterItemID("Pear"));
        System.out.println(contr.enterItemID("Banana"));
        System.out.println(contr.indicateAllItemsRegistered());
        System.out.println(contr.enterPaidCash(75));
        
    }
}
