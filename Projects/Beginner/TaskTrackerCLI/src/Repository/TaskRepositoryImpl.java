package Repository;

import DTOs.TaskDTO;
import Models.Task;
import Models.TaskType;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TaskRepositoryImpl implements TaskRepository {
    private final HashMap<Integer, Task> taskMap = new HashMap<>();
    private final JSONFileWriterReader jsonFileWriterReader;
    public TaskRepositoryImpl() {
        this.jsonFileWriterReader = JSONFileWriterReader.getInstance();
        logTasksToMap();
    }

    private void logTasksToMap(){
        try{
            List<Task> tasks = this.jsonFileWriterReader.readTasks();
            for(Task task: tasks)
            {
                this.taskMap.put(task.getId(), task);
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public void addTask(TaskDTO task) {
        Task taskInst = Task.getTaskBuilder().setId(task.getId()).
                setDescription(task.getTaskDescription()).
                setTaskType(task.getTaskType()).
                setCreatedAt(Instant.now()).
                setUpdatedAt(Instant.now()).
                build();
        try{
            if(this.taskMap.isEmpty())
            {
                this.jsonFileWriterReader.logTask(List.of(taskInst));
                this.taskMap.put(taskInst.getId(), taskInst);
            }
            else {
                this.taskMap.put(taskInst.getId(), taskInst);
                this.jsonFileWriterReader.clearFileContents();
                this.jsonFileWriterReader.logTask(this.taskMap.values().stream().toList());
            }

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deleteTask(TaskDTO task) {
        this.jsonFileWriterReader.clearFileContents();
        this.taskMap.remove(task.getId());
        List<Task> taskList = taskMap.values().stream().toList();
        try{
            this.jsonFileWriterReader.logTask(taskList);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void updateTask(Integer id, TaskDTO updateTask) {
        this.jsonFileWriterReader.clearFileContents();
        Task task = this.taskMap.get(id);
        Task updatedTask = Task.getTaskBuilder().
                setId(task.getId()).
                setDescription(updateTask.getTaskDescription()).
                setTaskType(task.getTaskType()).
                setUpdatedAt(Instant.now()).
                setCreatedAt(task.getCreatedAt()).
                build();
        this.taskMap.put(id,updatedTask);
        try{
            this.jsonFileWriterReader.logTask(this.taskMap.values().stream().toList());
        }
        catch (IOException e)
        {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void updateTaskStatus(Integer id, TaskType taskType) {
        this.jsonFileWriterReader.clearFileContents();
        Task task = this.taskMap.get(id);
        Task updatedTask = Task.getTaskBuilder().
                setId(task.getId()).
                setDescription(task.getDescription()).
                setTaskType(taskType).
                setUpdatedAt(Instant.now()).
                setCreatedAt(task.getCreatedAt()).
                build();
        this.taskMap.put(id,updatedTask);
        try{
            this.jsonFileWriterReader.logTask(this.taskMap.values().stream().toList());
        }
        catch (IOException e)
        {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        List<TaskDTO> taskDTOList = new ArrayList<>();
        if(this.taskMap.isEmpty())
        {
            return new ArrayList<>();
        }
        else {
            for (Task task: this.taskMap.values().stream().toList())
            {
                taskDTOList.add(TaskDTO.getBuilder().
                        setId(task.getId()).
                        setTaskType(task.getTaskType()).
                        setTaskDescription(task.getDescription()).
                        build());
            }
        }
        return taskDTOList;
    }

    @Override
    public TaskDTO getTask(Integer id) {
        Task task = this.taskMap.get(id);
        return TaskDTO.getBuilder().setId(id).setTaskDescription(task.getDescription()).setTaskType(task.getTaskType()).build();
    }



}
