package service.customer;

import javafx.collections.ObservableList;
import model.CustomerDTO;
import repository.customer.CustomerRepository;
import repository.customer.CustomerRepositoryImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerControllerImpl implements CustomerService{

    CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();

        @Override
        public ObservableList<CustomerDTO> loadCustomerDetails(){
            ObservableList<CustomerDTO> customerDetails = javafx.collections.FXCollections.observableArrayList();


            try {
                ResultSet resultSet = customerRepository.loadCustomerDetails();

                while (resultSet.next()){
                    customerDetails.add(new CustomerDTO(
                            resultSet.getString("CustID"),
                            resultSet.getString("CustTitle"),
                            resultSet.getString("CustName"),
                            resultSet.getString("DOB"),
                            resultSet.getDouble("salary"),
                            resultSet.getString("CustAddress"),
                            resultSet.getString("City"),
                            resultSet.getString("Province"),
                            resultSet.getString("PostalCode")
                    ));
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return customerDetails;
        }

        @Override
        public void addCustomerDetails(String customerID, String title, String name, String dob, double salary, String address, String city, String province, String postalCode) {

            customerRepository.addCustomerDetails(customerID,title,name,dob,salary,address,city,province,postalCode);
        }

        @Override
        public void deleteCustomerDetails(String customerId) {

            customerRepository.deleteCustomerDetails(customerId);

        }

        @Override
        public void updateCustomerDetails(String customerID, String title, String name, String dob, double salary, String address, String city, String province, String postalCode) {

            customerRepository.updateCustomerDetails(customerID,title,name,dob,salary,address,city,province,postalCode);

        }

}
