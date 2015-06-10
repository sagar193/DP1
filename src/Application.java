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
        System.out.println("Value A bij aanmaken "+A.getValue());

        A.turnOn();
        System.out.println("Value A bij aanzetten "+ A.getValue());

        A.turnOff();
        System.out.println("Value A bij uitzetten "+ A.getValue());
    }
}
