/**
 * Created by Sagar on 28-5-2015.
 */
public class main {
    public static void main(String[] args) {

        Application.getInstance();
        Application.getInstance().ReadFile();
        Application.getInstance().getNodeCollection().printOutputs();
        System.out.println("Hello, World!");
    }
}
