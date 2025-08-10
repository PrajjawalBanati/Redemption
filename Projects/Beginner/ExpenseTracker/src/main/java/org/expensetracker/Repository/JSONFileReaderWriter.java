package org.expensetracker.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class JSONFileReaderWriter<K>{
    private String fileName;
    private File fileObject;
    private ObjectMapper objectMapper;
    private static JSONFileReaderWriter<?> jsonFileReaderWriter;
    private JSONFileReaderWriter()
    {
        fileName = "Expenses.json";
        this.objectMapper = new ObjectMapper();
        fileObject = new File(fileName);
        if(!fileObject.exists())
        {
            try{
                if(fileObject.createNewFile())
                {
                    this.objectMapper.writeValue(this.fileObject,new ArrayList<>());
                }

            }
            catch(IOException excp)
            {
                throw new RuntimeException(Arrays.toString(excp.getStackTrace()));
            }
        }
    }
    public void writeFile(K value)
    {
        try{
            this.objectMapper.writeValue(this.fileObject, value);
        }
        catch(IOException excp)
        {
            throw new RuntimeException(excp.getStackTrace().toString());
        }
    }
    public K readFile() {
        try {
            return this.objectMapper.readValue(this.fileObject, new TypeReference<>() {
            });
        } catch (IOException excp)
        {
            throw new RuntimeException(excp.getStackTrace().toString());
        }
    }
    public static JSONFileReaderWriter<?> getInstance()
    {
        if(jsonFileReaderWriter == null)
        {
            synchronized (JSONFileReaderWriter.class)
            {
                if(jsonFileReaderWriter == null)
                {
                    jsonFileReaderWriter = new JSONFileReaderWriter<>();
                }
            }
        }
        return jsonFileReaderWriter;
    }
}
