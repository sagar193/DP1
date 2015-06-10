/**
 * Created by Sagar on 11-6-2015.
 */
public class Application {
    private static Application ourInstance = new Application();

    public static Application getInstance() {
        return ourInstance;
    }

    private Application() {
        System.out.println("Application gemaakt");

        InputNode A = new InputNode();
        OutputNode output = new OutputNode();
        output.pair(A);
        System.out.println("Value A bij aanmaken "+A.getValue());
        System.out.println("Value output bij aanmaken "+output.getValue());

        A.turnOn();
        System.out.println("Value A bij aanzetten "+ A.getValue());
        System.out.println("Value output bij aanzetten "+ output.getValue());

        A.turnOff();
        System.out.println("Value A bij uitzetten "+ A.getValue());
        System.out.println("Value output bij uitzetten "+ output.getValue());



    }
}
