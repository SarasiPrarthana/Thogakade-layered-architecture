package service.item;

import javafx.collections.ObservableList;
import model.ItemDTO;
import repository.item.ItemRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemControllerImpl implements ItemService {

    ItemRepository itemRepository = new ItemRepository();

    @Override
    public void addItemDetails(String itemCode, String description, String PackSize, double unitPrice, int qtyOnHand) {

//        ItemRepository itemRepository = new ItemRepository();
        itemRepository.addItemDetails(itemCode,description,PackSize,unitPrice,qtyOnHand);

    }

    @Override
    public void deleteItemDetails(String itemCode) {

        itemRepository.deleteItemDetails(itemCode);

    }

    @Override
    public void updateItemDetails(String itemCode, String description, String PackSize, double unitPrice, int qtyOnHand) {

        itemRepository.updateItemDetails(itemCode,description,PackSize,unitPrice,qtyOnHand);

    }

    @Override
    public ObservableList<ItemDTO> getAllItemDetails() {
        ObservableList<ItemDTO> itemDetails = javafx.collections.FXCollections.observableArrayList();

        try {
            ItemRepository itemRepository = new ItemRepository();
            ResultSet allItems = itemRepository.getAllItemDetails();

            while (allItems.next()){
                itemDetails.add(new ItemDTO(
                        allItems.getString("ItemCode"),
                        allItems.getString("Description"),
                        allItems.getString("PackSize"),
                        allItems.getDouble("UnitPrice"),
                        allItems.getInt("QtyOnHand")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return itemDetails;
    }


}
