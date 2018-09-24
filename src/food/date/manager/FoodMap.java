package food.date.manager;

import java.util.*;

/**
 *
 * @author Akash
 */
public class FoodMap extends HashMap<String, String[]>{ 
    /*
    [0] - Item Number
    [1] - Item Name
    [2] - Sell By Date
    [3] - Opened
    */
    
    private static FoodMap instance;
    private InventoryDBManager inventory;
    
    private FoodMap() {
        inventory = InventoryDBManager.getInstance();
        Set<String[]> opened = inventory.getOpenedChubs();
        for(String[] item: opened) {
            this.put(item[0], item);
        }
    }
    
    public String getName(String itemNum) {
        return (this.get(itemNum))[1];
    }
    
    public void addItem(String[] item) {
        this.put(item[0], item);
    }
    
    public void deleteItem(String[] item) {
        this.remove(item[0]);
    }
    
    public boolean isOpened(String itemNum){
        return this.containsKey(itemNum); 
    }
    
    public static void reset() {
        instance = null;
    }
    
    public static FoodMap getInstance() {
        if(instance!=null) {
            return instance;
        } else {
            instance = new FoodMap();
            return instance;
        }
    }
}
