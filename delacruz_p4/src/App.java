import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
            mainMenu();
    }
    //Menu
    private static void mainMenu(){
        int opt = 0;
        while(true) {
            System.out.println("Main Menu");
            System.out.println("----------\n");
            System.out.println("1) Create a new list");
            System.out.println("2) Load an existing list");
            System.out.println("3) quit");
            opt = getMainInput();
            if (opt == 1) {
                System.out.println("new task list has been created\n");
                TaskList newList = new TaskList();
                listMenu(newList);
            } else if (opt == 2) {
                System.out.print("Enter filename to load: ");
                String filename = validateFileName(scan.next());
                readFile(filename);
            } else if (opt == 3) {
                System.out.println("Exiting...");
                System.exit(0);
            }
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
    //Reading file
    private static void readFile(String filename){
        TaskList list = new TaskList();
        try {
            File obj = new File(filename);
            Scanner reader = new Scanner(obj);
            while(reader.hasNextLine()){
                System.out.println(reader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error occurred");
        }
    }
    //List
    private static void listMenu(TaskList list){
        while(true) {
            System.out.println("\nList operation menu");
            System.out.println("--------------------\n");
            System.out.println("1) View the list");
            System.out.println("2) Add item to list");
            System.out.println("3) Edit item in list");
            System.out.println("4) Remove an item in list");
            System.out.println("5) Mark item as completed");
            System.out.println("6) Un-mark an item as completed");
            System.out.println("7) Save the current list");
            System.out.println("8) Quit to main menu");
            doMenuOption(list, getListInput());
        }
    }
    private static int getListInput(){
        int opt;
        try {
            opt = scan.nextInt();
        } catch (Exception e){
            System.out.print("Must be an integer, enter a new value");
            return getListInput();
        }
        if(opt > 8 || opt < 1){
            System.out.print("Not in range, enter a new value: ");
            return getListInput();
        }
        scan.nextLine();
        return opt;
    }
    private static void doMenuOption(TaskList list, int opt){
        switch(opt){
            case 1:
                list.viewTaskList();
                break;
            case 2:
                addItem(list);
                break;
            case 3:
                editItem(list);
                break;
            case 4:
                removeItem(list);
                break;
            case 5:
                markTask(list);
                break;
            case 6:
                unmarkTask(list);
                break;
            case 7:
                System.out.print("Enter filename to save as: ");
                String filename = scan.nextLine();
                filename = validateFileName(filename);
                list.saveTaskList(filename);
                break;
            case 8:
                mainMenu();
                break;
        }
    }
    //Unmark task
    private static void unmarkTask(TaskList list){
        list.viewCompleteTasks();
        System.out.println("Which task would you like to mark as incomplete? ");
        int idx = askForIdx(list);
        int[] completedArray = unmarkInArray(list.getIndexCompletedArray(), idx);
        list.setIndexCompletedArray(completedArray);
    }
    private static int[] unmarkInArray(int[] completedArray,int idx){
        for(int i = 0; i <completedArray.length; i++) {
            if (completedArray[i] == idx) {
                completedArray[i] = -1;
                break;
            }
        }
        return completedArray;
    }
    //Mark task
    private static void markTask(TaskList list){
        list.viewUncompleteTasks();
        System.out.print("Which task would you like to mark as complete? ");
        int idx = askForIdx(list);
        int[] completedArray = list.getIndexCompletedArray();
        completedArray = markInArray(completedArray, idx);
        list.setIndexCompletedArray(completedArray);
    }
    private static int[] markInArray(int[] completedArray,int idx){
        for(int i = 0; i <completedArray.length; i++) {
            if (completedArray[i] ==idx) {
                System.out.println("Item already marked as complete");
                break;
            }
            if (completedArray[i] == -1) {
                completedArray[i] = idx;
                break;
            }
        }
        return completedArray;
    }
    //Remove item
    private static void removeItem(TaskList list){
        System.out.print("Select an index to remove: ");
        int idx = askForIdx(list);
        list.removeTask(idx);
    }
    //Edit item
    private static void editItem(TaskList list){
        if(list.getTasks().isEmpty()){
            System.out.println("TaskList is empty");
        } else {
            list.viewTaskList();
            System.out.print("Select an index to edit: ");
            int idx = askForIdx(list);
            TaskItem item = list.getTasks().get(idx);
            item = setItemTitle(item);
            item = setItemDescription(item);
            item = setItemDate(item);
            list.replaceTask(item, idx);
        }
    }
    //Add item
    private static void addItem(TaskList list){
        TaskItem task = new TaskItem();
        task = setItemTitle(task);
        task = setItemDescription(task);
        task = setItemDate(task);
        list.addTask(task);
    }
    //Index validation
    private static int askForIdx(TaskList list) {
        int idx = 0;
        try {
            idx = scan.nextInt();
        } catch (Exception e) {
            System.out.println("Must be an integer");
            return askForIdx(list);
        }
        if (isValidIdx(idx, list)){
            scan.nextLine();
          return idx;
          } else {
            System.out.println("Invalid index");
            System.out.print("Select an index: ");
            return askForIdx(list);
        }
    }
    private static Boolean isValidIdx(int idx, TaskList list){
        if(idx >= list.tasksSize() || idx < 0)
            return false;
        else
            return true;
    }

    //Ask for title, description and date in add
    private static String askTitle(){
        System.out.print("Task title: ");
        return scan.nextLine();
    }
    private static String askDescription(){
        System.out.print("Task Description: ");
        return scan.nextLine();
    }
    private static String askDate(){
        System.out.print("Task due date (YYYY-MM-DD): ");
        return scan.nextLine();
    }
    //Set variables of the task item object
    private static TaskItem setItemTitle(TaskItem task){
        while(true) {
            try {
                String title = askTitle();
                task.setTitle(title);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid title, must be one character or more. Type a new value.");
            }
        }
        return task;
    }
    private static TaskItem setItemDescription(TaskItem task){
        String description = askDescription();
        task.setDescription(description);
        return task;
    }
    private static TaskItem setItemDate(TaskItem task){
        while(true) {
            try {
                String date = askDate();
                task.setDate(date);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid date, must YYYY-MM-DD. Type a new value.");
            }
        }
        return task;
    }
    //Validation
    private static String validateFileName(String filename){
        String pattern = "(\\w)*\\.txt";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(filename);
        if(!m.find()){
            System.out.print("Invalid filename, must end in .txt. Enter new name: ");
            String newFilename = scan.next();
            return validateFileName(newFilename);
        }
        scan.nextLine();
        return filename;
    }
}
