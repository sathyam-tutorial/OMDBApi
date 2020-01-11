package mobile.customers.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class mobileProject {
    private static final String LIST_CONTACT = "# To Get List of All Contacts Type 1 \n";
    private static final String ADD_CONTACT = "# To Add a Contact Type 2 \n";
    private static final String MODIFY_CONTACT = "# To Change a existing contact Type 3 \n";
    private static final String DELETE_CONTACT = "# To Delete a contact Type 4 \n";
    private static final String FIND_CONTACT = "# To Find a contact Type 5 \n";
    private static final String EXIT = "# To Quit Type 6 \n";
    private static final String HELP = "# To Print Instructions Type 7 \n";
    private static final String ENTER_CHOICE = "Please Enter the Choice: ";
    private static final String SHOW_HELP = "For Instructions Type 7 \r";
    private static final String INPUT_EXCEPTION = "Invalid Input, " +
            "Please provide Input between 0 to 7. " +
            "For help please type 7 \n";
    private static Scanner scanner = new Scanner(System.in);
    private static Contact contact = new Contact();
    private static java.lang.String String;

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        //Declare Switch Case
        while(true) {
            System.out.println(ENTER_CHOICE);
            System.out.println(SHOW_HELP);
            choice = scanner.nextInt();

            switch(choice) {
                case 1:
                    listAllContacts();
                    break;
                case 2:
                    addContact(String, String);
                    break;
                case 3:
                    modifyContact(String, String, String);
                    break;
                case 4:
                    deleteContact(String);
                    break;
                case 5:
                    findContact(String);
                    break;
                case 6:
                    break;
                case 7:
                    printInstructions();
                    break;
                case 8:
                    validate();
                    break;
                default:
                    System.out.println(INPUT_EXCEPTION);
            }
        }
    }
    private static void printInstructions() {
        System.out.print(LIST_CONTACT);
        System.out.print(ADD_CONTACT);
        System.out.print(MODIFY_CONTACT);
        System.out.print(DELETE_CONTACT);
        System.out.print(FIND_CONTACT);
        System.out.print(EXIT);
        System.out.print(HELP);
    }
    private static void validate() {
        String name = scanner.next();
        List<String> validateList = contact.validate(name);
        System.out.println("Validate List is " + validateList);

    }
    private static String listAllContacts() {
        ArrayList<String> myContactList = contact.showContacts();
        if(myContactList != null && !myContactList.isEmpty()) {
            System.out.println("List of Contacts");
            //System.out.println(myContactList);
            Arrays.asList(myContactList).forEach(item-> System.out.println("Mobile Contacts are " + item + "\n"));
        }
        else {
            System.out.println("No Contact List found, \n" +
                    "Please add new contact list");
        }
        return String;
    }
    public static String addContact(String name, String number) {
        System.out.println("Please Enter Contact Name to add");
        name = scanner.next();
        System.out.println("Please Enter Phone Number to add");
        number = scanner.next();
        contact.storeContact(name, number);
        System.out.println("Successfully Added " + name + " and " + number + " to Mobile");
        return String;
    }

    private static String modifyContact(String name, String newName, String newNumber ) {
        System.out.println("Please Enter Existing Contact Name to change");
        name = scanner.next();
        System.out.println("Please Enter New Contact Name to change");
        newName = scanner.next();
        System.out.println("Please Enter New Phone Number to change");
        newNumber = scanner.next();
        List<String> modifyContactList = contact.modifyContact(name,newName,newNumber);
        if(modifyContactList.contains(null)) {
            System.out.println("Name not found in Mobile," +
                    "\nPlease re-check the name and Type again");
        }
        System.out.println("Contact has been updated with name " + newName +
                " and Number " + newNumber + "\nUpdated Details are " + modifyContactList);
        return String;
    }
    private static String deleteContact(String name) {
        String purpose = "delete";
        System.out.println("Please Enter the name of the Contact to Delete:");
        name = scanner.next();
        List<String> deleteContactList = contact.manageContact(name, purpose);
        if(deleteContactList.contains(null)) {
            System.out.println("Contact name " + name + " not found");
        }
        else {
            System.out.println(deleteContactList + " Contact Deleted");
        }
        return String;
    }
    public static String findContact(String name) {
        String purpose = "query";
        System.out.println("Please Enter the Contact name to LookUp: ");
        name = scanner.next();
        List<String> getContact = contact.manageContact(name, purpose);
        if(getContact.contains(null)) {
            System.out.println("Contact name " + name + " not found");
        }
        else {
            System.out.println("Contact Name Found" + getContact);
        }
        return String;
    }
}
