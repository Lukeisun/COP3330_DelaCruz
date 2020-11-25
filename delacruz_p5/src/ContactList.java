import java.util.ArrayList;

public class ContactList {
    private ArrayList<ContactItem> contacts = new ArrayList<>();
    ContactList(){}
    public ArrayList<ContactItem> getContactList(){return this.contacts;}
    public void addContact(ContactItem contact){
        this.contacts.add(contact);
    }
    public int getContactListSize() {return this.contacts.size();}
    public void removeContact(int idx){ this.contacts.remove(idx);}
    public void replaceContact(ContactItem contact,int idx){this.contacts.set(idx,contact);}
    public void viewContactList(){
        System.out.println("\nCurrent Contacts");
        System.out.println("-------------------\n");
        int counter = 0;
        for(ContactItem item : this.contacts){
            System.out.print(counter +") ");
            if(!item.getFirstName().equals("") || !item.getLastName().equals("")){
                String str = item.getFirstName() + " " + item.getLastName();
                System.out.println("Name: " + str);
            }
            if(!item.getEmail().equals("")){
                System.out.println("Email: " + item.getEmail());
            }
            if(!item.getPhoneNumber().equals("")){
                System.out.println("Phone: " + item.getPhoneNumber());
            }
            counter++;
        }
    }
}

