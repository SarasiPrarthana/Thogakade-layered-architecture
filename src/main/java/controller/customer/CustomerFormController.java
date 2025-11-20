package controller.customer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.CustomerDTO;
import model.ItemDTO;
import service.customer.CustomerControllerImpl;
import service.customer.CustomerService;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerFormController implements Initializable {

    CustomerService customerService = new CustomerControllerImpl();

    ObservableList<CustomerDTO> customerDTOS = FXCollections.observableArrayList();

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colDOB;

    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPostalCode;

    @FXML
    private TableColumn<?, ?> colProvince;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    private TableColumn<?, ?> colTitle;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtCustID;

    @FXML
    private TextField txtDOB;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPostalCode;

    @FXML
    private TextField txtProvince;

    @FXML
    private TextField txtSalary;

    @FXML
    private TableView<CustomerDTO> txtTbl;

    @FXML
    private TextField txtTitle;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        loadCustomerDetails();

        txtTbl.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValues) -> {
            if (newValues!= null) {
                setSelectedValue(newValues);
            }
        });
    }

    @FXML
    void btnAddAction(ActionEvent event) {

        String customerID = txtCustID.getText();
        String title = txtTitle.getText();
        String name = txtName.getText();
        String dob = txtDOB.getText();
        double salary = Double.parseDouble(txtSalary.getText());
        String address = txtAddress.getText();
        String city = txtCity.getText();
        String province = txtProvince.getText();
        String postalCode = txtPostalCode.getText();

//        CustomerController customerController  = new CustomerController();
        customerService.addCustomerDetails(customerID,title,name,dob,salary,address,city,province,postalCode);
        loadCustomerDetails();
        clearFields();

    }

    @FXML
    void btnClearAction(ActionEvent event) {

        txtCustID.setText("");
        txtTitle.setText("");
        txtName.setText("");
        txtDOB.setText("");
        txtSalary.setText("");
        txtAddress.setText("");
        txtCity.setText("");
        txtProvince.setText("");
        txtPostalCode.setText("");
    }

    @FXML
    void btnDeleteAction(ActionEvent event) {

        customerService.deleteCustomerDetails(txtCustID.getText());
        clearFields();
        loadCustomerDetails();
    }

    @FXML
    void btnUpdateAction(ActionEvent event) {

        String customerID = txtCustID.getText();
        String title = txtTitle.getText();
        String name = txtName.getText();
        String dob = txtDOB.getText();
        double salary = Double.parseDouble(txtSalary.getText());
        String address = txtAddress.getText();
        String city = txtCity.getText();
        String province = txtProvince.getText();
        String postalCode = txtPostalCode.getText();

        customerService.updateCustomerDetails(customerID,title,name,dob,salary,address,city,province,postalCode);
        loadCustomerDetails();
        clearFields();

    }

    private void loadCustomerDetails() {

        customerDTOS.clear();
        txtTbl.setItems(customerService.loadCustomerDetails());
    }

    public void clearFields(){
        txtCustID.clear();
        txtTitle.clear();
        txtName.clear();
        txtDOB.clear();
        txtSalary.clear();
        txtAddress.clear();
        txtCity.clear();
        txtProvince.clear();
        txtPostalCode.clear();
    }
    private void setSelectedValue(CustomerDTO selectedValue){
        if(selectedValue == null){
            clearFields();
            return;
        }
        txtCustID.setText(selectedValue.getCustomerID());
        txtTitle.setText(selectedValue.getTitle());
        txtName.setText(selectedValue.getName());
        txtDOB.setText(selectedValue.getDob());
        txtSalary.setText(String.valueOf(selectedValue.getSalary()));
        txtAddress.setText(selectedValue.getAddress());
        txtCity.setText(selectedValue.getCity());
        txtProvince.setText(selectedValue.getProvince());
        txtPostalCode.setText(selectedValue.getPostalCode());

    }
}
