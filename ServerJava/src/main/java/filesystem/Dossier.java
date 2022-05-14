package filesystem;

import java.util.ArrayList;
import java.util.List;

public class Dossier implements Noeud {
    private String name;
    private String type;
    private String directory;
    private int component_count;
    private Noeud parent;
    private List<Noeud> noeudList;

    public Dossier(String name, String type, String currentDirectory, Noeud currentNoeud) {
        this.name = name;
        this.type = type;
        this.directory = currentDirectory + "/" + name;
        this.parent = currentNoeud;
        this.component_count = 0;
        this.noeudList = new ArrayList<Noeud>();
    }

    public Dossier(String name, String type, String currentDirectory) {
        this.name = name;
        this.type = type;
        this.directory = currentDirectory + "/" + name;
        this.parent = null;
        this.component_count = 0;
        this.noeudList = new ArrayList<Noeud>();
    }

    @Override
    public Noeud getParent() {
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
        for(Noeud noeud : noeudList){
            noeud.listing(spacing + 4);
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
        System.out.println("No such Folder found in this directory.");
        return this;
    }


    @Override
    public void addNode(Noeud noeud){
        if("fs".equalsIgnoreCase(noeud.getType())){
            System.out.println("Vous ne pouvez pas ajouter un système de fichier dans un dossier.");
        }

        else{
            noeudList.add(noeud);
            System.out.println(noeud.getName() + " " + noeud.getType() + " " + "created in " + noeud.getParent().getDirectory());
            component_count++;
        }
    }
}
