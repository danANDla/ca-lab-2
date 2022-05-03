package application;

import equations.SoloEquationsManager;
import equations.SystemsManager;
import methods.FixedPointIteration;
import methods.MethodResult;
import methods.SecantMethod;
import utils.Asker;
import utils.IOutil;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        IOutil io = new IOutil();
        SystemsManager systemsManager = new SystemsManager();
        SoloEquationsManager soloEquationsManager = new SoloEquationsManager();
        Asker asker = new Asker(io, systemsManager, soloEquationsManager);
        FixedPointIteration fixedpoint = new FixedPointIteration(asker, systemsManager, soloEquationsManager);
        SecantMethod secantMethod = new SecantMethod(asker, systemsManager, soloEquationsManager);

        boolean running = true;
        while (running) {
            int mode = asker.askMode();
            switch (mode) {
                case (1): {
                    int sysid = asker.askSystem();
                    if (sysid == -1) break;
                    double eps = asker.askEps();
                    int iterations = asker.askIterations();
                    MethodResult res = fixedpoint.solveSystem(sysid, eps, iterations, asker.getGuessesOfSys(sysid));
                    io.printResult(res);
                    break;
                }
                case (2): {
                    int eqid = asker.askEquation();
                    if (eqid == -1) break;
                    double eps = asker.askEps();
                    int iterations = asker.askIterations();
                    HashMap<String, Double> guess = asker.getGuessOfEq(eqid);
                    System.out.println(guess);

                    MethodResult resSimple = fixedpoint.solveEquation(eqid, eps, iterations, guess);
                    double simple = resSimple.getValues().get("x");
                    io.printWarning("метод простой итерации");
                    io.printResult(resSimple);

                    MethodResult resSecant = secantMethod.solveEquation(eqid, eps, iterations, guess);
                    double secant = resSecant.getValues().get("x");
                    io.printWarning("метод Ньютона");
                    io.printResult(resSecant);

                    io.printText("");
                    io.printText("diff = " + Math.abs(secant - simple));

                    break;
                }
                case (0): {
                    running = false;
                    break;
                }
            }
        }

    }
}
