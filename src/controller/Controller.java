package controller;

import model.Sale;
import dbhandler.ItemDTO;
import dbhandler.Printer;
import dbhandler.RegistryCreator;
import dbhandler.AccountingSystem;
import dbhandler.InventorySystem;
import dbhandler.ItemRegistry;
/**
 * @author Gabriel Blid
 */
public class Controller {
    private Sale sale;
    private ItemRegistry itemRegistry;
    private AccountingSystem accountingSystem;
    private InventorySystem inventorySystem;
    private Printer printer;

    /**
     * Creates a new instance
     * 
     * @param regCreator Used to get all classes that handle database calls.
     * @param printer Printer that prints the receipt.
     * @param accountingSystem external accounting system.
     * @param inventorySystem external inventory system.
     */
    public Controller(RegistryCreator regCreator, Printer printer,
         AccountingSystem accountingSystem, InventorySystem inventorySystem) {
        this.itemRegistry = regCreator.getItemRegistry();
        this.printer = printer;
        this.accountingSystem = accountingSystem;
        this.inventorySystem = inventorySystem; 
    }
    
    /**
     * Creates an empty instance of {@link Sale}, which will be used for all
     * information regarding the sale that is now started
     */
    public void startSale() {
        sale = new Sale();
    }
    
    /**
     * Creates a new instace with the registry only.
     * @param regCreator the object that creates registries.
     */
    public Controller(RegistryCreator regCreator) {
        this.itemRegistry = regCreator.getItemRegistry();
    }
    
    /**
     * Takes the entered name and finds the equal item and then adds it
     * to the sale and returns sale information
     * 
     * @param name the name of the searched item
     * 
     * @return updated sale information that is sent to the view. 
     */
    public String enterItemID(String name) {
        ItemDTO item = itemRegistry.findItem(name);
        return sale.addItem(item);
    }
    
    /**
     * Takes an entered name and finds the equal item and adds the specified 
     * quantity to the sale and returns information about the sale
     * 
     * @param name the name of the item.
     * @param quantity the quantity of the item
     * 
     * @return  the updated sake information is sent to the view.
     */
    public String enterItemIDAndQuantity(String name, int quantity) {
        ItemDTO item = itemRegistry.findItem(name);
        return sale.addItems(item, quantity);
    }
  
    /**
     * Calculates the taxes after all items has been registered
     * @return the total tax amount from the sale.
     */
    public double indicateAllItemsRegistered() {
        return sale.calculateTaxes();

    }
    
    /**
     * Calculates the change based on the running total and
     * the paid amount. Also prints a receipt and displays the change.
     * 
     * @param paidAmount the amount paid by the customer.
     * 
     * @return the change that the customer shall have. 
     */
    public double enterPaidCash(double paidAmount) {
        double changeAmount = sale.calculateChange(paidAmount);
        sale.printReceipt(printer);
        accountingSystem.updateAccounting(sale);
        inventorySystem.updateInventory(sale);
        return changeAmount;
    }
    
}
