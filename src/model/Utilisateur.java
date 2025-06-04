package model;

/**
 * Classe représentant un utilisateur (non obligatoire mais utile pour extension).
 */
public class Utilisateur {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private int solde;

    public Utilisateur(int id, String nom, String prenom, String email, int solde) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.solde = solde;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getEmail() { return email; }
    public int getSolde() { return solde; }

    public void insererMontant(int montant) {
        if (montant > 0) this.solde += montant;
    }

    public boolean debiterSolde(int montant) {
        if (montant <= solde) {
            solde -= montant;
            return true;
        }
        return false;
    }

    public String getNomComplet() {
        return prenom + " " + nom;
    }

    @Override
    public String toString() {
        return getNomComplet() + " - Email: " + email + " - Solde: " + solde + " F";
    }
}
