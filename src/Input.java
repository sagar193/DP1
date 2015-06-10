/**
 * Created by Sagar on 10-6-2015.
 */
public interface Input {

    void registerObserver(Output newOutput);
    void notifyObservers();
    void unregisterObserver(Output oldOutput);
    int getValue();
}
