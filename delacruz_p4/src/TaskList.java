import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;



public class TaskList {
    private ArrayList<TaskItem> tasks = new ArrayList<>();
    private int[] indexCompleted = new int[50];
    TaskList(){
        Arrays.fill(indexCompleted,-1);
    }
    //Tasks arraylist helpers
    public ArrayList<TaskItem> getTasks(){
        return this.tasks;
    }
    public void addTask(TaskItem task){
        this.tasks.add(task);
    }
    public void replaceTask(TaskItem task, int idx){
        this.tasks.set(idx, task);
    }
    public void removeTask(int idx){
        this.tasks.remove(idx);
    }
    public int tasksSize(){
        return this.tasks.size();
    }
    public void viewTaskList(){
        System.out.println("\nCurrent Tasks");
        System.out.println("-------------------\n");
        int counter = 0;
        for(TaskItem item : this.tasks){
            if(isComplete(counter)) {
                System.out.println(counter + ") *** [" + item.getDate() + "] " + item.getTitle() + ": " + item.getDescription());
            } else {
                System.out.println(counter + ") [" + item.getDate() + "] " + item.getTitle() + ": " + item.getDescription());
            }
            counter++;
        }
    }
    //Index array helpers
    public int[] getIndexCompletedArray(){ return this.indexCompleted;}
    public void setIndexCompletedArray(int[] newArray){this.indexCompleted = newArray;}
    public void saveTaskList(String filename){
        try  (FileWriter out = new FileWriter(filename)){
            int counter =0;
            for(TaskItem item: tasks){
                out.write(counter + ") " + item.getDate() + " : " + item.getTitle() + " : " + item.getDescription()+ " : Completed - " + isComplete(counter)+"\n");
                counter++;
            }
        } catch (Exception e) {
            System.out.println("Error printing to file");
        }
    }


    //Printing complete/uncomplete
    public void viewUncompleteTasks(){
        System.out.println("\nUncompleted Tasks");
        System.out.println("-------------------\n");
        int counter = 0;
        for(int i = 0; i<this.tasks.size(); i++){
            TaskItem item = this.tasks.get(i);
            if(!isComplete(i)) {
                System.out.println(counter + ") [" + item.getDate() + "] " + item.getTitle() + ": " + item.getDescription());
            }
            counter++;
        }
    }
    public void viewCompleteTasks(){
        System.out.println("\nCompleted Tasks");
        System.out.println("-------------------\n");
        int counter = 0;
        for(int i = 0; i<this.tasks.size(); i++){
            TaskItem item = this.tasks.get(i);
            if(isComplete(i)) {
                System.out.println(counter + ") [" + item.getDate() + "] " + item.getTitle() + ": " + item.getDescription());
            }
            counter++;
        }
    }
    private boolean isComplete(int idx){
        for(int i : indexCompleted){
            if(i == idx) return true;
        }
        return false;
    }

}
