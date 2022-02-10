package com.designpatterns.demo.factoryPatternFileExample;

import com.designpatterns.demo.dto.FileDTO;
import org.springframework.http.MediaType;

public class JpgFile implements FileFactory {

    @Override
    public FileDTO createFile(String format) {

        FileDTO file = new FileDTO();
        file.setTypeFile("jpg");
        file.setFormatFile(MediaType.IMAGE_JPEG_VALUE);

        return file;
    }
}
