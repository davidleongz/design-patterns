package com.designpatterns.demo.factoryPatternFileExample;

import com.designpatterns.demo.dto.FileDTO;
import org.springframework.http.MediaType;

public class HtmlFile implements FileFactory {

    @Override
    public FileDTO createFile(String format) {

        FileDTO file = new FileDTO();
        file.setTypeFile("html");
        file.setFormatFile(MediaType.TEXT_HTML_VALUE);

        return file;
    }
}
