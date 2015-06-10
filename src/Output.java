/**
 * Created by Sagar on 10-6-2015.
 */
public interface Output {

    public void update(Input input);

    public void pair(Input newInput);
    
    public void unpair(Input oldInput);

    public void calculateValue();
}
