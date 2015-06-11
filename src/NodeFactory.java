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

    public Node createNode(String nodeType){
        if (nodeType == null){
            return null;
        } else if (nodeType.equals("AND")){
            return new ANDNode();
        } else if (nodeType.equals("NAND")){
            return new NANDNode();
        } else if (nodeType.equals("NOR")){
            return new NORNode();
        } else if (nodeType.equals("OR")){
            return new ORNode();
        } else if (nodeType.equals("XORNode")){
            return new XORNode();
        } else {
            return null;
        }
    }
}
