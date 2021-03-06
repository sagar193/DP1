import java.util.HashMap;

/**
 * Created by Sagar on 10-6-2015.
 */
public class OutputNode implements Output {
    int maxInput;
    int value;
    Input connectedInputs;

    public OutputNode() {
        maxInput = 1;
        value = 2;
    }

    public void update(Input input) {
        if(connectedInputs == input){
            calculateValue();
        } else{
            System.out.println("Error, output krijgt een update van een node waaraan hij niet gekoppeld is");
        }
    }

    public void pair(Input newInput){
        if(connectedInputs != null){
            unpair(connectedInputs);
        }
        connectedInputs = newInput;
        connectedInputs.registerObserver(this);
        calculateValue();
    }

    public void unpair(Input oldInput){
        if (connectedInputs == oldInput){
            oldInput.unregisterObserver(this);
            connectedInputs = null;
            value = 2;
        } else {
            System.out.println("Error, output probeert een input los te koppelen waaraan het niet gekoppeld is");
        }
        calculateValue();
    }

    public void calculateValue() {
        if (connectedInputs.getValue() == 1){
            value = 1;
        } else if (connectedInputs.getValue() == 0){
            value = 0;
        } else {
            value = 0;
        }
    }

    public int getValue(){
        return value;
    }
}
