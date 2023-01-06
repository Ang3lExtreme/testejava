package product;

public interface ReceiptInterface {
    String getId();
    double getPrice();
    int getQuantity();
    float getTax();
    String getRef();
    boolean checkConsistency();
    String toString();
}
