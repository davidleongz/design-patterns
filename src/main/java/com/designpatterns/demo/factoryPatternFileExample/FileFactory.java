package com.designpatterns.demo.factoryPatternFileExample;

import com.designpatterns.demo.dto.FileDTO;

public interface FileFactory {

    FileDTO createFile(String format);
}
