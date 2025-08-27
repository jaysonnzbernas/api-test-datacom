package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class JsonUtils {


    public static HashMap readJsonFile(String path_to_json) throws Exception{
        Gson gson = new Gson();

        Reader reader =  Files.newBufferedReader(Paths.get(path_to_json));

        return gson.fromJson(reader, HashMap.class);
    }

    public static <T> String serialise(T clazz){
        Gson gson = new Gson();

        return gson.toJson(clazz);
    }
}
