package equations;

import java.util.HashMap;
import java.util.Objects;

public class Sys1eq1 implements Equation {
    @Override
    public Double getImage(HashMap<String, Double> args) {
        if (args.get("x") != null && args.get("y") != null) {
            double x = args.get("x");
            double y = args.get("y");
            return x * x + x * y - 10;
        }
        return null;
    }

    @Override
    public Double get1Derivative(HashMap<String, Double> args, String diffVar) {
        if (args.get("x") != null && args.get("y") != null) {
            double x = args.get("x");
            double y = args.get("y");
            if (Objects.equals(diffVar, "x")) return 2 * x + y;
            else if (Objects.equals(diffVar, "y")) return x;
        }
        return null;
    }

    @Override
    public Double get2Derivative(HashMap<String, Double> args, String diffVar) {
        if (args.get("x") != null && args.get("y") != null) {
            double x = args.get("x");
            double y = args.get("y");
            if (Objects.equals(diffVar, "x")) return 2.0;
            else if (Objects.equals(diffVar, "y")) return 0.0;
        }
        return null;
    }

    @Override
    public Double getConversed(HashMap<String, Double> args) {
        if (args.get("x") != null && args.get("y") != null) {
            double x = args.get("x");
            double y = args.get("y");
            return Math.sqrt(10 - x * y);
        }
        return null;
    }

    @Override
    public String getVarOfConversed() {
        return "x";
    }

    public String toString() {
        String s = "x^2 + x*y - 10 = 0";
        return s;
    }
}

