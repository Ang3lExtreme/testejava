package customer;

import product.Selling;

import java.util.ArrayList;
import java.util.List;

public final class Company extends Customer {

    private final String nipc;
    private List<Selling> sellings;

    public Company(String name, String email, String nipc) {
        super(name, email);
        this.nipc = nipc;
        this.sellings = new ArrayList<>();
    }

    //Getters
    @Override
    public String getIdentificationNumber() {
        return nipc;
    }

    @Override
    public List list() {
        return sellings;
    }

    @Override
    public boolean checkConsistency() {
        return super.checkConsistency() && nipc != null;
    }

    @Override
    public void addProduct(Object product) {
        sellings.add((Selling) product);
    }
}
