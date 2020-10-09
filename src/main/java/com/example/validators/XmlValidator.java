package com.example.validators;

import java.io.File;

public class XmlValidator {

    public boolean validateInputFile(File file) {
        final String path = file.getAbsolutePath();
        return file.exists() && isXml(path);
    }

    private boolean isXml(String path) {
        return path.endsWith(".xml");
    }

    public boolean validateOutputPath(String path) {
        return new File(path).isDirectory();
    }

}
