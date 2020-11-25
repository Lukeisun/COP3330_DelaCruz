import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {
    @Test
    public void creatingTaskItemFailsWithInvalidDueDate(){
        TaskItem task = new TaskItem();
        assertThrows(IllegalArgumentException.class, () -> new TaskItem("bop", "", "2020-13-01"));
    }
    @Test
    public void creatingTaskItemFailsWithInvalidTitle(){
        TaskItem task = new TaskItem();
        assertThrows(IllegalArgumentException.class, () ->new TaskItem("","","2020-01-18"));
    }
    @Test
    public void creatingTaskItemSucceedsWithValidDueDate(){
        TaskItem task = new TaskItem("bop","","2020-01-18");
        assertEquals("2020-01-18", task.getDate());
    }
    @Test
    public void creatingTaskItemSucceedsWithValidTitle(){
        TaskItem task = new TaskItem("bop","","2020-01-18");
        assertEquals("bop",task.getTitle());
    }
    @Test
    public void settingTaskItemFailsWithInvalidDate(){
        TaskItem task = new TaskItem("bop","","2020-01-18");
        assertThrows(IllegalArgumentException.class, ()-> task.setDate("2020-13-32"));
    }
    @Test
    public void settingTaskItemSucceedsWithValidDate(){
        TaskItem task = new TaskItem("bop","","2020-01-18");
        task.setDate("2020-01-22");
        assertEquals("2020-01-22", task.getDate());
    }
    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle(){
        TaskItem task = new TaskItem("bop","","2020-01-18");
        assertThrows(IllegalArgumentException.class, ()->task.setTitle(""));
    }
    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle(){
        TaskItem task = new TaskItem("bop","","2020-01-18");
        task.setTitle("1");
        assertEquals("1",task.getTitle());
    }
}