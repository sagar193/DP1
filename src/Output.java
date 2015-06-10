/**
 * Created by Sagar on 10-6-2015.
 */
public class Output {
    Input input;
    public void update(){}

    public void pair(Input newInput){
        if (input != null){
            unpair();
        }
        input = newInput;
        input.registerObserver(this);
    }
    public void unpair(){
        input.unregisterObserver(this);
        input = null;
    }
}
