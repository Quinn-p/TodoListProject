//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;

public class TODOList {
    public TODOList() {
    }

    public static void addTask(String var0, int var1, ArrayList<Task> var2) {
        Task var3 = new Task(var0, var1);
        var2.add(var3);
    }

    public static int search(String var0, ArrayList<Task> var1) {
        for(int var2 = 0; var2 < var1.size(); ++var2) {
            if (((Task)var1.get(var2)).getTaskName().equals(var0)) {
                return var2;
            }
        }

        return -1;
    }

    public static void removeTask(String var0, ArrayList<Task> var1) {
        var1.remove(search(var0, var1));
    }

    public static void printList(ArrayList<Task> var0) {
        System.out.println("TODO List");

        for(int var1 = 0; var1 < var0.size(); ++var1) {
            System.out.println(((Task)var0.get(var1)).toString());
        }

    }

    public static void clearList(ArrayList<Task> var0) {
        var0.clear();
    }

    public static Task getTaskAtIndex(String var0, ArrayList<Task> var1) {
        return (Task)var1.get(search(var0, var1));
    }

    public static void clearList(String var0, ArrayList<Task> var1) {
    }
}
