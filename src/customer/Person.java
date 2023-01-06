package customer;

import product.Purchase;

import java.util.ArrayList;
import java.util.List;

public final class Person extends Customer {

    private final String nif; //usei string pois o NIF pode começar com 0 ou ser demasiado grande para um int/long
    private List<Purchase> purchases;

    public Person(String name, String email, String nif) {
        super(name, email);
        this.nif = nif;
        this.purchases = new ArrayList<>();
    }

    @Override
    public String getIdentificationNumber() {
        return nif;
    }

    @Override
    public List list() {
        return purchases;
    }

    @Override
    public boolean checkConsistency() {
        return super.checkConsistency() && !nif.equals("") && nif != null;
    }

    @Override
    public void addProduct(Object product) {
        purchases.add((Purchase) product);
    }




}
