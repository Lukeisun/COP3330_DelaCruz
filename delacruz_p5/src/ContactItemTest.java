import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactItemTest{

    @Test
    public void creationFailsWithAllBlankValues(){
        assertThrows(IllegalArgumentException.class, ()-> new ContactItem("","","",""));
    }
    @Test
    public void creationSucceedsWithBlankEmail(){
        ContactItem contact = new ContactItem("d","","dd","");
        assertEquals("", contact.getEmail());
    }
    @Test
    public void creationSucceedsWithBlankFirstName(){
        ContactItem contact = new ContactItem("","","dd","d");
        assertEquals("", contact.getFirstName());
    }
    @Test
    public void creationSucceedsWithBlankLastName(){
        ContactItem contact = new ContactItem("d","","dd","");
        assertEquals("", contact.getLastName());
    }
    @Test
    public void creationSucceedsWithBlankPhone(){
        ContactItem contact = new ContactItem("d","","","");
        assertEquals("", contact.getPhoneNumber());
    }
    @Test
    public void creationSucceedsWithNonBlankValues(){
        ContactItem contact = new ContactItem("d","z","c","e");
        assertEquals("d", contact.getFirstName());
        assertEquals("z", contact.getLastName());
        assertEquals("c", contact.getPhoneNumber());
        assertEquals("e", contact.getEmail());
    }
    @Test //Replicating how editing an item is done
    public void editingFailsWithAllBlankValues(){
        ContactItem temp = new ContactItem();
        ContactItem item = new ContactItem("d", "d", "d", "d");
        temp.setFirstName(item.getFirstName());
        temp.setLastName(item.getLastName());
        temp.setEmail(item.getEmail());
        temp.setPhoneNumber(item.getPhoneNumber());
        temp.setFirstName("");
        temp.setLastName("");
        temp.setPhoneNumber("");
        temp.setEmail("");
        assertEquals(true, temp.checkIfAllNull());
    }
    @Test
    public void editingSucceedsWithBlankEmail(){
        ContactItem temp = new ContactItem();
        ContactItem item = new ContactItem("d", "d", "d", "d");
        temp.setFirstName(item.getFirstName());
        temp.setLastName(item.getLastName());
        temp.setEmail(item.getEmail());
        temp.setPhoneNumber(item.getPhoneNumber());
        temp.setFirstName("d");
        temp.setLastName("d");
        temp.setPhoneNumber("d");
        temp.setEmail("");
        assertEquals(false, temp.checkIfAllNull());
    }
    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactItem temp = new ContactItem();
        ContactItem item = new ContactItem("d", "d", "d", "d");
        temp.setFirstName(item.getFirstName());
        temp.setLastName(item.getLastName());
        temp.setEmail(item.getEmail());
        temp.setPhoneNumber(item.getPhoneNumber());
        temp.setFirstName("");
        temp.setLastName("d");
        temp.setPhoneNumber("d");
        temp.setEmail("d");
        assertEquals(false, temp.checkIfAllNull());
    }
    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactItem temp = new ContactItem();
        ContactItem item = new ContactItem("d", "d", "d", "d");
        temp.setFirstName(item.getFirstName());
        temp.setLastName(item.getLastName());
        temp.setEmail(item.getEmail());
        temp.setPhoneNumber(item.getPhoneNumber());
        temp.setFirstName("d");
        temp.setLastName("");
        temp.setPhoneNumber("d");
        temp.setEmail("d");
        assertEquals(false, temp.checkIfAllNull());
    }
    @Test
    public void editingSucceedsWithBlankPhone(){
        ContactItem temp = new ContactItem();
        ContactItem item = new ContactItem("d", "d", "d", "d");
        temp.setFirstName(item.getFirstName());
        temp.setLastName(item.getLastName());
        temp.setEmail(item.getEmail());
        temp.setPhoneNumber(item.getPhoneNumber());
        temp.setFirstName("d");
        temp.setLastName("d");
        temp.setPhoneNumber("");
        temp.setEmail("d");
        assertEquals(false, temp.checkIfAllNull());
    }
    @Test
    public void editingSucceedsWithNonBlankValues(){
        ContactItem temp = new ContactItem();
        ContactItem item = new ContactItem("d", "d", "d", "d");
        temp.setFirstName(item.getFirstName());
        temp.setLastName(item.getLastName());
        temp.setEmail(item.getEmail());
        temp.setPhoneNumber(item.getPhoneNumber());
        temp.setFirstName("d");
        temp.setLastName("d");
        temp.setPhoneNumber("d");
        temp.setEmail("d");
        assertEquals(false, temp.checkIfAllNull());
    }
    @Test
    public void testToString(){
        ContactItem item = new ContactItem("f", "l", "p", "e");
        assertEquals("firstName='f', lastName='l', phoneNumber='p', email='e'", item.toString());
    }
}