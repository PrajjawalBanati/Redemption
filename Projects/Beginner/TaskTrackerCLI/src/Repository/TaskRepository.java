package Repository;

import DTOs.TaskDTO;
import Models.TaskType;

import java.util.List;


public interface TaskRepository {
    public void addTask(TaskDTO task);
    public void deleteTask(TaskDTO task);
    public void updateTask(Integer id, TaskDTO updateTask);
    public void updateTaskStatus(Integer id, TaskType taskType);
    public List<TaskDTO> getAllTasks();
    public TaskDTO getTask(Integer id);

}
