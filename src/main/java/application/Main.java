package application;

import equations.SoloEquationsManager;
import equations.SystemsManager;
import methods.FixedPointIteration;
import methods.MethodResult;
import methods.SecantMethod;
import utils.Asker;
import utils.IOutil;

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
                    double eps = 0.00001;
                    int iterations = 10;
                    MethodResult res = fixedpoint.solveSystem(sysid, eps, iterations, asker.getGuessesOfSys(sysid));
                    io.printResult(res);
                    break;
                }
                case (2): {
                    int eqid = asker.askEquation();
                    if (eqid == -1) break;
                    double eps = 0.00001;
                    int iterations = 100;
                    MethodResult res = fixedpoint.solveEquation(eqid, eps, iterations, asker.getGuessOfEq(eqid));
                    io.printText("метод простой итерации");
                    io.printResult(res);
                }
                case (0): {
                    running = false;
                    break;
                }
            }
        }

    }
}
