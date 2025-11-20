package service.customer;

import javafx.collections.ObservableList;
import model.CustomerDTO;

public interface CustomerService {

    ObservableList<CustomerDTO> loadCustomerDetails();

    void addCustomerDetails(String customerID,String title,String name,String dob,double salary,String address,String city,String province,String postalCode);

    void deleteCustomerDetails(String customerId);

    void updateCustomerDetails(String customerID,String title,String name,String dob,double salary,String address,String city,String province,String postalCode);

}
