package utils;
import equations.Equation;
import equations.SystemsManager;

import java.util.Locale;

public class Asker {
    private IOutil io;
    private SystemsManager systemsManager;

    public Asker(IOutil io, SystemsManager systemsManager){
        this.io = io;
        this.systemsManager = systemsManager;
    }

    private String getNonEmpty() {
        String str;
        io.printArrow();
        str = io.readLine().trim();
        while (str.equals("")) {
            str = io.readLine().trim();
        }
        return str;
    }

    public int askMode() {
        int mode = 0;
        boolean valid = false;
        io.printDivider();
        io.printText("Выберите задачу:\n" +
                "(1) система уравнений\n" +
                "(0) выход из приложения\n");
        while (!valid) {
            try {
                mode = Integer.parseInt(getNonEmpty());
                valid = true;
                if (mode < 0 || mode > 1) {
                    io.printError("Такой опции нет");
                    valid = false;
                }
            } catch (NumberFormatException e) {
                io.printError("Неправильный формат целого числа");
            }
        }
        return mode;
    }

    public int askSystem(){
        int sysid = 0;
        boolean valid = false;
        io.printText("Выберите систему:");
        for(int i = 0; i < systemsManager.getAllSystems().size(); ++i){
            System.out.printf("(%d) \n", i+1);
            io.printText("{");
            for(Equation eq: systemsManager.getAllSystems().get(i)){
                io.printText("  " + eq.toString());
            }
            io.printText("}");
            io.printText("");
        }
        while (!valid) {
            try {
                sysid = Integer.parseInt(getNonEmpty()) - 1;
                valid = true;
                if (sysid < 0 || sysid >= systemsManager.getAllSystems().size()) {
                    io.printError("Такой опции нет");
                    valid = false;
                }
            } catch (NumberFormatException e) {
                io.printError("Неправильный формат целого числа");
            }
        }
        return sysid;
    }

    public double askGuess(String var){
        io.printText("Введите нулевое приближение переменной " + var);
        boolean valid = false;
        double guess = 0;
        while (!valid) {
            try {
                guess = Double.parseDouble(getNonEmpty());
                valid = true;
            } catch (NumberFormatException e) {
                io.printError("Неправильный формат числа");
            }
        }
        return guess;
    }
}
