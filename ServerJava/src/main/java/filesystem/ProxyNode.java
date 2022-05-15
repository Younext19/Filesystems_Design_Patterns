package filesystem;

public class ProxyNode implements Node {
    private Node realNode;
    private String symbolicDirectory;
    private Node parent;

    public ProxyNode(Node node, String symbolicdirectory, Node currentNode) {
        this.realNode = node;
        this.symbolicDirectory = symbolicdirectory;
        this.parent = currentNode;
    }

    public void details() {
        System.out.println("\nDetaille sur " + this.realNode.getName() + ":\n");

        System.out.println("Nom: " + this.realNode.getName() +
                "\nType: " + this.realNode.getType() +
                "\nDossier : " + this.symbolicDirectory);
    }

    public void list() {
        this.realNode.list();
    }

    public void listing(int spacing) {
        this.realNode.listing(spacing);
    }

    public Node getParent() {
        return this.parent;
    }

    public String getName() {
        return this.realNode.getName();
    }

    public String getType() {
        return this.realNode.getType();
    }

    public String getDirectory() {
        return this.symbolicDirectory;
    }

    public int getComponentCount() {
        return this.realNode.getComponentCount();
    }

    public void addNode(Node node) {
        this.realNode.addNode(node);
    }

    public Node searchNode(String name) {
        return this.realNode.searchNode(name);
    }
}
