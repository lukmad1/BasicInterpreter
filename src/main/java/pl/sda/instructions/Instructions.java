package pl.sda.instructions;

import pl.sda.memory.DataMemory;
import pl.sda.memory.ProgramMemory;

import java.util.Arrays;
import java.util.List;

public class Instructions {
    public List<Instruction> availableInstructions;


    public Instructions(ProgramMemory programMemory, DataMemory dataMemory) {
        this.availableInstructions = Arrays.asList(new Set(dataMemory), new Get(dataMemory), new Print(), new GoTo(programMemory), new Read(dataMemory));
    }


    public void execute(String cmd) {
        for (Instruction instruction : availableInstructions) {
            if (instruction.isApplicable(cmd)) {
                instruction.execute(cmd);
            }
        }

    }


}
