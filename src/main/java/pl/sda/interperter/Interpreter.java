package pl.sda.interperter;

import pl.sda.expressions.*;
import pl.sda.instructions.Instructions;
import pl.sda.memory.DataMemory;
import pl.sda.memory.ProgramMemory;

import java.util.List;

public class Interpreter {
    private ProgramMemory programMemory;
    private DataMemory dataMemory;
    private Instructions instructions;


    public Interpreter(ProgramMemory programMemory, DataMemory dataMemory, Instructions instructions) {
        this.programMemory = programMemory;
        this.dataMemory = dataMemory;
        this.instructions = instructions;
    }

    public void start() {
        List<String> addresses = programMemory.addresses();

        for (programMemory.setProgramCounter(0); programMemory.getProgramCounter() < addresses.size(); ) {
            String instructionAddress = addresses.get(programMemory.getProgramCounter());
            String instruction = programMemory.get(instructionAddress);
            programMemory.incrementProgramCounter();

            Expression expression = new EvaluateVariableExpression(dataMemory);
            instruction = expression.evaluate(instruction);

            expression = new MulExpression(expression);
            instruction = expression.evaluate(instruction);

            expression = new DivExpression(expression);
            instruction = expression.evaluate(instruction);

            expression = new SumExpression(expression);
            instruction = expression.evaluate(instruction);

            expression = new SubExpression(expression);
            instruction = expression.evaluate(instruction);

            expression = new IfExpression(dataMemory);
            instruction = expression.evaluate(instruction);

            this.instructions.execute(instruction);


        }
    }


}
