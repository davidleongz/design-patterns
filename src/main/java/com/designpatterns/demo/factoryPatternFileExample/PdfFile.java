package com.designpatterns.demo.factoryPatternFileExample;

import com.designpatterns.demo.dto.FileDTO;
import org.springframework.http.MediaType;

public class PdfFile implements FileFactory {

    @Override
    public FileDTO createFile(String format) {

        FileDTO file = new FileDTO();
        file.setTypeFile("pdf");
        file.setFormatFile(MediaType.APPLICATION_PDF_VALUE);

        return file;
    }
}
