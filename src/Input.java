import java.util.ArrayList;

/**
 * Created by Sagar on 10-6-2015.
 */
public class Input {
    ArrayList<Output> observers;
    boolean value;

    public Input() {
        observers = new ArrayList<>();
        value = false;
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



}
