package pl.sda.instructions;

import pl.sda.memory.DataMemory;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Read implements Instruction {
    private DataMemory dataMemory;
    private final String READ_REGEXP = "(READ )(\\w+)";

    public Read(DataMemory dataMemory) {
        this.dataMemory = dataMemory;
    }

    @Override
    public boolean isApplicable(String cmd) {
        return cmd.matches(READ_REGEXP);
    }

    @Override
    public void execute(String cmd) {
        Pattern pattern = Pattern.compile(READ_REGEXP);
        Matcher matcher = pattern.matcher(cmd);

        if (matcher.find()) {
            String key = matcher.group(2);
            System.out.println("Podaj wartosc dla zmiennej: " + key);
            Scanner sc = new Scanner(System.in);
            dataMemory.put(key, sc.nextLine());
        }

    }
}
