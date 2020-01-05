package mobile.customers.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Contact {

    private String name;
    private String phoneNumber;
    private ArrayList<String> phoneContact = new ArrayList<String>();
    private int nameIndex;
    private int numberIndex;
    private List<Integer> queryContactList;

    public List<String> storeContact(String name, String phoneNumber) {
        phoneContact.add(name);
        phoneContact.add(phoneNumber);
        return Arrays.asList(name, phoneNumber);
    }
    public ArrayList<String> showContacts() {
        return phoneContact;
    }
    public List<String> modifyContact(String name, String newName, String newPhoneNumber) {
        List<String> modifyContact = queryContact(name);
        if(modifyContact.contains(null)) {
            return Collections.singletonList(null);
        }
        System.out.println("Name index " + nameIndex + newName);
        System.out.println("Number index " + numberIndex + newPhoneNumber);
        phoneContact.set(queryContactList.get(0), newName);
        phoneContact.set(queryContactList.get(1), newPhoneNumber);
        List<String> newModifyContact = queryContact(newName);
        return (newModifyContact);
    }
    public List<String> manageContact(String name, String purpose) {
        if(purpose == "query") {
            List<String> queryContact = queryContact(name);
            return queryContact;
        }
        if(purpose == "delete") {
            List<String> deleteContact = deleteContact(name);
            return deleteContact;
        }
        return null;
    }
    private List<String> queryContact(String name) {
        queryContactList = getIndex(name);
        if(queryContactList.contains(null)) {
            return Collections.singletonList(null);
        }
        System.out.println("Name Index query is " + queryContactList.get(0));
        System.out.println("Number Index query is " + queryContactList.get(1));
        String contactName = phoneContact.get(queryContactList.get(0));
        String contactNumber = phoneContact.get(queryContactList.get(1));
        return Arrays.asList(contactName, contactNumber);
    }
    private List<String> deleteContact (String name) {
        List<String> nameList = queryContact(name);
        System.out.println("nameList " + nameList);
        /*System.out.println("Name Index for delete is " + queryContactList.get(0));
        System.out.println("Number Index for delete is " + queryContactList.get(1)); */
        phoneContact.remove(phoneContact.indexOf(name));
        phoneContact.remove((phoneContact.indexOf(name) + 1));
        System.out.println("phoneContact is " + phoneContact);
        return (nameList);
    }
    private List<Integer> getIndex(String name) {
        int index = phoneContact.indexOf(name);
        if(index == -1) {
            return Collections.singletonList(null);
        }
        int nameIndex = index;
        int numberIndex = (index + 1);
        return Arrays.asList(nameIndex, numberIndex);
    }

}
