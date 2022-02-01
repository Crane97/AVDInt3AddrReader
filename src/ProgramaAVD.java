import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProgramaAVD {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Entrada: ");

        File file = new File("programa2.txt");
        Scanner scan = new Scanner(file);

        List<GuardaSalto> listaSaltos = new ArrayList<>();

        List<Node> entradaLista = new ArrayList<>();

        int id = 0;

        Node prevNode = null;

        while(scan.hasNextLine()) {

            String entrada = scan.nextLine();
            entrada = entrada.replace(" ","");

            String[] fields = new String[10];

            fields = fieldSplit(entrada);

            int inst = Integer.parseInt(fields[0]);

            Node res = new Node(inst, null, null, new ArrayList<>(), new ArrayList<>());
            if(fields[9] != null) {
                res.setVariable(Integer.parseInt(fields[9]));
            }

            if(!listaSaltos.isEmpty()){
                Node encontrado = new Node();
                int find = 0;

                for(GuardaSalto aux : listaSaltos){
                    if(res.getId() == aux.getDestinoSalto()){
                        res.addParentNode(aux.getOrigenSalto());
                        aux.getOrigenSalto().addChildrenNode(res);
                        encontrado = aux.getOrigenSalto();
                        find = aux.getDestinoSalto();
                    }
                }
                if(encontrado != null){
                    listaSaltos.remove(new GuardaSalto(encontrado, find));
                }
            }

            if(fields[1].equals("EREAD")){

                res.setType(new Entrada(Integer.parseInt(fields[9]),0));
                if(prevNode != null) {
                    res.addParentNode(prevNode);
                    prevNode.addChildrenNode(res);
                }
                prevNode = res;
                entradaLista.add(res);
            }

            if(fields[1].equals("ESUM")){
                if(fields[5].equals("p:")){
                    Node calc = new Node();
                    for(Node aux : entradaLista){
                        if(aux.getVariable()!= null && aux.getVariable() == Integer.parseInt(fields[6])){
                            calc = aux;
                        }
                    }
                    res.setType(new Suma(Integer.parseInt(fields[9]), Integer.parseInt(fields[3]), calc));
                }

                if(fields[2].equals("p:")){
                    Node calc = new Node();
                    for(Node aux : entradaLista){
                        if(aux.getVariable()!= null && aux.getVariable() == Integer.parseInt(fields[3])){
                            calc = aux;
                        }
                    }
                    if(fields[5].equals("p:")){
                        Node calc1 = new Node();
                        for(Node aux : entradaLista){
                            if(aux.getVariable()!= null && aux.getVariable() == Integer.parseInt(fields[6])){
                                calc1 = aux;
                            }
                        }

                        res.setType(new Suma(Integer.parseInt(fields[9]), calc, calc1));
                    }
                    else res.setType(new Suma(Integer.parseInt(fields[9]), calc, Integer.parseInt(fields[6])));


                }
                if(!fields[5].equals("p:") && !fields[2].equals("p:")) {
                    res.setType(new Suma(Integer.parseInt(fields[9]), Integer.parseInt(fields[3]), Integer.parseInt(fields[6])));
                }

                if(prevNode != null) {
                    res.addParentNode(prevNode);
                    prevNode.addChildrenNode(res);
                }

                prevNode = res;

                entradaLista.add(res);
            }
            if(fields[1].equals("EDIF")){
                if(fields[5].equals("p:")){
                    Node calc = new Node();
                    for(Node aux : entradaLista){
                        if(aux.getVariable()!= null && aux.getVariable() == Integer.parseInt(fields[6])){
                            calc = aux;
                        }
                    }

                    res.setType(new Suma(Integer.parseInt(fields[9]), Integer.parseInt(fields[3]), calc));
                }

                if(fields[2].equals("p:")){
                    Node calc = new Node();
                    for(Node aux : entradaLista){
                        if(aux.getVariable()!= null && aux.getVariable() == Integer.parseInt(fields[3])){
                            calc = aux;
                        }
                    }
                    if(fields[5].equals("p:")){
                        Node calc1 = new Node();
                        for(Node aux : entradaLista){
                            if(aux.getVariable()!= null && aux.getVariable() == Integer.parseInt(fields[6])){
                                calc1 = aux;
                            }
                        }

                        res.setType(new Suma(Integer.parseInt(fields[9]), calc, calc1));
                    }
                    else res.setType(new Suma(Integer.parseInt(fields[9]), calc, Integer.parseInt(fields[6])));


                }
                if(!fields[5].equals("p:") && !fields[2].equals("p:")) {
                    res.setType(new Suma(Integer.parseInt(fields[9]), Integer.parseInt(fields[3]), Integer.parseInt(fields[6])));
                }

                if(prevNode != null) {
                    res.addParentNode(prevNode);
                    prevNode.addChildrenNode(res);
                }

                prevNode = res;

                entradaLista.add(res);
            }
            if(fields[1].equals("ESIG")){

                if(fields[2].equals("p:")) {

                    Node calc = new Node();

                    for(Node aux : entradaLista){
                        if(aux.getVariable()!= null && aux.getVariable() == Integer.parseInt(fields[3])){
                            calc = aux;
                        }
                    }

                    res.setType(new Asignacion(Integer.parseInt(fields[9]), calc.getVariable()*(-1)));
                }
                else {
                    res.setType(new Asignacion(Integer.parseInt(fields[9]), Integer.parseInt(fields[3])*(-1)));
                }
                if(prevNode != null) {
                    res.addParentNode(prevNode);
                    prevNode.addChildrenNode(res);
                }

                prevNode = res;

                entradaLista.add(res);
            }
            if(fields[1].equals("EASIG")){

                if(fields[2].equals("p:")) {

                    Node calc = new Node();

                    for(Node aux : entradaLista){
                        if(aux.getVariable()!= null && aux.getVariable() == Integer.parseInt(fields[3])){
                            calc = aux;
                        }
                    }

                    res.setType(new Asignacion(Integer.parseInt(fields[9]), calc));
                }
                else {
                    res.setType(new Asignacion(Integer.parseInt(fields[9]), Integer.parseInt(fields[3])));
                }
                if(prevNode != null) {
                    res.addParentNode(prevNode);
                    prevNode.addChildrenNode(res);
                }

                prevNode = res;

                entradaLista.add(res);
            }
            if(fields[1].equals("EWRITE")){
                res.setType(new Escribir(Integer.parseInt(fields[9]), 0));

                if(prevNode != null) {
                    res.addParentNode(prevNode);
                    prevNode.addChildrenNode(res);
                }

                prevNode = res;

                entradaLista.add(res);
            }
            if(fields[1].equals("GOTOS")){

                res.setType(new Salto(null, null, Integer.parseInt(fields[9])));

                res.addParentNode(prevNode);
                prevNode.addChildrenNode(res);

                listaSaltos.add(new GuardaSalto(res, Integer.parseInt(fields[9])));

                prevNode = null;

                entradaLista.add(res);


            }
            if(fields[1].equals("EIGUAL")){

                Object calc = new Node();
                Object calc2 = new Node();

                if(fields[2].equals("p:")) {

                    for(Node aux : entradaLista){
                        if(aux.getVariable()!= null && aux.getVariable() == Integer.parseInt(fields[3])){
                            calc = aux;
                        }
                    }
                }
                if(fields[5].equals("p:")){

                    for(Node aux : entradaLista){
                        if(aux.getVariable()!= null && aux.getVariable() == Integer.parseInt(fields[6])){
                            calc2 = aux;
                        }
                    }
                }
                if(fields[2].equals("i:")){
                    calc = Integer.parseInt(fields[3]);
                }
                if(fields[5].equals("i:")){
                    calc = Integer.parseInt(fields[6]);
                }

                res.setType(new Salto(calc, calc2, Integer.parseInt(fields[9])));

                if(prevNode !=null) {
                    res.addParentNode(prevNode);
                    prevNode.addChildrenNode(res);
                }

                listaSaltos.add(new GuardaSalto(res, Integer.parseInt(fields[9])));

                prevNode = res;

                entradaLista.add(res);

            }
            if(fields[1].equals("EDIST")){

                Object calc = new Node();
                Object calc2 = new Node();

                if(fields[2].equals("p:")) {

                    for(Node aux : entradaLista){
                        if(aux.getVariable()!= null && aux.getVariable() == Integer.parseInt(fields[3])){
                            calc = aux;
                        }
                    }
                }
                if(fields[5].equals("p:")){

                    for(Node aux : entradaLista){
                        if(aux.getVariable()!= null && aux.getVariable() == Integer.parseInt(fields[6])){
                            calc2 = aux;
                        }
                    }
                }
                if(fields[2].equals("i:")){
                    calc = Integer.parseInt(fields[3]);
                }
                if(fields[5].equals("i:")){
                    calc = Integer.parseInt(fields[6]);
                }

                res.setType(new Salto(calc, calc2, Integer.parseInt(fields[9])));

                if(prevNode != null) {
                    res.addParentNode(prevNode);
                    prevNode.addChildrenNode(res);
                }

                listaSaltos.add(new GuardaSalto(res, Integer.parseInt(fields[9])));

                prevNode = res;

                entradaLista.add(res);
            }
            if(fields[1].equals("EMEN")){ //instruccion de salto si arg1 < arg2

                Object calc = new Node();
                Object calc2 = new Node();

                if(fields[2].equals("p:")) {

                    for(Node aux : entradaLista){
                        if(aux.getVariable()!= null && aux.getVariable() == Integer.parseInt(fields[3])){
                            calc = aux;
                        }
                    }
                }
                if(fields[5].equals("p:")){

                    for(Node aux : entradaLista){
                        if(aux.getVariable()!= null && aux.getVariable() == Integer.parseInt(fields[6])){
                            calc2 = aux;
                        }
                    }
                }
                if(fields[2].equals("i:")){
                    calc = Integer.parseInt(fields[3]);
                }
                if(fields[5].equals("i:")){
                    calc = Integer.parseInt(fields[6]);
                }

                res.setType(new Salto(calc, calc2, Integer.parseInt(fields[9])));

                if(prevNode != null) {
                    res.addParentNode(prevNode);
                    prevNode.addChildrenNode(res);
                }

                listaSaltos.add(new GuardaSalto(res, Integer.parseInt(fields[9])));

                prevNode = res;

                entradaLista.add(res);
            }
            if(fields[1].equals("EMAY")){
            }
            if(fields[1].equals("FIN")){
                res.setType(new Final());
                if(prevNode != null) {
                    res.addParentNode(prevNode);
                    prevNode.addChildrenNode(res);
                }
                prevNode = res;
                entradaLista.add(res);
            }
        }

        scan.close();

        Scanner scan1 = new Scanner(System.in);

        String entry = "";

        while(!entry.equals("out")) {
            System.out.println("Para seleccionar una de las funciones a sacar por pantalla, debemos escribir:");
            System.out.println("- kill(x) - Nos sacará el valor kill en la instrucción x");
            System.out.println("- gen(x) - Nos sacará el valor gen en la instrucción x");
            System.out.println("- labels() - Nos sacará todas las instrucciones del programa");
            System.out.println("- init() - Nos sacará las instrucciones de entrada");
            System.out.println("- final() - Nos sacará las instrucciones de salida");
            System.out.println("- flow() - Nos sacará el flow del programa");
            System.out.println("- flowR() - Nos sacará el flow revertido del programa");
            System.out.println("- LVentry(x) - Nos sacará el LVentry de la instrucción x");
            System.out.println("- LVexit(x) - Nos sacará el LVexit de la instrucción x");

            entry = scan1.next();

            seleccionarFuncionAuxiliar(entry, entradaLista);
        }
    }

    public static String kill(int entrada, List<Node> entradaLista){
        Node nodeRes = new Node();
        String res = "[";

        for(Node aux : entradaLista){
            if(aux.getId() == entrada){
                nodeRes = aux;
            }
        }

        if(nodeRes.getType() instanceof Asignacion){
            res += ""+((Asignacion) nodeRes.getType()).getId();
        }
        if(nodeRes.getType() instanceof Condicion){
            res += "";
        }
        if(nodeRes.getType() instanceof Entrada){
            res += ""+((Entrada) nodeRes.getType()).getId();
        }
        if(nodeRes.getType() instanceof Escribir){
            res += "";
        }
        if(nodeRes.getType() instanceof Salto){
            res += "";
        }
        if(nodeRes.getType() instanceof Suma){
            res += ""+((Suma) nodeRes.getType()).getId();;
        }

        return res+="]";
    }

    public static String gen(int entrada, List<Node> entradaLista){
        String res = "[";
        Node nodeRes = new Node();

        for(Node aux : entradaLista){
            if(aux.getId() == entrada){
                nodeRes = aux;
            }
        }

        if(nodeRes.getType() instanceof Asignacion){
            if(((Asignacion) nodeRes.getType()).getAsignacion() instanceof Integer) {
                res += "";
            }
            else{
                res += ""+ (((Node) ((Asignacion) nodeRes.getType()).getAsignacion()).getVariable());
            }

        }
        if(nodeRes.getType() instanceof Condicion){
            res += "";
        }
        if(nodeRes.getType() instanceof Entrada){
            res += ""+((Entrada) nodeRes.getType()).getId();
        }
        if(nodeRes.getType() instanceof Escribir){
            res += "";
        }
        if(nodeRes.getType() instanceof Salto){
            if(((Salto) nodeRes.getType()).getArg1() instanceof Integer) {
                res += "";
            }
            if (((Salto) nodeRes.getType()).getArg2() instanceof Integer){
                res += "";
            }
            if(((Salto) nodeRes.getType()).getArg1() instanceof Node){
                res += " "+ (((Node) ((Salto) nodeRes.getType()).getArg1()).getVariable());
            }
            if(((Salto) nodeRes.getType()).getArg2() instanceof Node){
                res += " "+ (((Node) ((Salto) nodeRes.getType()).getArg2()).getVariable());
            }
        }
        if(nodeRes.getType() instanceof Suma){
            if(((Suma) nodeRes.getType()).getValor1() instanceof Integer) {
                res += "";
            }
            if (((Suma) nodeRes.getType()).getValor2() instanceof Integer){
                res += "";
            }
            if(((Suma) nodeRes.getType()).getValor1() instanceof Node){
                res += " "+ (((Node) ((Suma) nodeRes.getType()).getValor1()).getVariable());
            }
            if(((Suma) nodeRes.getType()).getValor2() instanceof Node){
                res += " "+ (((Node) ((Suma) nodeRes.getType()).getValor2()).getVariable());
            }
        }
        return res+="]";
    }

    public static String init(List<Node> entradaLista){
        return entradaLista.get(0).getId().toString();
    }

    public static String finalNodes(List<Node> entradaLista){
        String res = "[";

        Node nodoFinal = new Node();

        for(Node aux : entradaLista){
            if(aux.getType() instanceof Final){
                nodoFinal = aux;
            }
        }

        for(Node aux : nodoFinal.getParentNode()){
            res += " " + aux.getId();
        }


        return res +="]";
    }

    public static String labels(List<Node> entradaLista){
        String res ="[ ";

        for(Node aux : entradaLista){
            res+=""+ aux.getId()+" ";
        }

        return res+="]";
    }

    public static String flow(List<Node> entradaLista){
        String res = "[";

        for(Node aux : entradaLista){
            for(Node child : aux.getChildrenNode()){
                res+= "("+ aux.getId()+ ", "+ child.getId() +") ";
            }
        }

        return res +="]";
    }

    public static String flowR(List<Node> entradaLista){
        String res = "[";

        for(Node aux : entradaLista){
            for(Node parent : aux.getParentNode()){
                res+= "("+ aux.getId()+ ", "+ parent.getId() +") ";
            }
        }

        return res +="]";
    }

    public static String lvexit(int entrada, List<Node> entradaLista, String res){

        Node nodeRes = new Node();

        for(Node aux : entradaLista){
            if(aux.getId() == entrada){
                nodeRes = aux;
            }
        }
        if(nodeRes.getChildrenNode()!=null) {
            for (Node children : nodeRes.getChildrenNode()) {
                res = "";
                if(children.getId()!=null) {
                    res += lventry(children.getId(), entradaLista, res); //EXIT
                }
            }
        }

        return res;
    }

    public static String lventry(int entrada, List<Node> entradaLista, String res){

        Node nodeRes = new Node();

        for(Node aux : entradaLista){
            if(aux.getId() == entrada){
                nodeRes = aux;
            }
        }

        if(nodeRes.getId()!=null) {
            res += lvexit(nodeRes.getId(), entradaLista, res); //ENTRY
        }

        String killEntrada = kill(entrada,entradaLista);
        killEntrada = killEntrada.replace("[","");
        killEntrada = killEntrada.replace("]","");

        String genEntrada = gen(entrada, entradaLista);
        genEntrada = genEntrada.replace("[","");
        genEntrada = genEntrada.replace("]","");
        genEntrada = genEntrada.replace(" ","");

        res = res.replace(killEntrada.substring(0),"");


        for(int i = 0; i < genEntrada.length(); i++){
            if(!res.contains(genEntrada.substring(i,i+1))){
                res += genEntrada.substring(i,i+1);
            }
        }

        return res;
     }

    public static String[] fieldSplit(String entrada){
        String[] campos = new String[10];
        int campo = 0;
        int ant = 0;

        for(int i = 0; i < entrada.length(); i++){
            if(entrada.charAt(i) == 9){
                campos[campo] = entrada.substring(ant, i);
                if(entrada.charAt(i+1) != 9){i++;}
                ant = i;
                campo++;
            }

            if(i == entrada.length()-1){
                campos[campo] = entrada.substring(ant, i+1);
            }
        }

        return campos;
    }

    public static void seleccionarFuncionAuxiliar(String entry, List<Node> entradaLista) {

        String res = "";
        boolean check = false;

        try {
            if (entry.substring(0, 5).equals("flow(")) {
                System.out.println(flow(entradaLista));
                check = true;
            }
            if (entry.substring(0, 5).equals("flowR")) {
                System.out.println(flowR(entradaLista));
                check = true;
            }
            if (entry.substring(0, 4).equals("kill")) {
                String aux = "";
                for (int i = 4; i < entry.length(); i++) {
                    if (entry.charAt(i) <= 57 && 48 <= entry.charAt(i)) {
                        aux += "" + entry.substring(i, i + 1);
                    }
                }

                int llamada = Integer.parseInt(aux);

                System.out.println(kill(llamada, entradaLista));
                check = true;
            }
            if (entry.substring(0, 3).equals("gen")) {
                String aux = "";
                for (int i = 3; i < entry.length(); i++) {
                    if (entry.charAt(i) <= 57 && 48 <= entry.charAt(i)) {
                        aux += "" + entry.substring(i, i + 1);
                    }
                }

                int llamada = Integer.parseInt(aux);

                System.out.println(gen(llamada, entradaLista));
                check = true;
            }
            if (entry.substring(0, 5).equals("label")) {
                System.out.println(labels(entradaLista));
                check = true;
            }
            if (entry.substring(0, 4).equals("init")) {
                System.out.println(init(entradaLista));
                check = true;
            }
            if (entry.substring(0, 4).equals("fina")) {
                System.out.println(finalNodes(entradaLista));
                check = true;
            }
            if(entry.substring(0, 7).equals("LVexit(")) {
                String aux = "";
                for (int i = 6; i < entry.length(); i++) {
                    if (entry.charAt(i) <= 57 && 48 <= entry.charAt(i)) {
                        aux += "" + entry.substring(i, i + 1);
                    }
                }

                int llamada = Integer.parseInt(aux);

                System.out.println("[" + lvexit(llamada, entradaLista, "") + "]");
                check = true;
            }
            if(entry.substring(0, 8).equals("LVentry(")) {
                String aux = "";
                for (int i = 7; i < entry.length(); i++) {
                    if (entry.charAt(i) <= 57 && 48 <= entry.charAt(i)) {
                        aux += "" + entry.substring(i, i + 1);
                    }
                }

                int llamada = Integer.parseInt(aux);

                System.out.println("[" + lventry(llamada, entradaLista, "") + "]");
                check = true;
            }
            if(!check){
                System.err.println("Value not detected");
            }
        } catch (Exception e) {
            System.err.println("Value not detected");
        }
    }

}
