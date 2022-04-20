package equations;


import java.util.HashMap;
import java.util.Objects;

public class Sys1eq2 implements Equation {
    @Override
    public Double getImage(HashMap<String, Double> args) {
        if (args.get("x") != null && args.get("y") != null) {
            double x = args.get("x");
            double y = args.get("y");
            return y + 3 * x * y * y - 57;
        }
        return null;
    }

    @Override
    public Double get1Derivative(HashMap<String, Double> args, String diffVar) {
        if (args.get("x") != null && args.get("y") != null) {
            double x = args.get("x");
            double y = args.get("y");
            if (Objects.equals(diffVar, "x")) return 3 * y * y;
            else if (Objects.equals(diffVar, "y")) return 1 + 6 * x * y;
        }
        return null;
    }

    @Override
    public Double get2Derivative(HashMap<String, Double> args, String diffVar) {
        if (args.get("x") != null && args.get("y") != null) {
            double x = args.get("x");
            double y = args.get("y");
            if (Objects.equals(diffVar, "x")) return 0.0;
            else if (Objects.equals(diffVar, "y")) return  6 * x;
        }
        return null;
    }

    @Override
    public Double getConversed(HashMap<String, Double> args) {
        if (args.get("x") != null && args.get("y") != null) {
            double x = args.get("x");
            double y = args.get("y");
            return Math.sqrt((57 - y) / (3 * y));
        }
        return null;
    }

    @Override
    public String getVarOfConversed() {
        return "y";
    }

    public String toString() {
        String s = "y + 3*x*y^2 - 57 = 0";
        return s;
    }
}
