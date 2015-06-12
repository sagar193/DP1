import java.util.HashMap;

/**
 * Created by Sagar on 12-6-2015.
 */
public class NodeCollection {
    HashMap<String, InputNode> inputNodes;
    HashMap<String, Node> nodes;
    HashMap<String, OutputNode> outputNodes;

    public NodeCollection() {
        inputNodes = new HashMap<>();
        nodes = new HashMap<>();
        outputNodes = new HashMap<>();
    }

    public void put(String string, OutputNode newNode){
        outputNodes.put(string, newNode);
    }

    public void put(String string, InputNode newNode){
        inputNodes.put(string, newNode);
    }

    public void put(String string, Node newNode){
        nodes.put(string, newNode);
    }

    public void pair(String parent, String child){
        InputNode inputParent = inputNodes.get(parent);
        Node parentNode = nodes.get(parent);
        OutputNode outputParent = outputNodes.get(parent);
        InputNode inputChild = inputNodes.get(child);
        Node childNode = nodes.get(child);
        OutputNode outputChild = outputNodes.get(child);

        if(inputChild != null){
            System.out.println("Error, Input als child gegeven, dit kan niet");
            return;
        }
        else if(outputParent != null){
            System.out.println("Error, Output als parent gegeven, dit kan niet");
        }

        else if(inputParent != null){
            if(childNode != null){
                childNode.pair(inputParent);
            }
            else if(outputChild != null){
                outputChild.pair(inputParent);
            }
        }

        else if(parentNode != null){
            if(childNode != null){
                childNode.pair(parentNode);
            }
            else if(outputChild != null){
                outputChild.pair(parentNode);
            }
        }
        else{
            System.out.println("Something goes wrong pairing 2 nodes");
            System.out.println("Parent name: "+ parent + ", Child name: "+ child);
        }


    }
}
