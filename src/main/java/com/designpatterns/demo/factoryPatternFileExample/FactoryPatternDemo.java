package com.designpatterns.demo.factoryPatternFileExample;

import com.designpatterns.demo.dto.FileDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;

@Slf4j
public class FactoryPatternDemo {

    public static void main(String[] args) {

        String format = "json";
        FileDTO file = formatResponse(format);
        log.info("File: {}", file.getTypeFile());


        
    }

    public static FileDTO formatResponse(String format) {

        FileDTO file  = new FileDTO();

        if ("json".equals(format)) {

            file.setTypeFile("json");
            file.setFormatFile(MediaType.APPLICATION_JSON_VALUE);

        } else if ("html".equals(format)) {

            file.setTypeFile("html");
            file.setFormatFile(MediaType.TEXT_HTML_VALUE);

        } else if ("pdf".equals(format)) {

            file.setTypeFile("pdf");
            file.setFormatFile(MediaType.APPLICATION_PDF_VALUE);

        } else {

            file.setTypeFile("jpg");
            file.setFormatFile(MediaType.IMAGE_JPEG_VALUE);
        }

        return file;
    }


    private static FileFactory extractGetInstanceFileStrategy() {
        FileFactory fileStrategy = new FileFactory() {
            @Override
            public FileDTO createFile(String format) {
                return null;
            }
        };
        return fileStrategy;
    }



}
