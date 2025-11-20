package repository.item;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ItemRepositoryImpl {

    ResultSet getAllItemDetails() throws SQLException;

    void addItemDetails(String itemCode, String description, String PackSize, double unitPrice, int qtyOnHand);
    void deleteItemDetails(String itemCode);
    void updateItemDetails(String itemCode, String description, String PackSize, double unitPrice, int qtyOnHand);

}