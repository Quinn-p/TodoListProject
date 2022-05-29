import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/*
* @Author  Quinn Peterson
* This class will allow us to manage the items in the list and print out the list
*/
public class TODOList {


    //This will add a task to the array list passed in
    public static void addTask(String task, int day, ArrayList<Task> list){
        Task newTask = new Task(task,day);
        list.add(newTask);

    }

    //This search method will search the list using the name of the task
    public static int search(String name,ArrayList<Task> list){
        for(int i = 0; i<list.size();i++){
           if (list.get(i).getTaskName().equals(name)){
               //return the index of the name
               return i;
           }
        }
        System.out.println("Item was not found!");
        return -1;
    }

    //This is a method that will remove the first task that matches the name passed into the method
    public static void removeTask(String name, ArrayList<Task> list){
        if(search(name, list)!=-1){
        list.remove(search(name, list));
        }
    }



    
    //This method will print all of the strings in the list in a specific format with the name and date
    //It will also output the number that it is in the list
    public static void printList(ArrayList<Task> list) {
        System.out.println("TODO List");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i+1 +": "+list.get(i).toString());
        }
    }

    //This will clear the entire list
    public static void clearList(ArrayList<Task> list){
        list.clear();
    }

    //This method will only clear tasks matching the day entered
    //For some reason this is not 
    public static void clearDay(String day, ArrayList<Task> list){
        int inputDay = Integer.parseInt(day);
            Iterator<Task> it = list.iterator();
            while(it.hasNext()){
                if(it.next().getDay()==inputDay){
                    it.remove();
                }
            }
        
    }

    //This method will sort the list in the order of the day of the task and alphabetically?
    //What sorting algorythm should I use to do this?
    public static void sortList(ArrayList<Task> list){
        //Implement merge or quick sort here
    }


    //Gets the index of a task based on user input name
    public static Task getTaskAtIndex(String name, ArrayList<Task> list){
        if(search(name, list)==-1){
            return null;
        }
        return list.get(search(name, list));
    }

    
    public static void main(String[] args) {
        ArrayList<Task> test = new ArrayList<>();
        test.add(new Task("Laundry", 2));
        test.add(new Task("Dishes", 2));
        test.add(new Task("Clean", 3));
        System.out.println(test);
        clearDay("2", test);
        System.out.println(test);
        //System.out.println(search("Dishes", test));
        //System.out.println(getTaskAtIndex("Dishes", test));
    }
}
