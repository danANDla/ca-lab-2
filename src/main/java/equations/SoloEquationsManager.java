package equations;

import java.util.ArrayList;

public class SoloEquationsManager {
    ArrayList<Equation> allEqations;

    public SoloEquationsManager() {
        allEqations = new ArrayList<>();
        allEqations.add(new eq1());
    }

    public ArrayList<Equation> getAllEqations() {
        return allEqations;
    }
}

