package pl.sda;

import pl.sda.instructions.Instructions;
import pl.sda.interperter.Interpreter;
import pl.sda.memory.DataMemory;
import pl.sda.memory.ProgramMemory;
import pl.sda.parser.ProgramParser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        ProgramParser programParser = new ProgramParser("D:\\Projekty_Java\\WzorceProjektowe5BasicInterpreter\\src\\main\\resources\\Main.txt", ProgramMemory.getInstance());

        try {
            programParser.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Instructions instructions = new Instructions(ProgramMemory.getInstance(), DataMemory.getInstance());
        Interpreter interpreter = new Interpreter(ProgramMemory.getInstance(), DataMemory.getInstance(), instructions);
        interpreter.start();

    }
}
