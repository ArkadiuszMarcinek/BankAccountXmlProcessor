package com.example.validator;

import java.io.File;

public class XmlValidator {

    public boolean validateInputFile(File file) {
        final String path = file.getAbsolutePath();
        return file.exists() && isXml(path);
    }

    public boolean validateOutputPath(String path) {
        return new File(path).isDirectory();
    }

    private boolean isXml(String path) {
        return path.endsWith(".xml");
    }
}
