/**
 * Created by Sagar on 12-6-2015.
 */
public class NOTNode extends Node{

    public NOTNode() {
        maxInputs = 1;
        value = 2;
        inputs = new Input[maxInputs];
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void update(Input input) {
        if(inputs[0] == input){
            calculateValue();
        } else {
            System.out.println("Error, NOTGate krijgt een update van een node waaraan hij niet gekoppeld is");
        }
    }

    @Override
    public void pair(Input newInput) {
        if (inputs[0] == null){
            inputs[0] = newInput;
            inputs[0].registerObserver(this);
        } else {
            System.out.println("Error, NOTGate is vol en probeert een input erbij te zetten");
        }
        calculateValue();
    }

    @Override
    public void unpair(Input oldInput) {
        if (inputs[0] == oldInput){
            inputs[0].unregisterObserver(this);
            inputs[0] = null;
            value = 2;
        } else {
            System.out.println("Error, NOTGate probeerd een input te unpairen die niet gepaired is");
        }
        calculateValue();
    }

    @Override
    public void calculateValue() {
        int newValue;
        if (inputs[0] == null){
            newValue = 2;
        } else if (inputs[0].getValue() == 1) {
            newValue = 0;
        }  else if (inputs[0].getValue() == 0){
            newValue = 1;
        } else {
            newValue = 2;
        }

        if (value != newValue){
            value = newValue;
            notifyObservers();
        }
    }
}
