package customer;

import product.Receipt;

import java.util.List;

public abstract class Customer implements CustomerInterface {

    private final String name;
    private String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String setEmail(String email) {
        return this.email = email;
    }

    public abstract String getIdentificationNumber();

    public abstract List<Receipt> list();

    public void addProduct(Object product) {
        list().add((Receipt) product);
    }

    public boolean checkConsistency() {
        return !name.equals("") && name != null && !email.equals("") && email != null;
    }

    public String toString() {
        return "Name: " + name + " Email: " + email + " Identification Number: " + getIdentificationNumber();
    }





}
