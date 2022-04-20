package application;

import equations.SystemsManager;
import methods.FixedPointIteration;
import methods.MethodResult;
import utils.Asker;
import utils.IOutil;

public class Main {
    public static void main(String[] args) {
        IOutil io = new IOutil();
        SystemsManager  systemsManager = new SystemsManager();
        Asker asker = new Asker(io, systemsManager);
        FixedPointIteration fixedpoint = new FixedPointIteration(asker, systemsManager);

        boolean running = true;
        while (running) {
            int mode = asker.askMode();
            switch (mode) {
                case (1): {
                    int sysid = asker.askSystem();
                    double eps = 0.00001;
                    int iterations = 10;
                    MethodResult res =fixedpoint.SolveSystem(sysid, eps, iterations, fixedpoint.getGuesses(sysid));
                    io.printResult(res);
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
