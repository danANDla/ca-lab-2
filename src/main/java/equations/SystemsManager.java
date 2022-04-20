package equations;

import java.util.ArrayList;

public class SystemsManager {
    ArrayList<ArrayList<Equation>> allSystems;

    public SystemsManager() {
        allSystems = new ArrayList<>();

        ArrayList<Equation> sys = new ArrayList<>();
        sys.add(new Sys1eq1());
        sys.add(new Sys1eq2());
        allSystems.add(sys);
    }

    public ArrayList<ArrayList<Equation>> getAllSystems() {
        return allSystems;
    }

    public void addSystem(ArrayList<Equation> newSystem){
        this.allSystems.add(newSystem);
    }
}
