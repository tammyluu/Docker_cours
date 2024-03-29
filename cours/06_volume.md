# Volume Docker

# Formation sur les Volumes Docker

## Introduction

Les volumes Docker sont utilisés pour partager et persister des données entre les conteneurs et le système hôte. Comprendre la gestion des volumes est crucial pour le stockage de données de manière persistante et le partage d'informations entre les conteneurs.

## 1. Qu'est-ce qu'un Volume Docker?

Un volume Docker est un mécanisme de stockage persistant qui existe en dehors du cycle de vie du conteneur. Il permet le partage de données entre les conteneurs, ainsi que la persistance des données même si le conteneur est supprimé.

## 2. Commandes de Base pour Travailler avec des Volumes Docker

### 2.1. **`docker volume create`**

Crée un volume Docker.

```bash
docker volume create nom_volume
```

### 2.2. **`docker volume ls`**

Affiche la liste des volumes Docker.

```bash
docker volume ls
```

### 2.3. **`docker run -v`**

Monte un volume dans un conteneur pendant son démarrage.

```bash
docker run -v nom_volume:/chemin/du/volume nom_image
```

### 2.4. **`docker inspect`**

Affiche des informations détaillées sur un volume.

```bash
docker inspect nom_volume
```

### 2.5. **`docker rm -v`**

Supprime un conteneur et le volume monté avec l'option `-v`.

```bash
docker rm -v nom_conteneur
```

### 2.6. **`docker volume rm`**

Supprime un ou plusieurs volumes Docker.

```bash
docker volume rm nom_volume
```

## Démonstration Pratique

### Scenario: Utilisation d'un Volume pour Persister des Données MySQL

1. **Création d'un Volume MySQL**:

   ```bash
   docker volume create mysql_data
   ```

2. **Exécution d'un Conteneur MySQL avec le Volume Monté**:

   ```bash
   docker run -d --name mon-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -v mysql_data:/var/lib/mysql mysql:latest
   ```

3. **Vérification de l'Exécution et des Volumes Montés**:

   ```bash
   docker ps
   docker inspect mon-mysql
   ```

4. **Arrêt et Suppression du Conteneur (facultatif)**:

   ```bash
   docker stop mon-mysql
   docker rm mon-mysql
   ```

   - Le volume `mysql_data` persiste même si le conteneur est supprimé.

## 3. Gestion des Types de Volumes

### 3.1. **Volumes de Type Bind Mount**

- Montage d'un répertoire du système hôte dans un conteneur.

  ```bash
  docker run -v /chemin/local:/chemin/conteneur nom_image
  ```

### 3.2. **Volumes de Type Named Volume**

- Création explicite d'un volume nommé.

  ```bash
  docker volume create nom_volume
  ```

### 3.3. **Volumes de Type Anonymous Volume**

- Création automatique d'un volume sans spécifier de nom.

  ```bash
  docker run -v /chemin/conteneur nom_image
  ```

## Lexique

- **Volume Docker**: Mécanisme de stockage persistant pour partager et persister des données entre les conteneurs et le système hôte.
- **`docker volume create`**: Commande pour créer un volume Docker.
- **`docker volume ls`**: Commande pour afficher la liste des volumes Docker.
- **`docker run -v`**: Commande pour monter un volume dans un conteneur pendant son démarrage.
- **`docker inspect`**: Commande pour afficher des informations détaillées sur un volume.
- **`docker rm -v`**: Commande pour supprimer un conteneur et le volume monté avec l'option `-v`.
- **`docker volume rm`**: Commande pour supprimer un ou plusieurs volumes Docker.
- **Volumes de Type Bind Mount**: Montage d'un répertoire du système hôte dans un conteneur.
- **Volumes de Type Named Volume**: Volume Docker avec un nom spécifié explicitement.
- **Volumes de Type Anonymous Volume**: Volume Docker créé automatiquement sans spécifier de nom.

## Liens Utiles

1. [Docker Documentation - Manage Data in Containers](https://docs.docker.com/storage/)
