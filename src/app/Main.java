package app;

import model.*;

public class Main {
    public static void main(String[] args) {
        Distributeur distributeur = new Distributeur();

        distributeur.getStock().ajouterBoisson(new Boisson("Coca", 500, 0));
        distributeur.getStock().ajouterBoisson(new Boisson("Fanta", 400, 3));
        distributeur.getStock().ajouterBoisson(new Boisson("Sprite", 700, 4));
        distributeur.getStock().ajouterBoisson(new Boisson("Vimto", 700, 5));//
        distributeur.getStock().ajouterBoisson(new Boisson("3X", 700, 6));// stock vide pour tester


        System.out.println(" Liste des boissons disponibles :");
        distributeur.listerBoissons();

        System.out.println("\n= Insertion d'argent  ==");
        distributeur.insererMontant(1000);

        try {
            System.out.println("🛒 Achat d'une Fanta...");
            distributeur.acheterBoisson("Fanta",3);
        } catch (Exception e) {
            System.out.println(" Erreur : " + e.getMessage());
        }
        System.out.println("\n Réinsertion de 1000 F pour Sprite...");
        distributeur.insererMontant(1000);
        try {
            System.out.println("🛒 Achat d'une Sprite...");
            distributeur.acheterBoisson("Sprite",2);
        } catch (Exception e) {
            System.out.println(" Erreur : " + e.getMessage());
        }

        System.out.println("\n Historique des transactions :");
        for(Transaction t : distributeur.getJournal().getHistorique()) {
            System.out.println(t);
        }
    }
}
