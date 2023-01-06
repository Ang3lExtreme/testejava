import customer.Company;
import customer.Person;
import product.Purchase;
import product.Selling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Person> people = new ArrayList<>();
    private static List<Company> companies = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        help();
        while (true) {

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Create a Person");
                    createPerson();
                    break;
                case 2:
                    System.out.println("Create a Company");
                    createCompany();
                    break;
                case 3:
                    System.out.println("buy a product");
                    buyProduct();
                    break;
                case 4:
                    System.out.println("List Receipt of a Person");
                    listPersonReceipts();
                    break;
                case 5:
                    System.out.println("List Receipt of a Company");
                    listCompanyReceipts();
                    break;
                case 6:
                    System.out.println("Get Person info");
                    getPersonInfo();
                    break;
                case 7:
                    System.out.println("Get Company info");
                    getCompanyInfo();
                    break;
                case 8:
                    System.out.println("Help");
                    help();
                    break;
                case 9:
                    System.out.println("Exit");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }

        }

    }

    private static void getCompanyInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the company name");
        String name = scanner.nextLine();
        Company company = getCompany(name);
        if (company == null) {
            System.out.println("Company not found");
            return;
        }
        System.out.println(company);
    }

    private static void getPersonInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the nif of the person");
        String nif = scanner.nextLine();
        Person person = getPerson(nif);
        if (person == null) {
            System.out.println("Person not found");
            return;
        }
       System.out.println(person);
    }

    private static void listCompanyReceipts() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the NIPC of the company");
        String nipc = scanner.nextLine();
        Company company = getCompany(nipc);
        if (company != null) {
            for (Object selling : company.list()) {
                System.out.println(selling);
            }
        } else {
            System.out.println("Company not found");
        }
    }

    private static void listPersonReceipts() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert Person NIF");
        String nif = scanner.nextLine();
        Person person = getPerson(nif);
        if (person != null) {
            for (Object purchase : person.list()) {
                System.out.println(purchase);
            }
        } else {
            System.out.println("Person not found");
        }

    }

    private static void buyProduct(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Person's NIF");
        String nif = scanner.nextLine();
        System.out.println("Enter the Product's id");
        String id = scanner.nextLine();
        System.out.println("Enter the Product's Price");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter the Product's Quantity");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the Product's tax");
        float tax = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Enter the company nipc");
        String nipc = scanner.nextLine();
        Purchase purchase = new Purchase(id, price, quantity, tax, nipc);
        Selling selling = new Selling(id, price, quantity, tax, nif);
        Person person = getPerson(nif);
        Company company = getCompany(nipc);

        if(person != null && company != null && purchase.checkConsistency() && selling.checkConsistency()){
            person.addProduct(purchase);
            company.addProduct(selling);
            companies.set(getCompanyIndex(nipc) ,company);
            people.set(getPersonIndex(nif), person);
            System.out.println("Product bought");
        }
        else{
            System.out.println("Error");
        }

    }

    private static int getPersonIndex(String nif) {
        for (int i = 0; i < people.size(); i++) {
            if(people.get(i).getIdentificationNumber().equals(nif)){
                return i;
            }
        }
        return -1;
    }

    private static Person getPerson(String nif) {
        for (Person person : people) {
            if(person.getIdentificationNumber().equals(nif)){
                return person;
            }
        }
        return null;
    }

    private static Company getCompany(String nipc) {
        for (Company company : companies) {
            if (company.getIdentificationNumber().equals(nipc)) {
                return company;
            }
        }
        return null;
    }

    private static int getCompanyIndex(String nipc) {
        for (int i = 0; i < companies.size(); i++) {
            if(companies.get(i).getIdentificationNumber().equals(nipc)){
                return i;
            }
        }
        return -1;
    }


    private static void createCompany() {
        //same as createPerson but for companies
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("NIPC: ");
        String nipc = scanner.nextLine();
        Company company = new Company(name, email, nipc);
        if(company.checkConsistency()) {
            if(companyExists(company.getIdentificationNumber())) {
                System.out.println("Company already exists");
            } else {
                System.out.println("Company created successfully");
                companies.add(company);
            }

        }
        else {
            System.out.println("Company creation failed");
        }
    }

    private static boolean companyExists(String company) {
        for (Company c : companies) {
            if(c.getIdentificationNumber().equals(company)) {
                return true;
            }
        }
        System.out.println("Company not found");
        return false;
    }

    private static void createPerson() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("NIF: ");
        String nif = scanner.nextLine();
        Person person = new Person(name, email, nif);
        if(person.checkConsistency()) {
            if(personExists(person.getIdentificationNumber())) {
                System.out.println("Person already exists");
            } else {
                System.out.println("Person created successfully");
                people.add(person);
            }

        }
        else {
            System.out.println("Person creation failed");
        }
    }

    private static boolean personExists(String person) {
        for (Person p : people) {
            if(p.getIdentificationNumber().equals(person)) {
                return true;
            }
        }
        System.out.println("Person not found");
        return false;
    }

    private static void help() {
            System.out.println("> Please select an option:");
            System.out.println("> 1 - Create Person");
            System.out.println("> 2 - Create Company");
            System.out.println("> 3 - Buy Product");
            System.out.println("> 4 - List Person Receipts");
            System.out.println("> 5 - List Company Receipts");
            System.out.println("> 6 - Get Person Info");
            System.out.println("> 7 - Get Company Info");
            System.out.println("> 8 - Help");
            System.out.println("> 9 - Exit");
    }
}
