package methods;

import java.util.ArrayList;
import java.util.HashMap;

public class MethodResult {
    HashMap<String, Double> values;

    public MethodResult(HashMap<String, Double> values, Status status) {
        this.values = values;
        this.status = status;
    }

    Status status;

    public HashMap<String, Double> getValues() {
        return values;
    }

    public Status getStatus() {
        return status;
    }
}
