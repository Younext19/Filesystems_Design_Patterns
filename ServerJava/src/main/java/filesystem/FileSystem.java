package filesystem;
import java.util.ArrayList;
import java.util.List;

public class FileSystem implements Noeud {
    private String name;
    private String type;
    private String directory;
    private int component_count;
    private List<Noeud> noeudList;
    private Noeud parent;


    public FileSystem(String name) {
        this.name = name;
        this.type = "fs";
        this.directory = name;
        this.component_count = 0;
        this.noeudList = new ArrayList<Noeud>();
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
        for(Noeud noeud : noeudList){
            noeud.listing(spacing + 4);
        }
    }

    @Override
    public Noeud getParent() {
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
    public void addNode(Noeud noeud) {

        if("fs".equalsIgnoreCase(noeud.getType())){
            System.out.println("Vous ne pouvez pas ajouter un système de fichier dans un système de fichier");
        }

        else{
            noeudList.add(noeud);
            System.out.println(noeud.getName() + " " + noeud.getType() + " " + "Crée en " + noeud.getParent().getDirectory());
            component_count++;
        }
    }

    @Override
    public Noeud searchNode(String name) {
        for(Noeud noeud : noeudList){
            if(name.equalsIgnoreCase(noeud.getName())){
                System.out.println( noeud.getName() + " " + noeud.getType() + "opened.");
                return noeud;
            }
        }
        System.out.println("Pas de dossier dans ce dossier.");
        return this;
    }
}
