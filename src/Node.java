import java.util.ArrayList;

/**
 * Created by Sagar on 10-6-2015.
 */
public abstract class Node implements Output, Input{
    ArrayList<Output> observers;

    int maxInputs;
    int currentNumInputs;
    Input[] inputs;
    int value;

    public Node() {
        observers = new ArrayList<>();
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

}
