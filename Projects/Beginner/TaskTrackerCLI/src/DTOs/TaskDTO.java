package DTOs;

import Models.Task;
import Models.TaskType;

public class TaskDTO {
    private int id;
    private String taskDescription;
    private TaskType taskType;
    public TaskDTO(TaskDTOBuilder taskDTOBuilder)
    {
        this.id = taskDTOBuilder.id;
        this.taskDescription = taskDTOBuilder.taskDescription;
        this.taskType = taskDTOBuilder.taskType;
    }
    public static TaskDTOBuilder getBuilder()
    {
        return new TaskDTOBuilder();
    }

    public int getId() {
        return id;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public TaskType getTaskType(){
        return this.taskType;
    }
    public static class TaskDTOBuilder{
        private int id;
        private String taskDescription;
        private TaskType taskType;

        public TaskDTOBuilder setTaskType(TaskType taskType) {
            this.taskType = taskType;
            return this;
        }
        public TaskDTOBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public TaskDTOBuilder setTaskDescription(String taskDescription) {
            this.taskDescription = taskDescription;
            return this;
        }

        public TaskDTO build(){
            return new TaskDTO(this);
        }
    }
}
