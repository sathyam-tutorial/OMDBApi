package mobile.customers.data;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class mobileProjectTest {
    @Test
    public void test_by_adding_new_contact() {
        mobileProject addNewContact = new mobileProject();
        Contact myContact = new Contact();
        String name = "trishan";
        String number = "9876552";

        myContact.storeContact(name, number);
        assertEquals("Customer name matched",name,addNewContact.findContact(name));
    }
}
