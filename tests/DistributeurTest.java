import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DistributeurTest {
    private Distributeur d;

    @BeforeEach
    public void setup() {
        d = new Distributeur();
        d.getStock().ajouterBoisson(new Boisson("Coca", 500, 5));
        d.getStock().ajouterBoisson(new Boisson("Fanta", 400, 3));
    }

    @Test
    public void testAffichageBoissons() {
        System.out.println("🔍 Test : Affichage des boissons");
        d.listerBoissons();
        assertEquals(2, d.getStock().getBoissons().size());
    }

    @Test
    public void testAchatBoissonAvecMontantSuffisant() {
        d.insererMontant(500);
        d.acheterBoisson("Coca", 1);
        assertEquals(4, d.getStock().trouverBoisson("Coca").getQuantite());
    }

    @Test
    public void testAchatMontantInsuffisant() {
        d.insererMontant(200);
        d.acheterBoisson("Coca", 1);
        assertEquals(5, d.getStock().trouverBoisson("Coca").getQuantite());
    }

    @Test
    public void testAchatRuptureStock() {
        d.insererMontant(1200);
        d.acheterBoisson("Fanta", 3); // stock à 0
        d.insererMontant(400);
        d.acheterBoisson("Fanta", 1); // devrait échouer
        assertEquals(0, d.getStock().trouverBoisson("Fanta").getQuantite());
    }

    @Test
    public void testAchatBoissonInexistante() {
        d.insererMontant(500);
        d.acheterBoisson("Sprite", 1);
        assertNull(d.getStock().trouverBoisson("Sprite"));
    }

    @Test
    public void testRechargementStock() {
        d.rechargerStock("Fanta", 2);
        assertEquals(5, d.getStock().trouverBoisson("Fanta").getQuantite());
    }

    @Test
    public void testRechargeBoissonInexistante() {
        d.rechargerStock("Sprite", 2);
        assertNull(d.getStock().trouverBoisson("Sprite"));
    }

    @Test
    public void testMontantNegatif() {
        d.insererMontant(-100);
        assertEquals(0, d.getPortefeuille().getMontant());
    }

    @Test
    public void testDebitImpossible() {
        assertFalse(d.getPortefeuille().debiterMontant(100));
    }

    @Test
    public void testAchatQuantiteMultiple() {
        d.insererMontant(1000);
        d.acheterBoisson("Coca", 2);
        assertEquals(3, d.getStock().trouverBoisson("Coca").getQuantite());
    }

    @Test
    public void testGetMontant() {
        d.insererMontant(700);
        assertEquals(700, d.getPortefeuille().getMontant());
    }

    @Test
    public void testGetNomBoisson() {
        assertEquals("Coca", d.getStock().trouverBoisson("Coca").getNom());
    }

    @Test
    public void testGetPrixBoisson() {
        assertEquals(500, d.getStock().trouverBoisson("Coca").getPrix());
    }

    @Test
    public void testGetQuantiteBoisson() {
        assertEquals(5, d.getStock().trouverBoisson("Coca").getQuantite());
    }

    @Test
    public void testSetQuantiteBoisson() {
        Boisson b = d.getStock().trouverBoisson("Coca");
        b.setQuantite(10);
        assertEquals(10, b.getQuantite());
    }

    @Test
    public void testVenteEnregistree() {
        d.insererMontant(500);
        d.acheterBoisson("Coca", 1);
        assertEquals(1, d.getJournal().getHistorique().size());
    }

    @Test
    public void testMontantTotalTransaction() {
        Transaction t = new Transaction(new Boisson("Fanta", 400, 1), 2, 800);
        assertEquals(800, t.getMontantTotal());
    }

    @Test
    public void testHistoriqueVideInitialement() {
        Distributeur distributeur = new Distributeur(); // indépendant
        assertEquals(0, distributeur.getJournal().getHistorique().size());
    }

    @Test
    public void testTransactionToString() {
        Transaction t = new Transaction(new Boisson("Fanta", 400, 5), 2, 800);
        assertTrue(t.toString().contains("Fanta"));
    }

    @Test
    public void testJournalAjouteTransaction() {
        JournalVentes j = new JournalVentes();
        j.enregistrerVente(new Transaction(new Boisson("Fanta", 400, 2), 1, 400));
        assertEquals(1, j.getHistorique().size());
    }

    @Test
    public void testAjouterNouvelleBoisson() {
        d.getStock().ajouterBoisson(new Boisson("Sprite", 300, 4));
        assertNotNull(d.getStock().trouverBoisson("Sprite"));
    }

    @Test
    public void testAjoutMontantPlusieursFois() {
        d.insererMontant(200);
        d.insererMontant(300);
        assertEquals(500, d.getPortefeuille().getMontant());
    }

    @Test
    public void testRetraitBoissonInvalide() {
        assertFalse(d.getStock().retirerBoisson("Coca", 20));
    }

    @Test
    public void testRetraitBoissonValide() {
        assertTrue(d.getStock().retirerBoisson("Coca", 2));
    }

    @Test
    public void testStockVideSiToutesVentes() {
        d.insererMontant(2500);
        d.acheterBoisson("Coca", 5);
        assertEquals(0, d.getStock().trouverBoisson("Coca").getQuantite());
    }

    @Test
    public void testBoissonToStringFormat() {
        String s = d.getStock().trouverBoisson("Coca").toString();
        assertTrue(s.contains("Coca") && s.contains("500"));
    }

    @Test
    public void testBoissonPrixInchange() {
        Boisson b = d.getStock().trouverBoisson("Coca");
        assertEquals(500, b.getPrix());
    }

    @Test
    public void testSetQuantiteNegative() {
        Boisson b = d.getStock().trouverBoisson("Coca");
        b.setQuantite(-5);
        assertEquals(-5, b.getQuantite()); // logique interne à toi de sécuriser
    }

    @Test
    public void testRetraitExactQuantiteDisponible() {
        assertTrue(d.getStock().retirerBoisson("Fanta", 3));
    }

    @Test
    public void testGetBoissonsListeNonVide() {
        assertFalse(d.getStock().getBoissons().isEmpty());
    }

}
