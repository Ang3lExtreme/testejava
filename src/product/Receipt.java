package product;

public abstract class Receipt implements ReceiptInterface {

    private String id;
    private double price;
    private int quantity;
    private float tax;

    public Receipt(String id, double price, int quantity, float tax) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.tax = tax;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getTax() {
        return tax;
    }

    public abstract String getRef();

    public boolean checkConsistency() {
        return !id.equals("") && id != null && price > 0 && quantity > 0 && tax > 0;

    }

    public String toString() {
        return "ID: " + id + " Price: " + price + " Quantity: " + quantity + " Tax: " + tax + " Ref: " + getRef();
    }




}
