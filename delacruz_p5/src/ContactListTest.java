import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ContactListTest extends ContactApp {
    @Test
    public void addingItemsIncreasesSize(){
        ContactList list = new ContactList();
        ContactItem contact = new ContactItem();
        assertEquals(0, list.getContactListSize());
        list.addContact(contact);
        assertEquals(1,list.getContactListSize());
    }
    @Test //Replicating how I do this in ContactApp
    public void editingItemsFailsWithAllBlankValues(){
        ContactItem temp = new ContactItem();
        ContactItem item = new ContactItem("d", "d", "d", "d");
        ContactList list = new ContactList();
        list.addContact(item);
        temp.setFirstName(item.getFirstName());
        temp.setLastName(item.getLastName());
        temp.setEmail(item.getEmail());
        temp.setPhoneNumber(item.getPhoneNumber());
        temp.setFirstName("");
        temp.setLastName("");
        temp.setPhoneNumber("");
        temp.setEmail("");
        list.replaceContact(temp, 0);
        assertEquals(true, temp.checkIfAllNull());
    }
    @Test
    public void editingItemsFailsWithInvalidIndex(){
        ContactItem temp = new ContactItem();
        ContactItem item = new ContactItem("d", "d", "d", "d");
        ContactList list = new ContactList();
        list.addContact(item);
        assertEquals(false, isValidIdx(1,list));
    }
    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactItem temp = new ContactItem();
        ContactItem item = new ContactItem("d", "d", "d", "d");
        ContactList list = new ContactList();
        list.addContact(item);
        temp.setFirstName(item.getFirstName());
        temp.setLastName(item.getLastName());
        temp.setEmail(item.getEmail());
        temp.setPhoneNumber(item.getPhoneNumber());
        temp.setFirstName("");
        temp.setLastName("d");
        temp.setPhoneNumber("d");
        temp.setEmail("d");
        list.replaceContact(temp, 0);
        assertEquals(false, temp.checkIfAllNull());
    }
    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactItem temp = new ContactItem();
        ContactItem item = new ContactItem("d", "d", "d", "d");
        ContactList list = new ContactList();
        list.addContact(item);
        temp.setFirstName(item.getFirstName());
        temp.setLastName(item.getLastName());
        temp.setEmail(item.getEmail());
        temp.setPhoneNumber(item.getPhoneNumber());
        temp.setFirstName("");
        temp.setLastName("d");
        temp.setPhoneNumber("d");
        temp.setEmail("d");
        list.replaceContact(temp, 0);
        assertEquals(false, temp.checkIfAllNull());
    }
    @Test
    public void editingSucceedsWithBlankPhone(){
        ContactItem temp = new ContactItem();
        ContactItem item = new ContactItem("d", "d", "d", "d");
        ContactList list = new ContactList();
        list.addContact(item);
        temp.setFirstName(item.getFirstName());
        temp.setLastName(item.getLastName());
        temp.setEmail(item.getEmail());
        temp.setPhoneNumber(item.getPhoneNumber());
        temp.setFirstName("d");
        temp.setLastName("d");
        temp.setPhoneNumber("");
        temp.setEmail("d");
        list.replaceContact(temp, 0);
        assertEquals(false, temp.checkIfAllNull());
    }
    @Test
    public void editingSucceedsWithNonBlankValues(){
        ContactItem temp = new ContactItem();
        ContactItem item = new ContactItem("d", "d", "d", "d");
        ContactList list = new ContactList();
        list.addContact(item);
        temp.setFirstName(item.getFirstName());
        temp.setLastName(item.getLastName());
        temp.setEmail(item.getEmail());
        temp.setPhoneNumber(item.getPhoneNumber());
        temp.setFirstName("");
        temp.setLastName("d");
        temp.setPhoneNumber("d");
        temp.setEmail("d");
        list.replaceContact(temp, 0);
        assertEquals(false, temp.checkIfAllNull());
    }
    @Test
    public void newListISEmpty(){
        ContactList list = new ContactList();
        assertEquals(0, list.getContactListSize());
    }
    @Test
    public void removingItemsDecreasesSize(){
        ContactList list = new ContactList();
        ContactItem contact = new ContactItem();
        assertEquals(0, list.getContactListSize());
        list.addContact(contact);
        assertEquals(1,list.getContactListSize());
        list.removeContact(0);
        assertEquals(0,list.getContactListSize());
    }
    @Test
    public void removingItemsFailsWithInvalidIndex(){
        ContactList list = new ContactList();
        ContactItem contact = new ContactItem();
        assertEquals(0, list.getContactListSize());
        list.addContact(contact);
        assertEquals(1,list.getContactListSize());
        int idx = 2;
        assertEquals(false, isValidIdx(idx,list));
    }
    @Test
    public void savedContactListCanBeLoaded(){
        ContactList list = readFile("z.txt");
        ArrayList<ContactItem> tasks = list.getContactList();
        assertEquals("zo", tasks.get(0).getFirstName() );
    }
}