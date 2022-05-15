package filesystem;
import java.util.ArrayList;
import java.util.List;

public class FileSystem implements Node, IterableCollection {
    private String name;
    private String type;
    private String directory;
    private int component_count;
    private List<Node> nodeList;
    private Node parent;


    public FileSystem(String name) {
        this.name = name;
        this.type = "fs";
        this.directory = name;
        this.component_count = 0;
        this.nodeList = new ArrayList<Node>();
        parent = null;
    }



    @Override
    public void details() {

    }

    @Override
    public void list() {
        listing(0);
    }

    @Override
    public void listing(int spacing) {
        for(int idx = 0; idx<=spacing; idx++){
            System.out.print(" ");
        }
        System.out.println("------" + this.name);
        for(Node node : nodeList){
            node.listing(spacing + 4);
        }
    }

    @Override
    public Node getParent() {
        return null;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public String getDirectory() {
        return this.directory;
    }

    @Override
    public int getComponentCount() {
        return this.component_count;
    }

    @Override
    public void addNode(Node node) {

        if("fs".equalsIgnoreCase(node.getType())){
            System.out.println("Vous ne pouvez pas ajouter un système de fichier dans un système de fichier");
        }

        else{
            nodeList.add(node);
            System.out.println(node.getName() + " " + node.getType() + " " + "Crée en " + node.getParent().getDirectory());
            component_count++;
        }
    }

    @Override
    public Node searchNode(String name) {
        for(Node node : nodeList){
            if(name.equalsIgnoreCase(node.getName())){
                System.out.println( node.getName() + " " + node.getType() + "opened.");
                return node;
            }
        }
        System.out.println("Pas de dossier dans ce dossier.");
        return this;
    }

    @Override
    public Iterator createIterator() {
        return new NodeIterator(nodeList);
    }
}
