package model;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class Compte {

    private Long idCompte;
    private Double solde;
    private LocalDateTime date_de_creation;
    private List<Log> logs = new ArrayList<>();
    private Client proprietaire;

    /**
     * Incrémentation automatique du id
     */

    public static Long idco=(long) 0;

    /**
     * l'encapsulation
     */

    public Long getIdCompte() { return idCompte; }
    public double getSolde() { return solde; }
    public LocalDateTime getDate_de_creation() { return date_de_creation; }
    public Client getProprietaire() { return proprietaire; }
    public List<Log> getLogs() { return logs; }
    public void setLog(TypeLog type, String msg) {
        Log log = new Log(LocalDate.now(), LocalTime.now(), type, msg);
        logs.add(log);
    }
    public void setIdCompte() { this.idCompte=idco++; }
    public void setSolde(double solde) {
        if(solde>= solde)
            this.solde=solde;
        else
            this.solde=0.0;
    }
    public void setDate_de_creation() { this.date_de_creation=LocalDateTime.now(); }

    public void setProprietaire(Client proprietaire) { this.proprietaire=proprietaire; }

    /**
     * Constructeur
     */
    public Compte(double solde) {
        setIdCompte();
        setSolde(solde);
        setDate_de_creation();
        setProprietaire(null);
    }
    public Compte() {
        setIdCompte();
        setSolde(0.0);
        setDate_de_creation();
        setProprietaire(null);
    }

    @Override
    public boolean equals(Object other) {
        if(other instanceof Compte)
            return (solde.equals(((Compte) other).solde));
        else
            return false;
    }
    @Override
    public String toString() {
        return
                "n°compte = "+idCompte
                        +"\n    ->solde = "+solde
                        +"\n    ->date de creation = "+date_de_creation;
    }

}
