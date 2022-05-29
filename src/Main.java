import java.util.ArrayList;
import java.util.Scanner;
    //This will be the class that asks for the user input and controls the program
public class Main {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Task> taskList = new ArrayList<>();

    //Helper method that will print the printString parameter then wait for user to input a string
    public static String getInput(String printString){
        System.out.println(printString);
        String userInput = input.nextLine();
        return userInput;
    }

    //This is the menu taht will print of the menu that allows the users to pick which
    public static void startingMenu() {
        String startingInput = getInput("""
                [1] To create a new list
                [2] To import a list
                [3] To access current lists
                Please type a number and press the enter key.
                """);

        if (!startingInput.equals("Q")) {
            if (startingInput.contains("1")) {
                //taskList = new ArrayList<>();
            } else if (startingInput.contains("2")) { // import list
                //This is where you would call a function that would read in a file and import all the information into that file
            } else if (startingInput.contains("3")) { // access current list
                //This is where you would search the current TODO list that you have
            }
        }
    }


    public static String printMenu() {
        String mainMenu = """
               Type the number of the corresponding task you would like to perform then press enter. (Type "Q" to quit)
                [1] Add to the list
                [2] Search the list (Use this to remove, modify or find elements)
                [3] Clear day (Input day to clear)
                [4] Clear the whole list
                [5] Print the list
                """;
        return mainMenu;
    }

    public static String searchMenu(){
        String searchMenu = """
                        Type the name of the task to be searched exactly as it is entered on the list.
                        [1] Remove the task
                        [2] Modify the task
                        [3] Find and print the task
                        """;
        return searchMenu;
    }

    public static void run(String input) {
        //this method will set up the list and take in user inputs
            if (input.contains("1")){ //Add a task to the list
                String name = getInput("Enter the name of the task");
                int day = Integer.parseInt(getInput("Enter the day of the task"));
                TODOList.addTask(name,day,taskList);
                System.out.println("Task added");
            }else if (input.contains("2")){ //Search the list
                String searchMenu = getInput(searchMenu());
                if (searchMenu.contains("1")){ //Remove the task that was searched
                    String  name = getInput("What is the name that you would like to remove from the list?");
                    if(TODOList.search(name, taskList)!=-1){
                    TODOList.removeTask(name,taskList);
                    System.out.println("Item removed successfully");    
                    }
                    
                }else if(searchMenu.contains("2")){ //modify the task that was searched
                    String modifyOption = getInput("""
                            What would you like to modify?
                            [1] Name
                            [2] Day
                            """);
                    if (modifyOption.contains("1")){ //Modify the name of the task
                        String name = getInput("What is the name of the task you would like to change?");
                        if(TODOList.search(name, taskList)!=-1){
                            String newName = getInput("What would you like to set the name to?");
                            taskList.get(TODOList.search(name,taskList)).setTaskName(newName);
                            System.out.println("Name has been change to: "+ newName);
                        }
                    }else if( modifyOption.contains("2")){ //Modify the day of the task
                        String name = getInput("What is the name of the task you would like to change?");
                        if(TODOList.search(name, taskList)!=-1){
                            int day = Integer.parseInt(getInput("What would you like to set the day to?"));
                            taskList.get(TODOList.search(name,taskList)).setDay(day);
                            System.out.println("Day for "+name+" has been change to "+day);

                        }
                    }
                }else if(searchMenu.contains("3")){
                    String name = getInput("What is the name of the task you are searching for?");
                    if(TODOList.search(name, taskList)!=-1){
                        Task task = TODOList.getTaskAtIndex(name,taskList);
                        System.out.println("Task Found");
                        System.out.printf("Name: %s Day: %d\n",task.getTaskName(),task.getDay());
                    }
                }
            }else if (input.contains("3")){ //This will remove all the tasks that have the day the user enters
                
                String clearDay = getInput("Enter the day that you would like to clear from the list"); //TODO Implement the clear day
                TODOList.clearDay(clearDay, taskList);
                System.out.println("The day has been cleared from the list!");
            }else if (input.contains("4")){ //Clear the whole list
                TODOList.clearList(taskList);
                System.out.println("List cleared!");
            }
            else if(input.contains("5")){ //Print list
                TODOList.printList(taskList);
            }
        }


    public static void main(String[] args) {
        System.out.println("Welcome to the todo list. (To Exit at any time press Q)");
        String mainInput = "";
        while (!mainInput.equalsIgnoreCase("q")) {
            mainInput = getInput(printMenu());
            run(mainInput);
        }
    }
}
