package com.designpatterns.demo.factoryPatternFileExample;

import com.designpatterns.demo.dto.FileDTO;
import org.springframework.http.MediaType;

public class JsonFile implements FileFactory {

    @Override
    public FileDTO createFile(String format) {

        FileDTO file = new FileDTO();
        file.setTypeFile("json");
        file.setFormatFile(MediaType.APPLICATION_JSON_VALUE);

        return file;
    }
}
