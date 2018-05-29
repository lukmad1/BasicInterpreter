package pl.sda.parser;

import pl.sda.memory.DataMemory;
import pl.sda.memory.ProgramMemory;

import java.io.*;

public class ProgramParser {
    private File file;
    private ProgramMemory programMemory;

    public ProgramParser(String path, ProgramMemory programMemory) {
        this.file = new File(path);
        this.programMemory = programMemory;
    }

    public ProgramParser(ProgramMemory programMemory) {
        this.programMemory = programMemory;
    }

    public void setFilePath(String path) {
        this.file = new File(path);
    }

    public void load() throws IOException {

        if (!file.exists()) throw new NoProgramFileException("Program file not found!");

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String instruction;
        while ((instruction = bufferedReader.readLine()) != null) {
            this.programMemory.put(instruction.substring(0, instruction.indexOf(' ')), instruction.replaceAll("^\\d+ ", ""));
        }

    }
}
