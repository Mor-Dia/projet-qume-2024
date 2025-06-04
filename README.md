# Distributeur Automatique de Boissons – Projet QUME L3

Ce projet Java implémente un **distributeur automatique de boissons**.
Il permet à un utilisateur d’insérer de l’argent, d’acheter des boissons, de consulter la liste des produits disponibles, de recharger le stock, et d’enregistrer les ventes.
NB:Pour que le projet marche sur ta machine Mr Diouf il faut que vous configurez  junit 5 dans intellij sur ta machine merci.


##  Architecture

### Packages :
- `app` : contient la classe `Main` pour lancer le programme
- `model` : contient toutes les classes métier (POO)
- `tests` : contient les tests unitaires et tests d'acceptance

### Classes principales :
- `Boisson` : nom, prix, quantité
- `Distributeur` : coordonne les classes
- `JournalVentes` : enregistrement des transactions
- `Portefeuille` : gère le montant inséré
- `Stock` : liste de boissons
- `Transaction` : achat d'une boisson
- `Utilisateur` : (facultatif) représente un client

---

##  Fonctionnalités

- Afficher la liste des boissons disponibles
- Insérer un montant d’argent
- Acheter une boisson (avec gestion du stock et du solde)
- Recharger le stock d'une boisson
- Enregistrer chaque achat dans un journal
- Afficher l’historique des ventes

---

##  Tests

###  Tests unitaires (JUnit)
- Fichier : `tests/DistributeurTest.java`
- Nombre de tests : 30
- Couvre : affichage, achat, recharge, erreurs, stock, journal, etc.

###  Tests d’acceptance
- Fichier : `tests/AcceptanceTest.java`
- 15 scénarios en langage clair (exemples codés dans `main()`)

---

## Exécution

### Depuis IntelliJ:
1. Ouvrir le projet
2. Lancer `Main.java` pour test manuel
3. Lancer `DistributeurTest.java` pour exécuter les tests unitaires
4. Lancer `AcceptanceTest.java` pour simuler les scénarios d’acceptance

---

## Structure

```
DistributeurBoissons/
├── src/
│   ├── model/
│   └── app/Main.java
├── tests/
│   ├── DistributeurTest.java
│   └── AcceptanceTest.java
├── README.md
```

---

##  Auteurs

- Projet QUME L3 – MQPL
- Étudiants : [Cheikhouna Khadim kebe,Mor Dia et Serigne Fallou Seck]

