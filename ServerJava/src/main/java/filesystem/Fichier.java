package filesystem;
public class Fichier implements Node {
    private String name;
    private String type;
    private String directory;
    private Node parent;

    public Fichier(String name, String type, String currentDirectory, Node currentNode) {
        this.name = name;
        this.type = type;
        this.directory = currentDirectory + "/" + name;
        this.parent = currentNode;
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
        return 0;
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
    }

    @Override
    public Node searchNode(String name) {
        return null;
    }

    @Override
    public void addNode(Node node) {
        //do nothing
        System.out.println("Vous ne pouvez pas ajouter");
    }

    @Override
    public void details() {
        System.out.println("\n\nDétaille de " + this.name + ":\n\n");

        System.out.println("Nom: " + this.name +
                "\nType: " + this.type +
                "\nDossier: " + this.directory + "\n");
    }

}
