import java.util.ArrayList;

/**
 * Created by Sagar on 10-6-2015.
 */
public abstract class Gate {
    ArrayList<Output> observers;
    boolean value;

    public Gate() {
        observers = new ArrayList<>();
    }

    public void registerObserver(Output newObserver){
        observers.add(newObserver);
    }

    public void notifyObservers(){
        for(Output output : observers){
            output.update();
        }
    }

    public void unregisterObserver(Output removeObserver){
        observers.remove(removeObserver);
    }

    //following methodes abstract because they are gate dependent
    Input[] input;
    public abstract void update();

    public abstract void pair(Input newInput);

    public abstract void unpair(Input oldInput);
}
