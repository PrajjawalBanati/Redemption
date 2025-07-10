package Models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.time.Instant;

@JsonDeserialize(builder = Task.TaskBuilder.class)
public class Task {
    private int id;
    private String description;
    private TaskType taskType;
    private Instant createdAt;
    private Instant updatedAt;

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    private Task(TaskBuilder taskBuilder)
    {
        this.id = taskBuilder.id;
        this.description = taskBuilder.description;
        this.taskType = taskBuilder.taskType;
        this.createdAt = taskBuilder.createdAt;
        this.updatedAt = taskBuilder.updatedAt;
    }
    @JsonPOJOBuilder(withPrefix = "set")
    public static class TaskBuilder{
        private int id;
        private String description;
        private TaskType taskType;
        private Instant createdAt;
        private Instant updatedAt;

        public TaskBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public TaskBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public TaskBuilder setTaskType(TaskType taskType) {
            this.taskType = taskType;
            return this;
        }

        public TaskBuilder setCreatedAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public TaskBuilder setUpdatedAt(Instant updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Task build()
        {
            return new Task(this);
        }
    }

    public static TaskBuilder getTaskBuilder()
    {
        return new TaskBuilder();
    }

}
