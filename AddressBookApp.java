import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Contact class
class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    // Constructor
    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Method to display contact information
    public void displayContact() {
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Email: " + email);
    }
}

// AddressBook class
class AddressBook {
    private List<Contact> contacts;

    // Constructor
    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    // Method to add a contact
    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact added successfully.");
    }

    // Method to view all contacts
    public void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            for (Contact contact : contacts) {
                contact.displayContact();
                System.out.println();
            }
        }
    }

    // Method to search for a contact by name
    public void searchContactByName(String name) {
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                contact.displayContact();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }
}

// Main class with menu-driven interface
public class AddressBookApp {
    private static Scanner scanner = new Scanner(System.in);
    private static AddressBook addressBook = new AddressBook();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nAddress Book Menu");
            System.out.println("1. Add a new contact");
            System.out.println("2. View all contacts");
            System.out.println("3. Search for a contact by name");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addNewContact();
                    break;
                case 2:
                    addressBook.viewContacts();
                    break;
                case 3:
                    searchContact();
                    break;
                case 4:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private static void addNewContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        Contact contact = new Contact(name, phoneNumber, email);
        addressBook.addContact(contact);
    }

    private static void searchContact() {
        System.out.print("Enter the name of the contact to search: ");
        String name = scanner.nextLine();
        addressBook.searchContactByName(name);
    }
}
