package model;

/**
 * Classe principale qui coordonne portefeuille, stock et journal de ventes.
 */
public class Distributeur {
    private Portefeuille portefeuille;
    private Stock stock;
    private JournalVentes journal;

    public Distributeur() {
        portefeuille = new Portefeuille();
        stock = new Stock();
        journal = new JournalVentes();
    }

    public void listerBoissons() {
        for (Boisson b : stock.getBoissons()) {
            System.out.println(b);
        }
    }

    public void insererMontant(int montant) {
        portefeuille.insererMontant(montant);
    }

    public void acheterBoisson(String nom, int quantite) {
        Boisson b = stock.trouverBoisson(nom);
        if (b == null) {
            System.out.println("Boisson non trouvée !");
            return;
        }

        int total = b.getPrix() * quantite;
        if (!portefeuille.debiterMontant(total)) {
            System.out.println("Montant insuffisant !");
            return;
        }

        if (!stock.retirerBoisson(nom, quantite)) {
            System.out.println("Stock insuffisant !");
            return;
        }

        Transaction t = new Transaction(b, quantite, total);
        journal.enregistrerVente(t);
        System.out.println(t);
    }

    public void rechargerStock(String nom, int quantite) {
        Boisson b = stock.trouverBoisson(nom);
        if (b != null) {
            b.setQuantite(b.getQuantite() + quantite);
        } else {
            System.out.println("Boisson introuvable pour rechargement.");
        }
    }

    public Portefeuille getPortefeuille() { return portefeuille; }
    public Stock getStock() { return stock; }
    public JournalVentes getJournal() { return journal; }
}
