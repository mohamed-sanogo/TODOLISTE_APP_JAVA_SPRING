README pour le Backend (Java Spring)

Backend - Application de Gestion de Tâches

1-Description:

Ce projet est le backend d'une application de gestion de tâches, développé en Java avec le framework Spring Boot. Il expose des API REST pour créer, mettre à jour, lire et supprimer des tâches.

2-Prérequis:

Java JDK 17 ou supérieur
Maven 3.8.1 ou supérieur (pour la gestion des dépendances et la construction du projet)
PostgreSQL ou autre base de données compatible (modifiez la configuration pour utiliser une autre base de données)

3-Installation:

git clone https://github.com/mohamed-sanogo/TODOLIST_APP_JAVA_SPRING.git
cd nom-du-repository-backend

2-Configurez la base de données:

Modifiez le fichier src/main/resources/application.properties pour configurer votre connexion à la base de données :
spring.datasource.username=nom_utilisateur
spring.datasource.password=mot_de_passe
Si vous utiliser postgreSQL en important la dependence :
spring.datasource.url=jdbc:postgresql 

3-Construisez le projet :

mvn clean install

4-Démarrez l'application :

mvn spring-boot:run

5-API:

Endpoints
GET /api/taches : Récupère toutes les tâches.
POST /api/taches : Crée une nouvelle tâche.
PUT /api/taches/{id} : Met à jour une tâche existante.
DELETE /api/taches/{id} : Supprime une tâche par son ID.

L'application sera disponible sur http://localhost:8080.

Contribuer....