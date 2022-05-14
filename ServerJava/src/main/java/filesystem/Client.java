package filesystem;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    private Noeud currentNoeud = null;
    private List<Noeud> fsList;
    private Scanner scanner;

    public void pressEnter(){
        System.out.println("Cliquez sur entrer pour continuer...");
        scanner.nextLine();
    }

    public void listAll(){
        for(Noeud drive: fsList){
            drive.list();
        }
    }

    public void initialize(){
        scanner = new Scanner(System.in);
        fsList = new ArrayList<Noeud>();
    }

    public void showPrompt(){
        System.out.println("1.Ajouter un système de fichier");
        System.out.println("2.Créer un dossier");
        System.out.println("3.Ouvrir un dossier");
        System.out.println("4.Fermer le dossier");
        System.out.println("5 Créer un fichier");
        System.out.println("6 Detaills du répertoire actuel");
        System.out.println("7 répertoire actuel");
        System.out.println("8 Voir Tout");
        System.out.println("Autre _Quitter_");

        if(currentNoeud ==null){
            System.out.println("Pas de dossier");
            System.out.println("Entrez une valeur :");
        }
        else{
            System.out.println("Répertoire Actuel : ");
            System.out.println(currentNoeud.getDirectory() + '/');
            System.out.println("Entrez une valeur :");
        }
    }

    public void loadUI(){
        initialize();
        boolean en_marche = true;
        int input;
        String name;
        FileSystem fileSystem;
        while(en_marche){
            showPrompt();
            input = scanner.nextInt();
            scanner.nextLine();
            switch (input){
                case 1:
                    System.out.println("Nom de votre système de fichier :");
                    name = scanner.nextLine();
                    fileSystem = new FileSystem(name + ":");
                    fsList.add(fileSystem);
                    currentNoeud = fileSystem;
                    System.out.println(fileSystem.getName() + " " + fileSystem.getType() + " " + "crée!");
                    pressEnter();
                    break;

                case 2:
                    if(currentNoeud ==null){
                        System.out.println("Vous n'avez pas encore créer un système de fichier");
                        break;
                    }
                    System.out.println("Nom du dossier");
                    name = scanner.nextLine();
                    currentNoeud.addNode(new Dossier(name, "folder", currentNoeud.getDirectory(), currentNoeud));
                    pressEnter();
                    break;
                case 3:
                    if(currentNoeud ==null){
                        System.out.println("Vous n'avez pas encore créer un système de fichier");
                        break;
                    }
                    System.out.println("Nom du dossier :");
                    name = scanner.nextLine();
                    currentNoeud = currentNoeud.searchNode(name);
                    break;
                case 4:
                    if(currentNoeud ==null){
                        System.out.println("Vous n'avez pas encore créer un système de fichier");
                        break;
                    }
                    if(currentNoeud.getParent()!=null)
                        currentNoeud = currentNoeud.getParent();
                    else{
                        System.out.println("Ceci est le répertoire racine.");
                    }
                    pressEnter();
                    break;
                case 5:
                    if(currentNoeud ==null){
                        System.out.println("Vous n'avez pas encore créer un système de fichier.");
                        break;
                    }
                    System.out.println("Nom du fichier :");
                    name = scanner.nextLine();
                    currentNoeud.addNode(new Fichier(name, "file", currentNoeud.getDirectory(), currentNoeud));
                    pressEnter();
                    break;
                case 6:
                    if(currentNoeud ==null){
                        System.out.println("Vous n'avez pas encore créer un système de fichier");
                        break;
                    }
                    currentNoeud.details();
                    pressEnter();
                    break;
                case 7:
                    if(currentNoeud ==null){
                        System.out.println("Vous n'avez pas encore créer un système de fichier");
                        break;
                    }
                    currentNoeud.list();
                    pressEnter();
                    break;
                case 8:
                    listAll();
                    break;
                default:
                    en_marche = false;
                    System.out.println("Arrêt du programme !");
                    break;
            }
            System.out.flush();
        }
    }

}
