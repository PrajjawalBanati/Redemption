package Services;

import DTOs.TaskDTO;
import Models.TaskType;

import java.util.List;

public interface TaskService {
    public void addTask( String description);
    public void deleteTask(Integer id);
    public void updateTask(Integer id, String description);
    public void updateTaskStatus(Integer id, TaskType taskType);
    public TaskDTO getTask(Integer id);
    public List<TaskDTO> listTasks();
    public List<TaskDTO> listTasks(String statusType);
}
