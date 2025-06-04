package model;

/**
 * Classe représentant une boisson.
 */
public class Boisson {
    private String nom;
    private int prix;
    private int quantite;

    public Boisson(String nom, int prix, int quantite) {
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
    }

    public String getNom() {
        return nom;
    }

    public int getPrix() {
        return prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return nom + " - " + prix + " F (" + quantite + " en stock)";
    }
}
