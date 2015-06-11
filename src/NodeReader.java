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
                            System.out.println("if");
                            System.out.println(compValue);
                            System.out.println(compName);

                            //IComponent comp = Factory.create(compValue);
                            //comp.setCircuit(this);
                            //_components.put(compName, comp);
                        } else {
                            if(compValue.contains(",")) {
                                String[] split = compValue.split(",");
                                for (int i = 0; i < split.length; i++) {
                                    System.out.println("else if");
                                    System.out.println(compValue);
                                    System.out.println(compName);
                                    //LinkCircuit(compName, split[i]);
                                }
                            } else {
                                System.out.println("else else");
                                System.out.println(compValue);
                                System.out.println(compName);
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
