import Controllers.TaskController;
import DTOs.TaskDTO;
import Models.Task;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task Tracker program Started. Type exit whenever you feel to exit the program");
        while(true)
        {
            Scanner obj = new Scanner(System.in);
            TaskController taskController = new TaskController();
            String command = obj.nextLine();
            if(command.equalsIgnoreCase("exit"))
            {
                break;
            }
            String regex = "\\s";
            String[] expressions = command.split(regex);
            if(expressions.length <=1)
            {
                System.out.println("Expressions starts with task-cli <operation-name> and required arguments");
                break;
            }
            String operation = expressions[1];
            StringBuilder description= new StringBuilder();
            switch (operation.toLowerCase())
            {
                case "add":
                    if(expressions.length <= 2) {
                        System.out.println("Operation can not be performed as Description is not supplied");
                    }
                    else {

                        for(int i = 2; i < expressions.length; i++)
                        {
                            description.append(expressions[i]).append(" ");
                        }
                        description.deleteCharAt(description.length()-1);
                        taskController.addTask(description.toString());
                    }
                    break;
                case "update":
                    if(expressions.length <= 3) {
                        System.out.println("Both id and description needed to update the task");
                    }
                    else{
                        Integer id = Integer.parseInt(expressions[2]);
                        for(int i = 3; i < expressions.length; i++)
                        {
                            description.append(expressions[i]).append(" ");
                        }
                        taskController.updateTask(id, description.toString());
                    }
                    break;
                case "delete":
                    if(expressions.length <= 2) {
                        System.out.println("Delete Operation can not be performed as id is not supplied");
                    }
                    else {
                        Integer id = Integer.parseInt(expressions[2]);
                        taskController.deleteTask(id);
                    }
                    break;
                case "list":
                    if(expressions.length == 2)
                    {
                        taskController.listTasks();
                    }
                    else if(expressions.length == 3)
                    {
                        String taskType = expressions[2];
                        taskController.listTaskByStatus(taskType);
                    }
                    break;
                case "mark-in-progress":
                    if(expressions.length <= 2) {
                        System.out.println("Marking Progress Operation can not be performed as id is not supplied");
                    }
                    else {
                        Integer id = Integer.parseInt(expressions[2]);
                        taskController.inProgressTask(id);
                    }
                    break;
                case "mark-done":
                    if(expressions.length <= 2) {
                        System.out.println("Marking Done Operation can not be performed as id is not supplied");
                    }
                    else {
                        Integer id = Integer.parseInt(expressions[2]);
                        taskController.doneTask(id);
                    }
                    break;
                default:
                    System.out.println("Not required input. please type exit to finish program !!!");
                    break;
            }
        }
    }
}