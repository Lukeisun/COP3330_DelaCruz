import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest extends App {
    @Test
    public void addingTaskItemIncreasesSize(){
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("1","2","2020-01-18");
        list.addTask(task);
        assertEquals(1, list.tasksSize());
    }
    @Test
    public void completingTaskItemChangesStatus(){
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("1","2","2020-01-18");
        list.addTask(task);
        markTask(list,list.tasksSize()-1);
        assertEquals(true, list.isComplete(list.tasksSize()-1));
    }
    //NOTE ON INDEX STUFF, I just have one function that validates an index so I'll be using that for all the "Invalid index functions"
    @Test
    public void invalidIndexForFunctionsThatRequireIt(){
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("1","2","2020-01-18");
        list.addTask(task);
        TaskItem task1 = new TaskItem("2","","2020-01-18");
        list.addTask(task1);
        assertEquals(false, isValidIdx(list.tasksSize(),list));
    }
    @Test
    public void validIndexForFunctionsThatRequireIt() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("1","2","2020-01-18");
        list.addTask(task);
        TaskItem task1 = new TaskItem("2","","2020-01-18");
        list.addTask(task1);
        assertEquals(true, isValidIdx(list.tasksSize()-1,list));
    }
    //My edit function largely relies on just replacing the index of the ArrayList in TaskList, this is an identical process to my program however
    @Test
    public void editingTaskItemDescriptionChangesValue(){

        TaskList list = new TaskList();
        TaskItem task = new TaskItem("1", "2", "2020-01-18");
        list.addTask(task);
        TaskItem newTask = task;
        newTask.setDescription("boop");
        list.replaceTask(newTask, list.tasksSize()-1);
        ArrayList<TaskItem> arrList = list.getTasks();
        assertEquals("boop", arrList.get(0).getDescription());
    }
    @Test
    public void editingTaskItemDueDateChangesValue(){
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("1", "2", "2020-01-18");
        list.addTask(task);
        TaskItem newTask = task;
        newTask.setDate("2020-01-25");
        list.replaceTask(newTask, list.tasksSize()-1);
        ArrayList<TaskItem> arrList = list.getTasks();
        assertEquals("2020-01-25", arrList.get(0).getDate());
    }
    @Test
    public void editingTaskItemTitleChangesValue(){
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("1", "2", "2020-01-18");
        list.addTask(task);
        TaskItem newTask = task;
        newTask.setTitle("hi");
        list.replaceTask(newTask, list.tasksSize()-1);
        ArrayList<TaskItem> arrList = list.getTasks();
        assertEquals("hi", arrList.get(0).getTitle());
    }
    @Test
    public void gettingTaskItemDescriptionSucceeds(){
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("1","2","2020-01-18");
        list.addTask(task);
        ArrayList<TaskItem> arrList = list.getTasks();
        assertEquals("2", arrList.get(0).getDescription());
    }
    @Test
    public void gettingTaskItemDueDateSucceeds(){
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("1","2","2020-01-18");
        list.addTask(task);
        ArrayList<TaskItem> arrList = list.getTasks();
        assertEquals("2020-01-18", arrList.get(0).getDate());
    }
    @Test
    public void gettingTaskItemTitleSucceeds(){
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("1","2","2020-01-18");
        list.addTask(task);
        ArrayList<TaskItem> arrList = list.getTasks();
        assertEquals("1", arrList.get(0).getTitle());
    }
    @Test
    public void newTaskListIsEmpty(){
        TaskList list = new TaskList();
        ArrayList<TaskItem> arrList = list.getTasks();
        assertEquals(true, arrList.isEmpty());
    }
    @Test
    public void removingItemDecreasesSize(){
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("1","2","2020-01-18");
        list.addTask(task);
        TaskItem task1 = new TaskItem("2","2","2020-01-25");
        list.addTask(task1);
        assertEquals(2, list.tasksSize());
        list.removeTask(1);
        assertEquals(1, list.tasksSize());
    }
    @Test
    public void savedTaskListCanBeLoaded(){
        TaskList list = readFile("tasks.txt");
        ArrayList<TaskItem> tasks = list.getTasks();
        assertEquals("2001-01-18", tasks.get(0).getDate());
    }
    @Test
    public void uncompletingTaskItemChangesStatus(){
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("1","2","2020-01-18");
        list.addTask(task);
        TaskItem task1 = new TaskItem("2","2","2020-01-25");
        list.addTask(task1);
        markTask(list, 1);
        assertEquals(true, list.isComplete(1));
        unmarkInArray(list.getIndexCompletedArray(), 1);
        assertEquals(false,list.isComplete(1));
    }

}