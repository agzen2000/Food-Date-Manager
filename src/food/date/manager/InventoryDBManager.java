package food.date.manager;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Akash
 */
public class InventoryDBManager {
    private static InventoryDBManager instance;
    private static final String DB_LOCATION = "jdbc:mysql://localhost:3306/inventory";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "hello";
    private Connection conn;
    private Statement sqlState;
    private InventoryDBManager() {                
        try{
            conn = DriverManager.getConnection(DB_LOCATION, DB_USER, DB_PASSWORD);
            sqlState= conn.createStatement();
            ResultSet tables = sqlState.executeQuery("show tables;");
            tables.first();
            if(tables.getRow()==0) {
                createTables();
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public int getFreshness(String itemNumber) throws SQLException {
        String query = "SELECT * FROM items WHERE item_number = " + itemNumber + ";";
        ResultSet r = sqlState.executeQuery(query);
        r.first();
        return r.getInt("freshness_period");

    }
    
    public void deleteItem(String[] row) {
        try {
            int i = 0;
            if(row[3].equals("true")) {
                FoodMap.getInstance().deleteItem(row);
                i = 1;
            }
            String date = new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("MM-dd-yyyy").parse(row[2]));
            String query = "SELECT * FROM items WHERE item_number = " + row[0];
            ResultSet r = sqlState.executeQuery(query);
            r.first();
            row[0] = ""+r.getInt("item_id");
            query = "SELECT * FROM packets WHERE item_id = " + row[0] + " AND "
                + "sell_by = '" + date + "' AND "
                + "opened = " + i + ";";
            r = sqlState.executeQuery(query);
            r.first();
            int packetID = r.getInt("packet_id");
            query = "DELETE FROM packets WHERE packet_id = " + packetID;
            sqlState.execute(query);
        } catch (Exception ex) {
            Logger.getLogger(InventoryDBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void openPacket(String itemNumber, String oldExpire, String newExpire) {
        try {
            oldExpire = new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("MM-dd-yyyy").parse(oldExpire));
            newExpire = new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("MM-dd-yyyy").parse(newExpire));
            String query = "SELECT * FROM items WHERE item_number = " + itemNumber + ";";
            ResultSet r = sqlState.executeQuery(query);
            r.first();
            int itemId = r.getInt("item_id");
            query = "SELECT * FROM packets WHERE item_id = " + itemId + " AND sell_by = '"+oldExpire+"' AND opened = 0;";
            r = sqlState.executeQuery(query);
            r.first();
            String packetId = r.getString("packet_id");
            query = "UPDATE packets SET opened = 1, sell_by = '"+newExpire+"' WHERE packet_id = " + packetId + ";";
            sqlState.execute(query);
        } catch (Exception ex) {
            Logger.getLogger(InventoryDBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String[] findClosed(String itemNumber) throws SQLException {
        String[] item = {itemNumber,"","","false"};
        String query = "SELECT * FROM items WHERE item_number = " + itemNumber + ";";
        ResultSet r = sqlState.executeQuery(query);
        if(!r.first()) {
            return null;
        }
        int itemId = r.getInt("item_id");
        item[1] = r.getString("name");
        java.sql.Date date = null;
        java.sql.Date temp;
        query = "SELECT * FROM packets WHERE item_id = " + itemId + " AND opened = 0;";
        r = sqlState.executeQuery(query);
        if(!r.first()) {
            return null;
        }
        do {
            temp = r.getDate("sell_by");
            if(date==null || date.compareTo(temp) > 0) {
                date = temp;                
            }
        } while (r.next());
        item[2] = new SimpleDateFormat("MM-dd-yyyy").format(date);
        return item;
    }
    
    public void addItemType(String number, String name, String freshness) {
        try {
            String query = "INSERT INTO items (item_number, name, freshness_period) VALUES ("
                    + number + ",'"
                    + name + "',"
                    + freshness + ");";
            sqlState.execute(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String[][] getExpired() throws SQLException {
        String getQuery = "SELECT * FROM packets WHERE sell_by < '" 
                + new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()) + "';";
        ResultSet items = sqlState.executeQuery(getQuery);
        items.last();
        int lastRow = items.getRow();
        String[][] inventory = new String[lastRow][4]; 
        items.first();
        for(int i = 0; i < lastRow; i++) {
            inventory[i][0] = "" + items.getInt("item_id");
            inventory[i][2] = new SimpleDateFormat("MM-dd-yyyy").format(items.getDate("sell_by"));
            inventory[i][3] = "" + items.getBoolean("opened");
            
            items.next();
        }
        
        for(int i = 0; i < lastRow; i++) {
            getQuery = "SELECT * FROM items WHERE item_id = " + inventory[i][0] + ";";
            items = sqlState.executeQuery(getQuery);
            items.first();
            inventory[i][0] = items.getString("item_number");
            inventory[i][1] = items.getString("name");
            
        }
        return inventory;
        
    }
    
    public String[][] getInventory() throws SQLException {
        String getQuery = "SELECT * FROM packets;";
        ResultSet items = sqlState.executeQuery(getQuery);
        items.last();
        int lastRow = items.getRow();
        String[][] inventory = new String[lastRow][4]; 
        items.first();
        for(int i = 0; i < lastRow; i++) {
            inventory[i][0] = "" + items.getInt("item_id");
            inventory[i][2] = new SimpleDateFormat("MM-dd-yyyy").format(items.getDate("sell_by"));
            inventory[i][3] = "" + items.getBoolean("opened");
            
            items.next();
        }
        
        for(int i = 0; i < lastRow; i++) {
            getQuery = "SELECT * FROM items WHERE item_id = " + inventory[i][0] + ";";
            items = sqlState.executeQuery(getQuery);
            items.first();
            inventory[i][0] = items.getString("item_number");
            inventory[i][1] = items.getString("name");
            
        }
        return inventory;
    }
    
    public String[] getItemTypes() throws SQLException {
        String getQuery = "SELECT * FROM items;";
        ResultSet items = sqlState.executeQuery(getQuery);
        items.last();
        int lastRow = items.getRow();
        String[] itemTypes = new String[lastRow];
        items.first();
        for(int i = 0; i < lastRow; i++) {
            itemTypes[i] = items.getString("name");
            items.next();
        }
        return itemTypes;    
}
    
    public boolean addItem(String itemType, java.util.Date date, boolean opened) {
        try {
            String query = "SELECT * FROM items WHERE name = '" + itemType + "';";
            ResultSet result = sqlState.executeQuery(query);
            result.first(); 
            int itemId = result.getInt("item_id");
            String number = result.getString("item_number");
            int i = 0;
            String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(date);
            if(opened  == true) {
                if(FoodMap.getInstance().containsKey(number)) {
                    return false;
                }
                
                i = 1;
                FoodMap.getInstance().addItem(new String[] {itemId + "", itemType, dateStr, opened + ""});
            }
            query = "INSERT INTO packets (item_id, sell_by, opened) VALUES("
                    + itemId + ",'"
                    + dateStr + "',"
                    + i +");";
            sqlState.execute(query);
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    
    public Set<String[]> getOpenedChubs() {
        Set<String[]> opened = new HashSet<>();
        try {            
            String getQuery = "SELECT * FROM packets WHERE opened = true;";
            ResultSet items = sqlState.executeQuery(getQuery);
            items.last();
            int lastRow = items.getRow();
            items.first();
            String[][] inventory = new String[lastRow][4];
            for(int i = 0; i < lastRow; i++) {
                inventory[i][0] = "" + items.getInt("item_id");
                inventory[i][2] = new SimpleDateFormat("MM-dd-yyyy").format(items.getDate("sell_by"));
                inventory[i][3] = "" + items.getBoolean("opened");

                items.next();
            }

            for(int i = 0; i < lastRow; i++) {
                getQuery = "SELECT * FROM items WHERE item_id = " + inventory[i][0] + ";";
                items = sqlState.executeQuery(getQuery);
                items.first();
                inventory[i][0] = items.getString("item_number");
                inventory[i][1] = items.getString("name");
                opened.add(inventory[i]);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return opened;
    }
    
    public void reset() {
        try{
            String dropQuery = "DROP TABLE IF EXISTS packets;";
            sqlState.execute(dropQuery);
            dropQuery = "DROP TABLE IF EXISTS items;";
            sqlState.execute(dropQuery);
            createTables();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    private void createTables() {
        try{
            String tableQuery = "CREATE TABLE packets "
                    + "("
                    + "item_id INT NOT NULL,"
                    + "packet_id INT UNSIGNED NOT NULL AUTO_INCREMENT,"
                    + "sell_by DATE NOT NULL,"
                    + "opened BOOLEAN NOT NULL,"
                    + "PRIMARY KEY(packet_id)"
                    + ");";
            sqlState.execute(tableQuery);
            
            tableQuery = "CREATE TABLE items "
                    + "("
                    + "item_id INT NOT NULL AUTO_INCREMENT,"
                    + "item_number INT NOT NULL,"
                    + "name VARCHAR(25) NOT NULL,"
                    + "freshness_period TINYINT UNSIGNED NOT NULL,"
                    + "PRIMARY KEY(item_id)"
                    + ");";
            sqlState.execute(tableQuery);

            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static InventoryDBManager getInstance() {
        if(instance==null) {
            instance = new InventoryDBManager();
        }
        return instance;
    }
}