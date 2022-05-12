//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner input;
    static ArrayList<Task> taskList;

    public Main() {
    }

    public static String getInput(String var0) {
        System.out.println(var0);
        String var1 = input.nextLine();
        return var1;
    }

    public static void startingMenu() {
        String var0 = getInput("[1] To create a new list\n[2] To import a list\n[3] To access current lists\nPlease type a number and press the enter key.\n");
        if (!var0.equals("Q") && !var0.contains("1") && !var0.contains("2") && var0.contains("3")) {
        }

    }

    public static String printMenu() {
        String var0 = "Type the number of the corresponding task you would like to perform then press enter. (Type \"Q\" to quit)\n [1] Add to the list\n [2] Search the list (Use this to remove, modify or find elements)\n [3] Clear day (Input day to clear)\n [4] Clear the whole list\n [5] Print the list\n";
        return var0;
    }

    public static String searchMenu() {
        String var0 = "Type the name of the task to be searched exactly as it is entered on the list.\n[1] Remove the task\n[2] Modify the task\n[3] Find and print the task\n";
        return var0;
    }

    public static void run(String var0) {
        String var1;
        if (var0.contains("1")) {
            var1 = getInput("Enter the name of the task");
            int var2 = Integer.parseInt(getInput("Enter the day of the task"));
            TODOList.addTask(var1, var2, taskList);
            System.out.println("Task added");
        } else if (var0.contains("2")) {
            var1 = getInput(searchMenu());
            if (var1.contains("1")) {
                TODOList.removeTask(var1, taskList);
            } else {
                String var4;
                if (var1.contains("2")) {
                    var4 = getInput("What would you like to modify?\n[1] Name\n[2] Day\n");
                    if (var4.contains("1")) {
                        String var3 = getInput("What would you like to set the name to?");
                        ((Task)taskList.get(TODOList.search(var1, taskList))).setTaskName(var3);
                    } else if (var4.contains("2")) {
                        int var5 = Integer.parseInt("What would you like to set the day to?");
                        ((Task)taskList.get(TODOList.search(var1, taskList))).setDay(var5);
                    }
                } else if (var1.contains("3")) {
                    var4 = getInput("What is the name of the task you are searching for?");
                    TODOList.getTaskAtIndex(var4, taskList).toString();
                }
            }
        } else if (var0.contains("3")) {
            var1 = getInput("Enter the day that you would like to clear from the list");
        } else if (var0.contains("4")) {
            TODOList.clearList(taskList);
        } else if (var0.contains("5")) {
            TODOList.printList(taskList);
        }

    }

    public static void main(String[] var0) {
        System.out.println("Welcome to the todo list. (To Exit at any time press Q)");
        String var1 = "";

        while(!var1.equals("Q")) {
            var1 = getInput(printMenu());
            run(var1);
        }

    }

    static {
        input = new Scanner(System.in);
        taskList = new ArrayList();
    }
}
