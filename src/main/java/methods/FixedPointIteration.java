package methods;

import equations.Equation;
import equations.Sys1eq1;
import equations.Sys1eq2;
import equations.SystemsManager;
import utils.Asker;

import java.util.ArrayList;
import java.util.HashMap;


public class FixedPointIteration {
    private SystemsManager systemsManager;
    private Asker asker;
    private ArrayList<Equation> allEquations;
    private ArrayList<ArrayList<Equation>> allSystems;

    public FixedPointIteration(Asker asker, SystemsManager systemsManager) {
        this.asker = asker;
        this.systemsManager = systemsManager;
        allSystems = systemsManager.getAllSystems();
    }

    public HashMap<String, Double> getGuesses(int sysid){
        ArrayList<Equation> system =  allSystems.get(sysid);
        HashMap<String, Double> res = new HashMap<>();
        for(int i = 0; i < system.size(); ++i){
            String var = system.get(i).getVarOfConversed();
            double guess = asker.askGuess(var);
            res.put(var, guess);
        }
        return res;
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

//    private Equation getEquation(int sysId){
//
//    }
}
