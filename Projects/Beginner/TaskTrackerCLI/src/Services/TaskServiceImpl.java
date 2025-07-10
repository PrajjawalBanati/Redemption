package Services;

import DTOs.TaskDTO;
import Models.TaskType;
import Repository.TaskRepository;
import Repository.TaskRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class TaskServiceImpl implements TaskService {
    public TaskRepository taskRepository;
    public TaskServiceImpl()
    {
        this.taskRepository = new TaskRepositoryImpl();
    }

    @Override
    public void addTask(String description) {
        List<TaskDTO> taskDTOList = this.listTasks();
        TaskDTO taskDTO;
        if(taskDTOList.isEmpty())
        {
             taskDTO = TaskDTO.getBuilder().setId(1).setTaskDescription(description).setTaskType(TaskType.TODO).build();
        }
        else{
             taskDTO = TaskDTO.getBuilder().setId(taskDTOList.getLast().getId()+1).setTaskDescription(description).setTaskType(TaskType.TODO).build();
        }

        taskRepository.addTask(taskDTO);
    }

    @Override
    public void deleteTask(Integer id) {
        this.taskRepository.deleteTask(TaskDTO.getBuilder().setId(id).build());
    }

    @Override
    public void updateTask(Integer id, String description) {
        TaskDTO updatedTaskDTO = TaskDTO.getBuilder().setId(id).setTaskDescription(description).build();
        this.taskRepository.updateTask(id, updatedTaskDTO);
    }

    @Override
    public void updateTaskStatus(Integer id, TaskType taskType) {
        this.taskRepository.updateTaskStatus(id, taskType);
    }

    @Override
    public TaskDTO getTask(Integer id) {
        return this.taskRepository.getTask(id);
    }

    @Override
    public List<TaskDTO> listTasks() {
        return this.taskRepository.getAllTasks();
    }

    @Override
    public List<TaskDTO> listTasks(String statusType) {
        List<TaskDTO> taskDTOList = this.taskRepository.getAllTasks();
        List<TaskDTO> getTasks = new ArrayList<>();
        for(TaskDTO taskDTO: taskDTOList){
            if(taskDTO.getTaskType().toString().equalsIgnoreCase(statusType))
            {
                getTasks.add(taskDTO);
            }
        }
        return getTasks;
    }
}
