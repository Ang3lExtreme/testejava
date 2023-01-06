package product;

public class Selling extends Receipt {
    private String customerRef;

    public Selling(String id, double price, int quantity, float tax, String customerRef) {
        super(id, price, quantity, tax);
        this.customerRef = customerRef;
    }

    @Override
    public String getRef() {
        return customerRef;
    }

    @Override
    public boolean checkConsistency() {
        return super.checkConsistency() && customerRef != null;
    }
}
