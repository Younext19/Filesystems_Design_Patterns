package filesystem;

import java.util.ArrayList;
import java.util.List;

public class Dossier implements Node {
    private String name;
    private String type;
    private String directory;
    private int component_count;
    private Node parent;
    private List<Node> nodeList;

    public Dossier(String name, String type, String currentDirectory, Node currentNode) {
        this.name = name;
        this.type = type;
        this.directory = currentDirectory + "/" + name;
        this.parent = currentNode;
        this.component_count = 0;
        this.nodeList = new ArrayList<Node>();
    }

    public Dossier(String name, String type, String currentDirectory) {
        this.name = name;
        this.type = type;
        this.directory = currentDirectory + "/" + name;
        this.parent = null;
        this.component_count = 0;
        this.nodeList = new ArrayList<Node>();
    }

    @Override
    public Node getParent() {
        return this.parent;
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
    public void details() {
        System.out.println("\nDetaille sur " + this.name + ":\n");

        System.out.println("Nom: " + this.name +
                "\nType: " + this.type +
                "\nDossier : " + this.directory);
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
    public Node searchNode(String name) {
        for(Node node : nodeList){
            if(name.equalsIgnoreCase(node.getName())){
                System.out.println( node.getName() + " " + node.getType() + "opened.");
                return node;
            }
        }
        System.out.println("No such Folder found in this directory.");
        return this;
    }


    @Override
    public void addNode(Node node){
        if("fs".equalsIgnoreCase(node.getType())){
            System.out.println("Vous ne pouvez pas ajouter un système de fichier dans un dossier.");
        }

        else{
            nodeList.add(node);
            System.out.println(node.getName() + " " + node.getType() + " " + "created in " + node.getParent().getDirectory());
            component_count++;
        }
    }

}
