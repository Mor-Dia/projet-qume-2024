package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant le journal des ventes (historique des transactions).
 */
public class JournalVentes {
    private List<Transaction> transactions;

    public JournalVentes() {
        transactions = new ArrayList<>();
    }

    public void enregistrerVente(Transaction t) {
        transactions.add(t);
    }

    public List<Transaction> getHistorique() {
        return transactions;
    }
}
