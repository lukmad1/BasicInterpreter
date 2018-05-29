package pl.sda.parser;

import java.io.FileNotFoundException;

public class NoProgramFileException extends FileNotFoundException{

    public NoProgramFileException(String message) {
        super(message);
    }

    public NoProgramFileException() {

    }
}
