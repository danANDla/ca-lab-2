package equations;

import java.util.HashMap;
import java.util.Objects;

public class eq1 implements Equation {
    @Override
    public Double getImage(HashMap<String, Double> args) {
        if (args.get("x") != null) {
            double x = args.get("x");
            return Math.cos(x) - x * Math.exp(x);
        }
        return null;
    }

    @Override
    public Double get1Derivative(HashMap<String, Double> args, String diffVar) {
        if (args.get("x") != null) {
            double x = args.get("x");
            if (Objects.equals(diffVar, "x")) return -x*Math.exp(x) - Math.exp(x) - Math.sin(x);
        }
        return null;
    }

    @Override
    public Double get2Derivative(HashMap<String, Double> args, String diffVar) {
        if (args.get("x") != null) {
            double x = args.get("x");
            if (Objects.equals(diffVar, "x")) return -x*Math.exp(x) - 2*Math.exp(x) - Math.cos(x);
        }
        return null;
    }

    @Override
    public Double getConversed(HashMap<String, Double> args) {
        if (args.get("x") != null) {
            double x = args.get("x");
            return Math.cos(x) / Math.exp(x);
        }
        return null;
    }

    @Override
    public String getVarOfConversed() {
        return "x";
    }

    public String toString() {
        String s = "f(x) = cos(x) - x*exp(x)";
        return s;
    }
}
