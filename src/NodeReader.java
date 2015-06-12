import java.io.*;

/**
 * Created by root on 11-6-15.
 */
public class NodeReader {

    //private File _file;
    private File _file = new File("src/circuit1.txt");
    public NodeReader(){

    }


    public void ReadFile(){
        boolean initNodes = true;

        try(BufferedReader br = new BufferedReader(new FileReader(this._file))) {
            for(String line; (line = br.readLine()) != null; ) {
                if(!line.equals("")) {
                    Character fChar = line.charAt(0);
                    if(!fChar.equals('#')) {
                        String compName = line.substring(0,line.indexOf(":"));
                        String compValue = line.substring(line.indexOf(":")+1,line.indexOf(";"));
                        compValue = compValue.replaceAll("\\s+","");

                        if(initNodes) {
                            // Input
                            //System.out.println("if");
                            //System.out.println(compValue);
                            //System.out.println(compName);

                            if(compValue.equals("INPUT_HIGH")){
                                InputNode inputNode= new InputNode();
                                inputNode.turnOn();
                                Application.getInstance().getNodeCollection().put(compName, inputNode);
                            } else if(compValue.equals("INPUT_LOW")){
                                InputNode inputNode= new InputNode();
                                inputNode.turnOff();
                                Application.getInstance().getNodeCollection().put(compName, inputNode);
                            } else if(compValue.equals("PROBE")){
                                OutputNode outputNode = new OutputNode();
                                Application.getInstance().getNodeCollection().put(compName, outputNode);
                            } else {
                                Application.getInstance().getNodeCollection().put(compName, NodeFactory.getInstance().createNode(compValue));
                            }
                        } else {
                            if(compValue.contains(",")) {
                                String[] split = compValue.split(",");
                                for (int i = 0; i < split.length; i++) {
                                    //System.out.println("else if");
                                    //System.out.println(split[i]);
                                    //System.out.println(compName);
                                    Application.getInstance().getNodeCollection().pair(compName, split[i]);
                                    //LinkCircuit(compName, split[i]);
                                }
                            } else {
                                //System.out.println("else else");
                                //System.out.println(compValue);
                                //System.out.println(compName);
                                Application.getInstance().getNodeCollection().pair(compName, compValue);
                                //LinkCircuit(compName, compValue);
                            }
                        }
                    }
                } else {
                    initNodes = false;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
