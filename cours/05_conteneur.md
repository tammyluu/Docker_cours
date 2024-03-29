# Conteneur Docker

# Formation sur les Conteneurs Docker

## Introduction

Les conteneurs Docker sont des instances exécutables légères et indépendantes qui encapsulent une application et ses dépendances. Comprendre la gestion des conteneurs est essentiel pour exploiter pleinement les avantages de Docker.

## 1. Qu'est-ce qu'un Conteneur Docker?

Un conteneur Docker est une instance exécutable d'une image Docker. Il isole l'application et ses dépendances du système hôte, garantissant une portabilité et une cohérence d'exécution.

## 2. Commandes de Base pour Travailler avec des Conteneurs Docker

### 2.1. **`docker run`**

Crée et démarre un conteneur à partir d'une image.

```bash
docker run [options] nom_image[:tag] [commande] [arguments]
```

### 2.2. **`docker ps`**

Affiche les conteneurs en cours d'exécution.

```bash
docker ps
```

### 2.3. **`docker exec`**

Exécute une commande à l'intérieur d'un conteneur en cours d'exécution.

```bash
docker exec [options] nom_conteneur commande [arguments]
```

### 2.4. **`docker stop`**

Arrête un ou plusieurs conteneurs.

```bash
docker stop nom_conteneur
```

### 2.5. **`docker rm`**

Supprime un ou plusieurs conteneurs.

```bash
docker rm nom_conteneur
```

### 2.6. **`docker logs`**

Affiche les logs d'un conteneur.

```bash
docker logs nom_conteneur
```

### 2.6. **`option -p`**

Cette option permet de rediriger tout le trafic envoyé au port choisi sur votre machine vers le port choisi à l'intérieur du conteneur.

```bash
run -p <port hote>:<port container> nom_image[:tag] [commande] [arguments]
```

## Démonstration Pratique

### Scenario: Exécution d'un Conteneur MySQL

1. **Téléchargement et Exécution d'un Conteneur MySQL**:

   ```bash
   docker run -d --name mon-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw mysql:latest
   ```

   - `-d`: Mode détaché.
   - `--name mon-mysql`: Attribution d'un nom au conteneur.
   - `-e MYSQL_ROOT_PASSWORD=my-secret-pw`: Définition d'un mot de passe pour l'utilisateur root.

2. **Vérification de l'Exécution du Conteneur**:

   ```bash
   docker ps
   ```

3. **Connexion à MySQL depuis un Client MySQL**:

   ```bash
   docker exec -it mon-mysql mysql -uroot -pmy-secret-pw
   ```

4. **Arrêt et Suppression du Conteneur (facultatif)**:

   ```bash
   docker stop mon-mysql
   docker rm mon-mysql
   ```

### Scenario: Exécution d'un Conteneur serveur web avec caddy

1. **Téléchargement et Exécution d'un Conteneur caddy**:

   ```bash
   docker run -p 8080:80 --name caddy-container -d caddy

   ```

   - `-d`: Mode détaché.
   - `--name caddy-container`: Attribution d'un nom au conteneur.
   - `-p 8080:80`: cette option permet de rediriger tout trafic envoyé au port 8080 sur votre machine vers le port 80 à l'intérieur du conteneur.


### Scenario: Exécution d'un Conteneur serveur dotnet

1. **Téléchargement et Exécution d'un Conteneur dotnet**:

   ```bash
   docker run -it -p 5000:5000 -p 5001:5001 mcr.microsoft.com/dotnet/sdk:latest
   ```

   - `-p 5000:5000 -p 5001:5001`: cette option permet de rediriger tout trafic envoyé au port 5000 et 5001 sur votre machine vers le port 5000 et 5001 à l'intérieur du conteneur.

   - Dans le conteneur

    ```bash
   cd /tmp
   dotnet new webapi -n MonAppAspNet
   cd MonAppAspNet
   dotnet run --urls=http://O.O.O.O:5000
   ```

## 3. Gestion des Réseaux Docker

### 3.1. **`docker network create`**

Crée un réseau Docker.

```bash
docker network create nom_reseau
```

### 3.2. **`docker network connect`**

Connecte un conteneur à un réseau.

```bash
docker network connect nom_reseau nom_conteneur
```

### 3.3. **`docker network ls`**

Affiche la liste des réseaux Docker.

```bash
docker network ls
```

## Lexique

- **Conteneur Docker**: Instance exécutable d'une image Docker.
- **`docker run`**: Commande pour créer et démarrer un conteneur à partir d'une image.
- **`docker ps`**: Commande pour afficher les conteneurs en cours d'exécution.
- **`docker exec`**: Commande pour exécuter une commande à l'intérieur d'un conteneur en cours d'exécution.
- **`docker stop`**: Commande pour arrêter un ou plusieurs conteneurs.
- **`docker rm`**: Commande pour supprimer un ou plusieurs conteneurs.
- **`docker logs`**: Commande pour afficher les logs d'un conteneur.
- **Réseau Docker**: Environnement réseau isolé pour les conteneurs Docker.

## Liens Utiles

1. [Docker Documentation - Containers](https://docs.docker.com/get-started/overview/#containers)
2. [Docker Networking](https://docs.docker.com/network/)
3. [Doc dotnet new](https://learn.microsoft.com/fr-fr/dotnet/core/tools/dotnet-new) - Documentation commande dotnet new.
