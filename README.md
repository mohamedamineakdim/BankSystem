# BankSystem — Java / Swing / Oracle

Projet scolaire de gestion bancaire realise en Java.

## Contenu
- Interfaces Swing pour les modes gestionnaire et client (`src/ui`)
- Modeles de comptes et transactions (`src/model`)
- Acces aux donnees Oracle (`src/dao`)
- Services, validations et exceptions
- Script SQL de creation des tables et sequences (`database/`)

## Configuration

Le projet utilise le pilote JDBC Oracle, qui doit etre ajoute au classpath dans votre environnement Java. Une base Oracle doit etre disponible. Configurez ces variables d'environnement avant l'execution :

- `BANK_DB_URL` (par defaut : `jdbc:oracle:thin:@//localhost:1521/XE`)
- `BANK_DB_USER`
- `BANK_DB_PASSWORD`

Connectez-vous a votre schema Oracle dans SQL*Plus puis executez le script dans `database/`. **Attention : ce script supprime les tables et sequences du projet si elles existent deja.**

Point d'entree : `src/ui/Main.java` (classe `ui.Main`).

## Note

Projet scolaire réalisé dans le cadre de ma formation en informatique. Il m'a permis de pratiquer la programmation orientée objet en Java, la création d'interfaces graphiques avec Swing et la gestion des données avec Oracle.
