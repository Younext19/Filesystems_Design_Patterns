package filesystem;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    private Node currentNode = null;
    private ProxyNode prxNode;
    private List<Node> fsList;
    private Scanner scanner;

    public void pressEnter(){
        System.out.println("Cliquez sur entrer pour continuer...");
        scanner.nextLine();
    }

    public void listAll(){
        for(Node drive: fsList){
            drive.list();
        }
    }

    public void initialize(){
        scanner = new Scanner(System.in);
        fsList = new ArrayList<Node>();
    }

    public void showPrompt(){
        System.out.println("1.Ajouter un système de fichier");
        System.out.println("2.Créer un dossier");
        System.out.println("3.Ouvrir un dossier");
        System.out.println("4.Fermer le dossier");
        System.out.println("5 Créer un fichier");
        System.out.println("6 Detaills du répertoire actuel");
        System.out.println("7 répertoire actuel");
        System.out.println("8 Créer un lien symbolique");
        System.out.println("9 Voir Tout");
        System.out.println("Autre _Quitter_");

        if(currentNode ==null){
            System.out.println("Pas de dossier");
            System.out.println("Entrez une valeur :");
        }
        else{
            System.out.println("Répertoire Actuel : ");
            System.out.println(currentNode.getDirectory() + '/');
            System.out.println("Entrez une valeur :");
        }
    }

    public void loadUI(){
        initialize();
        boolean en_marche = true;
        int input;
        String name;
        String path;
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
                    currentNode = fileSystem;
                    System.out.println(fileSystem.getName() + " " + fileSystem.getType() + " " + "crée!");
                    pressEnter();
                    break;

                case 2:
                    if(currentNode ==null){
                        System.out.println("Vous n'avez pas encore créer un système de fichier");
                        break;
                    }
                    System.out.println("Nom du dossier");
                    name = scanner.nextLine();
                    currentNode.addNode(new Dossier(name, "folder", currentNode.getDirectory(), currentNode));
                    pressEnter();
                    break;
                case 3:
                    if(currentNode ==null){
                        System.out.println("Vous n'avez pas encore créer un système de fichier");
                        break;
                    }
                    System.out.println("Nom du dossier :");
                    name = scanner.nextLine();
                    currentNode = currentNode.searchNode(name);
                    break;
                case 4:
                    if(currentNode ==null){
                        System.out.println("Vous n'avez pas encore créer un système de fichier");
                        break;
                    }
                    if(currentNode.getParent()!=null)
                        currentNode = currentNode.getParent();
                    else{
                        System.out.println("Ceci est le répertoire racine.");
                    }
                    pressEnter();
                    break;
                case 5:
                    if(currentNode ==null){
                        System.out.println("Vous n'avez pas encore créer un système de fichier.");
                        break;
                    }
                    System.out.println("Nom du fichier :");
                    name = scanner.nextLine();
                    currentNode.addNode(new Fichier(name, "file", currentNode.getDirectory(), currentNode));
                    pressEnter();
                    break;
                case 6:
                    if(currentNode ==null){
                        System.out.println("Vous n'avez pas encore créer un système de fichier");
                        break;
                    }
                    currentNode.details();
                    pressEnter();
                    break;
                case 7:
                    if(currentNode ==null){
                        System.out.println("Vous n'avez pas encore créer un système de fichier");
                        break;
                    }
                    currentNode.list();
                    pressEnter();
                    break;
                case 8:
                    if(currentNode ==null){
                        System.out.println("Vous n'avez pas encore créer un système de fichier.");
                        break;
                    }
                    System.out.println("Nom du fichier :");
                    path = scanner.nextLine();
                    currentNode.addNode(new ProxyNode(currentNode.searchNode(path), currentNode.getDirectory(),  currentNode));
                    pressEnter();
                    break;
                case 9:
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
