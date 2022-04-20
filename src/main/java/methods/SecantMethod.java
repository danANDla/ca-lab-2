package methods;

import equations.Equation;
import equations.SoloEquationsManager;
import equations.SystemsManager;
import utils.Asker;

import java.util.ArrayList;
import java.util.HashMap;

public class SecantMethod {
    Asker asker;
    SoloEquationsManager soloEquationsManager;
    ArrayList<Equation> allEquations;

    public SecantMethod(Asker asker, SystemsManager systemsManager, SoloEquationsManager soloEquationsManager) {
        this.asker = asker;
        this.soloEquationsManager = soloEquationsManager;
        allEquations = soloEquationsManager.getAllEqations();
    }

    public MethodResult solveEquation(int eqid, double eps, int iterations, HashMap<String, Double> guesses){
        Equation eq = allEquations.get(eqid);
        HashMap<String, Double> current = guesses;
        System.out.println(guesses);
        while(iterations-- >= 0){
            int epsCounter = 0;
            String var = eq.getVarOfConversed();
            Double approxima = current.get(var) - eq.getImage(current) / eq.get1Derivative(current, var);
            if(Math.abs(current.get(var) - approxima) <= eps) epsCounter++;
            current.replace(var, approxima);
            if (epsCounter == 1) break;
        }
        return  new MethodResult(current, Status.OK);
    }
}
