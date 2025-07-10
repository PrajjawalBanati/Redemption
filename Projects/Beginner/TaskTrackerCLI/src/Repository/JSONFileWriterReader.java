package Repository;

import Models.Task;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONFileWriterReader {
    private File fileName;
    private ObjectMapper objectMapper;
    private JSONFileWriterReader()
    {
        this.fileName = new File("Data.json");
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
        this.objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        // Create the file if it doesn't exist
        try {
            if (!this.fileName.exists()) {
                this.fileName.createNewFile();
                // Initialize with empty array
                this.objectMapper.writeValue(this.fileName, new ArrayList<Task>());
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to create/initialize JSON file: " + e.getMessage());
        }
    }

    private static final class JsonFileWriterReaderHolder {
        private static final JSONFileWriterReader jsonFileWriterReader = new JSONFileWriterReader();
    }

    public static JSONFileWriterReader getInstance()
    {
        return JsonFileWriterReaderHolder.jsonFileWriterReader;
    }

    public void logTask(Task task) throws IOException
    {
        this.objectMapper.writeValue(this.fileName,task);
    }

    public void logTask(List<Task> taskList) throws IOException
    {
        this.objectMapper.writeValue(this.fileName, taskList);
    }

    public List<Task> readTasks() throws IOException
    {
        return this.objectMapper.readValue(this.fileName, new TypeReference<>() {
        });
    }

    public void clearFileContents(){
        try{
            FileWriter fileWriter = new FileWriter(this.fileName);
            fileWriter.write("{}");
        }
        catch(Exception e)
        {
            throw new RuntimeException(e.getMessage());
        }


    }


}
