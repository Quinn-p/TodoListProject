//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Task {
    private String name;
    private int day;

    public Task() {
        this.name = "N/A";
        this.day = -1;
    }

    public Task(String var1, int var2) {
        this.name = var1;
        this.day = var2;
    }

    public int getDay() {
        return this.day;
    }

    public String getTaskName() {
        return this.name;
    }

    public void setDay(int var1) {
        this.day = var1;
    }

    public void setTaskName(String var1) {
        this.name = var1;
    }

    public String toString() {
        return String.format("Name: %s Date: %d", this.getTaskName(), this.getDay());
    }
}




