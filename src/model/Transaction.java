package model;

/**
 * Classe représentant une transaction (achat d'une boisson).
 */
public class Transaction {
    private Boisson boisson;
    private int quantite;
    private int montantInsere;

    public Transaction(Boisson boisson, int quantite, int montantInsere) {
        this.boisson = boisson;
        this.quantite = quantite;
        this.montantInsere = montantInsere;
    }

    public int getMontantTotal() {
        return boisson.getPrix() * quantite;
    }

    @Override
    public String toString() {
        return " Achat de " + quantite + " " + boisson.getNom() + " pour " + getMontantTotal() + " F";
    }


}
