package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant le stock du distributeur (liste de boissons).
 */
public class Stock {
    private List<Boisson> boissons;

    public Stock() {
        boissons = new ArrayList<>();
    }

    public void ajouterBoisson(Boisson boisson) {
        boissons.add(boisson);
    }

    public Boisson trouverBoisson(String nom) {
        for (Boisson b : boissons) {
            if (b.getNom().equalsIgnoreCase(nom)) {
                return b;
            }
        }
        return null;
    }

    public boolean retirerBoisson(String nom, int quantite) {
        Boisson b = trouverBoisson(nom);
        if (b != null && b.getQuantite() >= quantite) {
            b.setQuantite(b.getQuantite() - quantite);
            return true;
        }
        return false;
    }

    public List<Boisson> getBoissons() {
        return boissons;
    }
}
