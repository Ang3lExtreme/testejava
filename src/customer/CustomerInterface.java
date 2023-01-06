package customer;


import java.util.List;

public interface CustomerInterface<T> {
    String getName();
    String getEmail();
    String setEmail(String email);
    String getIdentificationNumber();
    boolean checkConsistency();
    List<T> list();
    void addProduct(T product);
    String toString();

}
