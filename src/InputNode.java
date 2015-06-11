import java.util.ArrayList;

/**
 * Created by Sagar on 10-6-2015.
 */
public class InputNode implements Input, NodeInterface {
    ArrayList<Output> observers;
    //@value 0 is off, 1 is on, 2 is not defined
    int value;


    public InputNode() {
        observers = new ArrayList<>();
        value = 2;
    }

    public void registerObserver(Output newObserver){
        observers.add(newObserver);
    }

    public void notifyObservers(){
        for(Output output : observers){
            output.update(this);
        }
    }

    public void unregisterObserver(Output removeObserver){
        observers.remove(removeObserver);
    }

    public void turnOn(){
        value = 1;
        notifyObservers();
    }

    public void turnOff(){
        value = 0;
        notifyObservers();
    }

    @Override
    public int getValue() {
        return value;
    }


    @Override
    public void pair(Input newInput) {
        System.out.println("Error, kan niet gekoppeld worden aan een input");
    }

    @Override
    public void unpair(Input oldInput) {
        System.out.println("Error, kan niet gekoppeld worden aan een input");
    }
}
