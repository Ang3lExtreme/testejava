package product;

public class Purchase extends Receipt {

    private String companyRef;

    public Purchase(String id, double price, int quantity, float tax, String companyRef) {
        super(id, price, quantity, tax);
        this.companyRef = companyRef;
    }

    @Override
    public String getRef() {
        return companyRef;
    }

    @Override
    public boolean checkConsistency() {
        return super.checkConsistency() && companyRef != null;
    }
}
