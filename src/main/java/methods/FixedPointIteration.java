package methods;

import equations.*;
import utils.Asker;

import java.util.ArrayList;
import java.util.HashMap;


public class FixedPointIteration {
    private SystemsManager systemsManager;
    private SoloEquationsManager soloEquationsManager;
    private Asker asker;
    private ArrayList<Equation> allEquations;
    private ArrayList<ArrayList<Equation>> allSystems;

    public FixedPointIteration(Asker asker, SystemsManager systemsManager, SoloEquationsManager soloEquationsManager) {
        this.asker = asker;
        this.systemsManager = systemsManager;
        this.soloEquationsManager = soloEquationsManager;
        allSystems = systemsManager.getAllSystems();
        allEquations = soloEquationsManager.getAllEqations();
    }

    public MethodResult SolveSystem(int sysid, double eps, int iterations, HashMap<String, Double> guesses){
        ArrayList<Equation> system =  allSystems.get(sysid);
        HashMap<String, Double> current = guesses;

        System.out.println(guesses);
        while(iterations-- >= 0){
            int epsCounter = 0;
            for(int i = 0; i < system.size(); ++i){
                String var = system.get(i).getVarOfConversed();
                Double approxima = system.get(i).getConversed(current);
                if(Math.abs(current.get(var) - approxima) <= eps) epsCounter++;
                current.replace(var, approxima);
            }
            if (epsCounter == system.size()) break;
        }
        return  new MethodResult(current, Status.OK);
    }

    public MethodResult SolveEquation(int eqid, double eps, int iterations, HashMap<String, Double> guesses){
        Equation eq = allEquations.get(eqid);
        HashMap<String, Double> current = guesses;
        System.out.println(guesses);
        while(iterations-- >= 0){
            int epsCounter = 0;
            String var = eq.getVarOfConversed();
            Double approxima = eq.getConversed(current);
            System.out.println("Approxima is " + approxima);
            System.out.println("Broot approxima is " + Math.cos(current.get("x")) / Math.exp(current.get("x")));
            if(Math.abs(current.get(var) - approxima) <= eps) epsCounter++;
            current.replace(var, approxima);
            if (epsCounter == 1) break;
        }
        return  new MethodResult(current, Status.OK);
    }
}
