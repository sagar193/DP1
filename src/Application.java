import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Sagar on 11-6-2015.
 */
public class Application {
    private static Application ourInstance = new Application();

    public static Application getInstance() {
        return ourInstance;
    }

    public NodeCollection getNodeCollection() {
        return nodeCollection;
    }

    private NodeCollection nodeCollection;

    private Application() {
        System.out.println("Application gemaakt");
        nodeCollection = new NodeCollection();

        NodeReader reader = new NodeReader();
        reader.ReadFile();
        //nodes.add(NodeFactory.getInstance().createNode("AND"));
    }

    private void andTest(){
        InputNode A = new InputNode();
        InputNode B = new InputNode();
        ANDNode and = new ANDNode();
        and.pair(A);
        and.pair(B);
        OutputNode output = new OutputNode();
        output.pair(and);

        System.out.println("Value A bij aanmaken "+A.getValue());
        System.out.println("Value B bij aanmaken " + B.getValue());
        System.out.println("Value AND bij aanmaken " + and.getValue());
        System.out.println("Value output bij aanmaken "+output.getValue() +"\n");

        A.turnOn();
        System.out.println("Value A bij aanzetten A "+ A.getValue());
        System.out.println("Value B bij aanzetten A " + B.getValue());
        System.out.println("Value and bij aanzetten A " + and.getValue());
        System.out.println("Value output bij aanzetten A "+ output.getValue()+"\n");

        B.turnOn();
        System.out.println("Value A bij aanzetten B "+ A.getValue());
        System.out.println("Value B bij aanzetten B "+ B.getValue());
        System.out.println("Value and bij aanzetten B "+ and.getValue());
        System.out.println("Value output bij aanzetten B "+ output.getValue()+"\n");

        and.unpair(B);
        System.out.println("Value A bij untkoppelen B "+ A.getValue());
        System.out.println("Value B bij untkoppelen B "+ B.getValue());
        System.out.println("Value and bij untkoppelen B "+ and.getValue());
        System.out.println("Value output bij untkoppelen B "+ output.getValue()+"\n");

        A.turnOff();
        System.out.println("Value A bij uitzetten A "+ A.getValue());
        System.out.println("Value B bij uitzetten A "+ B.getValue());
        System.out.println("Value and bij uitzetten A "+ and.getValue());
        System.out.println("Value output bij uitzetten A "+ output.getValue()+"\n");

        B.turnOff();
        System.out.println("Value A bij uitzetten B "+ A.getValue());
        System.out.println("Value B bij uitzetten B "+ B.getValue());
        System.out.println("Value and bij uitzetten B "+ and.getValue());
        System.out.println("Value output bij uitzetten B "+ output.getValue());
    }
}
