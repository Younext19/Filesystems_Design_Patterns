package filesystem;

public interface Node {
    public void details();
    public void list();
    public void listing(int spacing);
    public Node getParent();
    public String getName();
    public String getType();
    public String getDirectory();

    int getComponentCount();

    public void addNode(Node node);
    public Node searchNode(String name);
}
