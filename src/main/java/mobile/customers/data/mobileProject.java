package mobile.customers.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class mobileProject {
    private static final String LIST_CONTACT = "# To Get List of All Contacts Type 1 \n";
    private static final String ENTER_CHOICE = "Please Enter the Choice: ";
    private static final String SHOW_HELP = "For Instructions Type 7 \r";
    private static final String INPUT_EXCEPTION = "Invalid Input, " +
            "Please provide Input between 0 to 7. " +
            "For help please type 7 \n";
    private static Scanner scanner = new Scanner(System.in);
    private static Contact contact = new Contact();

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
                    addContact();
                    break;
                case 3:
                    modifyContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                default:
                    System.out.println(INPUT_EXCEPTION);
            }
        }
    }

    private static void listAllContacts() {
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
    }
    private static void addContact() {
        System.out.println("Please Enter Contact Name to add");
        String name = scanner.next();
        System.out.println("Please Enter Phone Number to add");
        String number = scanner.next();
        contact.storeContact(name, number);
        System.out.println("Successfully Added " + name + " and " + number + " to Mobile");
    }

    private static void modifyContact() {
        System.out.println("Please Enter Existing Contact Name to change");
        String name = scanner.next();
        System.out.println("Please Enter New Contact Name to change");
        String newName = scanner.next();
        System.out.println("Please Enter New Phone Number to change");
        String newNumber = scanner.next();
        List<String> modifyContactList = contact.modifyContact(name,newName,newNumber);
        if(modifyContactList.contains(null)) {
            System.out.println("Name not found in Mobile," +
                    "\nPlease re-check the name and Type again");
            return;
        }
        System.out.println("Contact has been updated with name " + newName +
                " and Number " + newNumber + "\nUpdated Details are " + modifyContactList);
    }
    private static void deleteContact() {
        String purpose = "delete";
        System.out.println("Please Enter the name of the Contact to Delete:");
        String name = scanner.next();
        List<String> deleteContactList = contact.manageContact(name, purpose);
        if(deleteContactList.contains(null)) {
            System.out.println("Contact name " + name + " not found");
        }
        else {
            System.out.println(deleteContactList + " Contact Deleted");
        }
    }
}
