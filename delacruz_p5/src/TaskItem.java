import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskItem {
    private String title;
    private String description;
    private String date;
    TaskItem(String title, String description, String date){
        if(isTitleValid(title)) {
            this.title = title;
        } else {
            throw new IllegalArgumentException("Title is empty");
        }
        this.description = description;
        if(isDateValid(date)) {
            this.date = date;
        }else {
            throw new IllegalArgumentException("Date not to format");
        }
    }
    TaskItem(){}
    private Boolean isTitleValid(String title){
        return title.length() >0;
    }
    private Boolean isDateValid(String date){
        String pattern = "^([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(date);
        if(!m.find()){
            return false;
        } else {
            return true;
        }
    }
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        if(isTitleValid(title)) {
            this.title = title;
        } else {
            throw new IllegalArgumentException("Title is empty");
        }
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        if(isDateValid(date)) {
            this.date = date;
        }else {
            throw new IllegalArgumentException("Date not to format");
        }
    }

}
