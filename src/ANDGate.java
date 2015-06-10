/**
 * Created by Sagar on 10-6-2015.
 */
public class ANDGate extends Gate {
    public ANDGate() {
        input = new Input[2];
    }

    @Override
    public void update() {
        if(input[0] != null && input[1] != null){
            if(input[0].value ==true && input[1].value ==true){
                value = true;
            } else {
                value = false;
            }
        } else {
            value = false;
            //TODO: AND gate aparte kleur geven op jpanel
            System.out.println("AND gate nog niet alle input");
            return;
        }
        notifyObservers();
    }

    @Override
    public void pair(Input newInput) {
        if(input[0] == null){
            input[0] = newInput;
            input[0].registerObserver(this);
        }
        else if (input[1] == null){
            input[1] = newInput;
            input[1].registerObserver(this);
        }
        else {
            //TODO: print text on mouse position on jpanel for few seconds
            System.out.println("Gate is vol");
        }
    }

    @Override
    public void unpair(Input oldInput) {
        //TODO: check if == works
        if(input[0] == oldInput){
            //TODO: fix unregister bullshit because of no double inheritence
            input[0].unregisterObserver(this);
            input[0] = null;
        }
        else if (input[1] == oldInput){
            input[1].unregisterObserver(this);
            input[1] = null;
        }
        else {
            System.out.println("Unpairing went wrong, input not found at gate. Please check code");
        }
    }
}
