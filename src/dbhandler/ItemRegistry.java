package dbhandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains all calls to the store with the items that can be purchased.
 */
public class ItemRegistry {
    private List<ItemDTO> items = new ArrayList<>();
    
    ItemRegistry() {
        addItems();
    }
    /**
     * Search for an item that matches the search criteria.
     * 
     * @param name This object contains the information about the item.
     * 
     * @return The item from the registry with matching identifier
     */
    public ItemDTO findItem(String name) {
        for(ItemDTO item: items) {
            if(item.getName().equals(name))
                return new ItemDTO(item);
        }
        return null;
    }
    /**
     * Adds more items to the registry
     */
    public void addItems() {
        items.add(new ItemDTO("Apple", "a delicious apple", 5, 0.1));
        items.add(new ItemDTO("Pear", "a well-oiled pear", 4, 0.095));
        items.add(new ItemDTO("Banana", "a beautifully rotten banana", 3, 0.09));
    }
    
    /**
     * 
     * @param index index that the item is received fro
     * 
     * @return The item in the registry list 
     */
    public ItemDTO getItem(int index){
        return items.get(index);
    }
}
