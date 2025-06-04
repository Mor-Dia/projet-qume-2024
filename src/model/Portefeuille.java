package model;

/**
 * Classe représentant le portefeuille où l'utilisateur insère l'argent.
 */
public class Portefeuille {
    private int montant;

    public void insererMontant(int montant) {
        if (montant > 0) {
            this.montant += montant;
        }
    }

    public int getMontant() {
        return montant;
    }

    public boolean debiterMontant(int montant) {
        if (this.montant >= montant) {
            this.montant -= montant;
            return true;
        }
        return false;
    }
}
