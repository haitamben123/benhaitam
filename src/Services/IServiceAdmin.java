package Services;
import  model.Client;
import  model.Compte;

public interface IServiceAdmin {
    void creeCompte(int i,Compte c);
    void creeclient(Client c);
    void modifierclient();
    void modifiercompte();
    void supprimerclient(Client c);
    void supprimercompte(int i,Compte c);
    void chercherclient(Client c);
    void afficherclientbanque();
    void afficherinformation();
    void consulterDétailCompte(int i);
}
