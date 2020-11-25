import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactApp {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) { contactMenu();}
    //Menu stuff
    public static void contactMenu() {
        int opt = 0;
        while (true) {
            System.out.println("Main Menu");
            System.out.println("----------\n");
            System.out.println("1) Create a new list");
            System.out.println("2) Load an existing list");
            System.out.println("3) quit");
            opt = getMainInput();
            doMainOption(opt);
        }
    }
    private static int getMainInput(){
        int opt = 0;
        try {
            opt = scan.nextInt();
        } catch (Exception e){
            System.out.println("Must be an integer, enter new value");
            scan.nextLine();
            return getMainInput();
        }
        if (opt > 3 || opt <1) {
            System.out.println("Must be between 1-3, enter new value");
            return getMainInput();
        }
        return opt;
    }
    private static void doMainOption(int opt){
        if (opt == 1) {
            System.out.println("new task list has been created\n");
            ContactList newList = new ContactList();
            listMenu(newList);
        } else if (opt == 2) {
            System.out.print("Enter filename to load: ");
            String filename = validateFileName(scan.next());
            ContactList existingList = readFile(filename);
            listMenu(existingList);
        } else if (opt == 3) {
            System.out.println("Exiting...");
            System.exit(0);
        }
    }
    //In list
    private static void listMenu(ContactList list){
        while(true) {
            System.out.println("\nList operation menu");
            System.out.println("--------------------\n");
            System.out.println("1) View the list");
            System.out.println("2) Add item to list");
            System.out.println("3) Edit item in list");
            System.out.println("4) Remove an item in list");
            System.out.println("5) Save the current list");
            System.out.println("6) Quit to main menu");
            doListMenuOption(list, getListInput());
        }
    }
    private static void doListMenuOption(ContactList list, int opt) {
        switch (opt) {
            case 1:
                list.viewContactList();
                break;
            case 2:
                addItem(list);
                list.viewContactList();
                break;
            case 3:
                editItem(list);
                break;
            case 4:
                removeItem(list);
                break;
            case 5:
                System.out.print("Enter filename to save as: ");
                String filename = scan.nextLine();
                filename = validateFileName(filename);
                saveTaskList(filename, list);
                break;
            case 6:
                contactMenu();
                break;
        }
    }
    //Files
    public static ContactList readFile(String filename){
        ContactList list = new ContactList();
        list = readTasksFromFile(list,filename);
        return list;
    }
    private static ContactList readTasksFromFile(ContactList list, String filename){ //Really want to decompose this but unsure as to how I'd do it with scanner.
        try(Scanner input = new Scanner(Paths.get(filename))){
            while(input.hasNextLine()){
                String[] info = input.nextLine().split(",");
                ContactItem contact = new ContactItem();
                for(int i = 0; i<info.length; i++){
                    try {
                        if (info[i].equals("F")) {
                            contact.setFirstName(info[i + 1]);
                        }
                        if (info[i].equals("L")) {
                            contact.setLastName(info[i + 1]);
                        }
                        if (info[i].equals("E")) {
                            contact.setEmail(info[i + 1]);
                        }
                        if (info[i].equals("P")) {
                            contact.setPhoneNumber(info[i + 1]);
                        }
                    } catch (NoSuchElementException e){
                        System.out.println("Invalid file please select a new one");
                        contactMenu();
                    }
                }
                list.addContact(contact);
            }
        } catch (IOException e) {
            System.out.println("No such file, please insert new value");
            contactMenu();
        }
        return list;
    }
    private static String validateFileName(String filename){
        String pattern = "(\\w)*\\.txt";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(filename);
        if(!m.find()){
            System.out.print("Invalid filename, must end in .txt. Enter new name: ");
            String newFilename = scan.next();
            return validateFileName(newFilename);
        }
        return filename;
    }
    private static void saveTaskList(String filename, ContactList list){
        try  (FileWriter out = new FileWriter(filename)){
            int counter =0;
            for(ContactItem item: list.getContactList()){
                out.write("F," +item.getFirstName()  +
                        ",L," + item.getLastName()  +
                        ",E,"  + item.getEmail()  +
                        ",P," + item.getPhoneNumber() + "\n");
                counter++;
            }
        } catch (Exception e) {
            System.out.println("Error printing to file");
        }
    }
    //Remove
    private static void removeItem(ContactList list){
        if(list.getContactList().isEmpty()){
            System.out.println("TaskList is empty");
        } else {
            System.out.print("Select an index to remove: ");
            int idx = askForIdx(list);
            list.removeContact(idx);
        }
    }
    //Edit
    private static void editItem(ContactList list){
        if(list.getContactList().isEmpty()){
            System.out.println("TaskList is empty");
        } else {
            list.viewContactList();
            System.out.print("Select an index to edit: ");
            int idx = askForIdx(list);
            ContactItem item = list.getContactList().get(idx);
            ContactItem temp = new ContactItem();
            temp.setFirstName(item.getFirstName());
            temp.setLastName(item.getLastName());
            temp.setPhoneNumber(item.getPhoneNumber());
            temp.setEmail(item.getEmail());
            temp = setFirstName(temp);
            temp = setLastName(temp);
            temp = setItemPhoneNumber(temp);
            temp = setItemEmail(temp);
            if(temp.checkIfAllNull()){
                System.out.println("All values null, please do again");
                editItem(list);
            } else {
                list.replaceContact(temp, idx);
            }
        }
    }
    //Index validation
    private static int askForIdx(ContactList list) {
        if(list.getContactList().isEmpty()){
            System.out.println("List is empty, try again");
            return -1;
        } else {
            int idx = 0;
            try {
                idx = scan.nextInt();
            } catch (Exception e) {
                System.out.print("Must be an integer: ");
                scan.next();
                return askForIdx(list);
            }
            if (isValidIdx(idx, list)) {
                scan.nextLine();
                return idx;
            } else {
                System.out.println("Invalid index");
                System.out.print("Select an index: ");
                return askForIdx(list);
            }
        }
    }
    public static Boolean isValidIdx(int idx, ContactList list){  //PUBLIC FOR TESTING
        if(idx >= list.getContactListSize() || idx < 0)
            return false;
        else
            return true;
    }
    //Add item
    private static void addItem(ContactList list){
        ContactItem contact = new ContactItem();
        contact = setFirstName(contact);
        contact = setLastName(contact);
        contact = setItemPhoneNumber(contact);
        contact = setItemEmail(contact);
        if(contact.checkIfAllNull()){
            System.out.println("All values null, please do again");
            addItem(list);
        } else {
            list.addContact(contact);
        }
    }
    private static ContactItem setFirstName(ContactItem contact){
        while(true){
            try{
                System.out.print("First Name: ");
                String firstName = askString();
                contact.setFirstName(firstName);
                break;
            } catch (IllegalArgumentException e){
                e.getMessage();
            }
        }
        return contact;
    }
    private static ContactItem setLastName(ContactItem contact){
        while(true){
            try{
                System.out.print("Last Name: ");
                String lastName = askString();
                contact.setLastName(lastName);
                break;
            } catch (IllegalArgumentException e){
                e.getMessage();
            }
        }
        return contact;
    }
    private static ContactItem setItemPhoneNumber(ContactItem contact){
        while (true){
            try{
                System.out.print("Phone number (xxx-xxx-xxxx): ");
                String phoneNumber = askString();
                contact.setPhoneNumber(phoneNumber);
                break;
            } catch (IllegalArgumentException e){
                e.getMessage();
            }
        }
        return contact;
    }
    private static ContactItem setItemEmail(ContactItem contact){
        while (true){
            try{
                System.out.print("Email address (x@y.z): ");
                String phoneNumber = askString();
                contact.setEmail(phoneNumber);
                break;
            } catch (IllegalArgumentException e){
                e.getMessage();
            }
        }
        return contact;
    }
    //Ask for string
    private static String askString(){
        return scan.nextLine();
    }
    private static int getListInput(){
        int opt;
        try {
            opt = scan.nextInt();
        } catch (Exception e){
            System.out.print("Must be an integer, enter a new value");
            return getListInput();
        }
        if(opt > 6 || opt < 1){
            System.out.print("Not in range, enter a new value: ");
            return getListInput();
        }
        scan.nextLine();
        return opt;
    }
}
