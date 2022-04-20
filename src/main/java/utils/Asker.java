package utils;
import equations.Equation;
import equations.SoloEquationsManager;
import equations.SystemsManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class Asker {
    private IOutil io;
    private SystemsManager systemsManager;
    private SoloEquationsManager soloEquationsManager;

    public Asker(IOutil io, SystemsManager systemsManager, SoloEquationsManager soloEquationsManager) {
        this.io = io;
        this.systemsManager = systemsManager;
        this.soloEquationsManager = soloEquationsManager;
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
                "(2) уравнение\n" +
                "(0) выход из приложения\n");
        while (!valid) {
            try {
                mode = Integer.parseInt(getNonEmpty());
                valid = true;
                if (mode < 0 || mode > 2) {
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
        io.printText("(0) отмена");
        while (!valid) {
            try {
                sysid = Integer.parseInt(getNonEmpty()) - 1;
                valid = true;
                if (sysid < -1 || sysid >= systemsManager.getAllSystems().size()) {
                    io.printError("Такой опции нет");
                    valid = false;
                }
            } catch (NumberFormatException e) {
                io.printError("Неправильный формат целого числа");
            }
        }
        return sysid;
    }

    public HashMap<String, Double> getGuessesOfSys(int sysid){
        ArrayList<Equation> system =  systemsManager.getAllSystems().get(sysid);
        HashMap<String, Double> res = new HashMap<>();
        for(int i = 0; i < system.size(); ++i){
            String var = system.get(i).getVarOfConversed();
            double guess = askGuess(var);
            res.put(var, guess);
        }
        return res;
    }

    public HashMap<String, Double> getGuessOfEq(int eqid){
        Equation eq = soloEquationsManager.getAllEqations().get(eqid);
        HashMap<String, Double> res = new HashMap<>();
        String var = eq.getVarOfConversed();
        double guess = askGuess(var);
        res.put(var, guess);
        return res;
    }

    private double askGuess(String var){
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

    public double askEps(){
        io.printText("Введите точность");
        boolean valid = false;
        double eps = 0;
        while (!valid) {
            try {
                eps = Double.parseDouble(getNonEmpty());
                valid = true;
            } catch (NumberFormatException e) {
                io.printError("Неправильный формат числа");
            }
        }
        return eps;
    }

    public int askIterations(){
        io.printText("Введите максимальное количество итераций");
        boolean valid = false;
        int iterations = 0;
        while (!valid) {
            try {
                iterations = Integer.parseInt(getNonEmpty());
                valid = true;
            } catch (NumberFormatException e) {
                io.printError("Неправильный формат числа");
            }
        }
        return iterations;
    }

    public int askEquation(){
        int sysid = 0;
        boolean valid = false;
        io.printText("Выберите уравнение:");
        for(int i = 0; i < soloEquationsManager.getAllEqations().size(); ++i){
            System.out.printf("(%d) ", i+1);
            io.printText(soloEquationsManager.getAllEqations().get(i).toString());
        }
        io.printText("(0) отмена");
        while (!valid) {
            try {
                sysid = Integer.parseInt(getNonEmpty()) - 1;
                valid = true;
                if (sysid < -1 || sysid >= soloEquationsManager.getAllEqations().size()) {
                    io.printError("Такой опции нет");
                    valid = false;
                }
            } catch (NumberFormatException e) {
                io.printError("Неправильный формат целого числа");
            }
        }
        return sysid;
    }
}
