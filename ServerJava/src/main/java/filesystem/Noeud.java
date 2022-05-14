package filesystem;

public interface Noeud {
    public void details();
    public void list();
    public void listing(int spacing);
    public Noeud getParent();
    public String getName();
    public String getType();
    public String getDirectory();

    int getComponentCount();

    public void addNode(Noeud noeud);
    public Noeud searchNode(String name);
}
