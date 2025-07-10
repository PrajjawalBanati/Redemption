package Controllers;

import DTOs.TaskDTO;
import Models.TaskType;
import Services.TaskService;
import Services.TaskServiceImpl;

import javax.swing.*;
import java.util.List;

public class TaskController {
    public TaskService taskService;
    private static void printTasks(List<TaskDTO> taskDTOList)
    {
        for(TaskDTO taskDTO: taskDTOList)
        {
            System.out.println("Id "+taskDTO.getId());
            System.out.println("Description "+taskDTO.getTaskDescription());
            System.out.println("Status "+taskDTO.getTaskType().toString());

        }
    }
    public TaskController()
    {
        this.taskService = new TaskServiceImpl();
    }

    public void addTask(String description)
    {
        int id = this.taskService.addTask(description);
        System.out.println("Task added successfully (ID: "+id+")");
    }

    public void listTasks()
    {
        List<TaskDTO> taskDTOList = this.taskService.listTasks();
        printTasks(taskDTOList);
    }

    public void listTaskByStatus(String statusType)
    {
        List<TaskDTO> tasksFetched = this.taskService.listTasks(statusType);
        printTasks(tasksFetched);
    }

    public void updateTask(Integer id, String description)
    {
        this.taskService.updateTask(id, description);
    }

    public void deleteTask(Integer id)
    {
        this.taskService.deleteTask(id);
    }

    public void doneTask(Integer id)
    {
        this.taskService.updateTaskStatus(id, TaskType.DONE);
    }
    public void inProgressTask(Integer id)
    {
        this.taskService.updateTaskStatus(id, TaskType.IN_PROGRESS);
    }

}
