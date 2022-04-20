package equations;

import java.util.HashMap;
import java.util.Objects;

public class eq3 implements Equation {
    @Override
    public Double getImage(HashMap<String, Double> args) {
        if (args.get("x") != null) {
            double x = args.get("x");
            return x * x + 2 * x + 4;
        }
        return null;
    }

    @Override
    public Double getDerivative(HashMap<String, Double> args, String diffVar) {
        if (args.get("x") != null) {
            double x = args.get("x");
            if (Objects.equals(diffVar, "x")) return 2 * x + 2;
        }
        return null;
    }

    @Override
    public Double getConversed(HashMap<String, Double> args) {
        if (args.get("x") != null) {
            double x = args.get("x");
            return (-x * x - 4) / 2;
        }
        return null;
    }

    @Override
    public String getVarOfConversed() {
        return "x";
    }

    public String toString() {
        String s = "f(x) = x^2 + 2*x + 4";
        return s;
    }
}
