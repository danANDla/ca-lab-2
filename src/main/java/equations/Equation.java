package equations;

import java.util.HashMap;

public interface Equation {
    Double getImage(HashMap<String, Double> args);
    Double getDerivative(HashMap<String, Double> args, String diffVar);
    Double getConversed(HashMap<String, Double> args);
    String getVarOfConversed();

    String toString();
}
