
public class Task {
    private String name;
    private int day;

    public Task(){
        name = "N/A";
        day = -1;
    }

    public Task(String task, int day){
        this.name = task;
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public String getTaskName() {
        return name;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setTaskName(String task) {
        this.name = task;
    }

    @Override
    public String toString(){
        return String.format("Name: %s Date: %d",getTaskName(),getDay());
    }
}
