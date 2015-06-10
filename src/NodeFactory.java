/**
 * Created by Sagar on 10-6-2015.
 */
public class NodeFactory {
    private static NodeFactory ourInstance = new NodeFactory();

    public static NodeFactory getInstance() {
        return ourInstance;
    }

    private NodeFactory() {
    }
}
