package equations;

import java.util.HashMap;
import java.util.Objects;

public class eq2 implements  Equation{
    @Override
    public Double getImage(HashMap<String, Double> args) {
        if (args.get("x") != null) {
            double x = args.get("x");
            return Math.cos(x) - x;
        }
        return null;
    }

    @Override
    public Double getDerivative(HashMap<String, Double> args, String diffVar) {
        if (args.get("x") != null) {
            double x = args.get("x");
            if (Objects.equals(diffVar, "x")) return -1 - Math.sin(x);
        }
        return null;
    }

    @Override
    public Double getConversed(HashMap<String, Double> args) {
        if (args.get("x") != null) {
            double x = args.get("x");
            return Math.cos(x);
        }
        return null;
    }

    @Override
    public String getVarOfConversed() {
        return "x";
    }

    public String toString() {
        String s = "f(x) = cos(x) - x";
        return s;
    }
}
