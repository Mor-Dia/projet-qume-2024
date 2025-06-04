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
    }
}
