package Services;

import Services.IServiceAdmin;
import model.*;
import java.util.*;


public class ServiceAdmin implements IServiceAdmin,IServiceIHM{

    Banque mabanque;

    public ServiceAdmin(){}
    public ServiceAdmin(Banque mabanque){
        this.mabanque=mabanque;
    }

    @Override
    public void creeCompte(int i,Compte c) {
        mabanque.getClientsDeBanque().get(i).getComptes().add(c);
        System.out.println("Compte n°"+ c.getIdCompte() + " ajouté au Client avec succès");
    }
    @Override
    public void consulterDétailCompte(int i){

        System.out.println("\n=*=*=*=*=*=*=*=*==*=*=*=*=*=*=*=*==*=*=*=*=*=*=**=*=*=*=*=*=*");
        System.out.println(" -------- proprietaire = "+mabanque.getClientsDeBanque().get(i).getNomComplet()+"-----------");
        System.out.println("=*=*=*=*=*=*=*=*==*=*=*=*=*=*=*=*==*==*=*=*=*=*=*=*=*=*=*=*=*");
        System.out.println("=*=                                                =*=*=*=*=*");
        mabanque.getClientsDeBanque().get(i).getComptes().forEach(cd -> System.out.println( cd.toString()));
        System.out.println("=*=                                                =*=*=*=*=*");
        System.out.println("=*=*=*=*=*=*=*=*==*=**=*=*==*=*==*=*=*=*=*=*=*=*=*=*=*=*=**=*");

    }
    @Override
    public void creeclient(Client c) {
        mabanque.getClientsDeBanque().add(c);
        System.out.println("Client n°"+ c.getId() + " ajouté à la Banque avec succès");
    }

    @Override
    public void modifierclient() {

    }

    @Override
    public void modifiercompte() {

    }

    @Override
    public void supprimerclient(Client c) {
        boolean supprimer = false;
        if(this.mabanque.getClientsDeBanque().contains(c))
        {
            supprimer = this.mabanque.getClientsDeBanque().remove(c);
            System.out.println("Client supprimé avec succés!!!");
        }
        if(!supprimer){
            System.err.println("Suppression echoué :: Client n°"+c.getId()+" n'existe pas !!!");

        }
    }

    @Override
    public void supprimercompte(int i,Compte c) {
        boolean supprimer = false;
        if(this.mabanque.getClientsDeBanque().get(i).getComptes().contains(c)) {
            mabanque.getClientsDeBanque().get(i).getComptes().remove(c);
            System.out.println("Compte supprimer avec succés !!!");
        }
        else if(!supprimer){
            System.err.println("Suppression echoué :: Compte n°"+c.getIdCompte()+" n'existe pas !!!");
        }
    }

    @Override
    public void chercherclient(Client c) {

    }

    @Override
    public void afficherclientbanque() {
        System.out.println( mabanque.getClientsDeBanque().toString());
    }

    @Override
    public void afficherinformation() {
    }

    @Override
    public void menu(Scanner keyboard) {
        System.out.println("****************   Bienvenue haitam !! **************");
        String answer="";
        do {
            System.out.println("------------------------------->1.gerer les clients");
            System.out.println("------------------------------->2.gerer les comptes");
            System.out.println("------------------------------->3.Afficher les Clients");
            System.out.println("***********************************************");
            int choice = keyboard.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("------------------------------->1.Cree un Client");
                    System.out.println("------------------------------->2.Supprimer un Client");
                    int a = keyboard.nextInt();
                    if (a == 1) {
                        Scanner scr = new Scanner(System.in);
                        System.out.println("Entrée le Nom du nouveaux Client");
                        String nom = scr.nextLine();
                        System.out.println("Entrée le Prenom du nouveaux Client");
                        String prenom = scr.nextLine();
                        System.out.println("Entrée l'email du client");
                        String email = scr.nextLine();
                        System.out.println("Entrée le sexe du client");
                        Sexe sexe = Sexe.valueOf(scr.nextLine());
                        creeclient(new Client(nom, prenom, email, sexe));
                    } else if (a == 2) {
                        System.out.println("Entrée l'id du client pour le supprimé");
                        Long id = Long.valueOf(keyboard.nextInt());
                        supprimerclient(new Client(id));
                        afficherclientbanque();
                        break;

                    }
                case 2:{
                    System.out.println("------------------------------->1.Cree un Compte");
                    System.out.println("------------------------------->2.Supprimer un Compte");
                    System.out.println("------------------------------->3.Afficher les Comptes");
                    int b = keyboard.nextInt();
                    if(b==1){
                        Scanner scr = new Scanner(System.in);
                        System.out.println("Entrée le id du Client");
                        int id =  scr.nextInt();
                        System.out.println("Entrée le solde du Compte");
                        double solde = scr.nextDouble();
                        creeCompte(id,new Compte(solde));
                    }else if (b==2){
                        Scanner scr = new Scanner(System.in);
                        System.out.println("Entrée le id du Client");
                        int id =  scr.nextInt();
                        System.out.println("Entrée le solde du Compte que vous voulez supprimé");
                        double solde = scr.nextDouble();
                        supprimercompte(id,new Compte(solde));
                    }else if(b==3){
                        Scanner scr = new Scanner(System.in);
                        System.out.println("Entrée le id du Client");
                        int id =  scr.nextInt();
                        consulterDétailCompte(id);
                    }
                    break;
                }
                case 3: {
                    afficherclientbanque();
                    break;
                }
            }
            Scanner sc = new Scanner(System.in);
            System.out.println("============================================================");
            System.out.println("voulez vous revenir au menu ? =  : ");
            answer = sc.nextLine();
        } while (answer != "y");
    }
}
