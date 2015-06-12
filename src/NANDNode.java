/**
 * Created by Sagar on 11-6-2015.
 */
public class NANDNode extends Node {
    public NANDNode() {
        maxInputs = 2;
        value = 2;
        inputs = new Input[2];
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void update(Input input) {
        if(inputs[0] == input || inputs[1] == input){
            calculateValue();
        } else {
            System.out.println("Error, ORGate krijgt een update van een node waaraan hij niet gekoppeld is");
        }
    }

    @Override
    public void pair(Input newInput) {
        if (inputs[0] == null){
            inputs[0] = newInput;
            inputs[0].registerObserver(this);
        } else if (inputs[1] == null){
            inputs[1]= newInput;
            inputs[1].registerObserver(this);
        } else {
            System.out.println("Error, ORGate is vol en probeert een input erbij te zetten");
        }
        calculateValue();
    }

    @Override
    public void unpair(Input oldInput) {
        if (inputs[0] == oldInput){
            inputs[0].unregisterObserver(this);
            inputs[0] = null;
        } else if (inputs[1] == oldInput){
            inputs[1].unregisterObserver(this);
            inputs[1] = null;
        } else {
            System.out.println("Error, ORGate probeerd een input te unpairen die niet gepaired is");
        }
        calculateValue();
    }

    @Override
    public void calculateValue() {
        int newValue;
        if (inputs[0] == null || inputs[1] == null){
            newValue = 2;
        } else if (inputs[0].getValue() != 1 && inputs [1].getValue() != 1) {
            newValue = 1;
        } else {
            newValue = 0;
        }

        if (value != newValue){
            value = newValue;
            notifyObservers();
        }
    }
}
