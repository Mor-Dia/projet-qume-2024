import model.*;

public class AcceptanceTest {
    public static void main(String[] args) {
        Distributeur d = new Distributeur();
        System.out.println("==== TEST 1 : Affichage des boissons ====");
        d.getStock().ajouterBoisson(new Boisson("Coca", 500, 5));
        d.getStock().ajouterBoisson(new Boisson("Fanta", 400, 2));
        d.listerBoissons();

        System.out.println("\n==== TEST 2 : Achat réussi ====");
        d.insererMontant(500);
        d.acheterBoisson("Coca", 1);

        System.out.println("\n==== TEST 3 : Achat échoué (montant insuffisant) ====");
        d.insererMontant(100);
        d.acheterBoisson("Fanta", 1);

        System.out.println("\n==== TEST 4 : Recharge de stock ====");
        d.rechargerStock("Fanta", 5);
        d.listerBoissons();

        System.out.println("\n==== TEST 5 : Achat avec boisson inconnue ====");
        d.acheterBoisson("Sprite", 1);


        System.out.println("\n==== TEST 6 : Recharge boisson inconnue ====");
        d.rechargerStock("Sprite", 2);

        System.out.println("\n==== TEST 7 : Achat Fanta après recharge ====");
        d.insererMontant(800);
        d.acheterBoisson("Fanta", 2);

        System.out.println("\n==== TEST 8 : Achat Coca en rupture de stock ====");
        d.insererMontant(3000);
        d.acheterBoisson("Coca", 10); // trop

        System.out.println("\n==== TEST 9 : Achat multiple de Coca ====");
        d.insererMontant(1000);
        d.acheterBoisson("Coca", 2);

        System.out.println("\n==== TEST 10 : Insertion de montant négatif ====");
        d.insererMontant(-100); // doit être ignoré

        System.out.println("\n==== TEST 11 : Achat sans montant ====");
        Distributeur d2 = new Distributeur();
        d2.getStock().ajouterBoisson(new Boisson("IceTea", 600, 2));
        d2.acheterBoisson("IceTea", 1);

        System.out.println("\n==== TEST 12 : Historique des ventes ====");
        System.out.println("Ventes enregistrées : " + d.getJournal().getHistorique().size());

        System.out.println("\n==== TEST 13 : Achat après insertion en deux fois ====");
        d.insererMontant(200);
        d.insererMontant(300);
        d.acheterBoisson("Coca", 1);

        System.out.println("\n==== TEST 14 : Recharge visible ====");
        d.rechargerStock("Coca", 1);
        d.listerBoissons();

        System.out.println("\n==== TEST 15 : Achat exact du stock ====");
        d.insererMontant(500 * d.getStock().trouverBoisson("Coca").getQuantite());
        int q = d.getStock().trouverBoisson("Coca").getQuantite();
        d.acheterBoisson("Coca", q);
        System.out.println("Reste Coca : " + d.getStock().trouverBoisson("Coca").getQuantite());


    }
}
