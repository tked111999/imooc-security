package com.imooc.dto;

import lombok.Data;

@Data
public class FileInfo {
    private String path;

    public FileInfo(String path) {
        this.path = path;
    }

}
