# Image Docker

# Formation sur la Maîtrise des Images Docker

## Introduction

Les images Docker sont la pierre angulaire de la conteneurisation. Elles définissent le contenu et la configuration d'un conteneur Docker. Comprendre comment créer, gérer et partager des images est essentiel pour tirer pleinement parti de Docker.

## 1. Qu'est-ce qu'une Image Docker?

Une image Docker est un modèle léger qui contient tout le nécessaire pour exécuter une application, y compris le code, les dépendances, les variables d'environnement et la configuration. Les images sont créées à partir de Dockerfiles.

## 2. Commandes de Base pour Travailler avec des Images Docker

### 2.1. **`docker images`**

Affiche la liste des images disponibles sur la machine.

```bash
docker images
```


### 2.2. **`docker pull`**

Télécharge une image depuis un registre Docker (par défaut, Docker Hub).

```bash
docker pull nom_image[:tag]
```

### 2.3. **`docker build`**

Crée une image à partir d'un Dockerfile dans le répertoire courant.

```bash
docker build -t nom_image[:tag] .
```

### 2.4. **`docker rmi`**

Supprime une ou plusieurs images.

```bash
docker rmi nom_image[:tag]
```

## Démonstration Pratique

### Scenario: Création d'une Image Node.js

1. **Création d'un Dockerfile**:

   ```Dockerfile
   FROM node:14
   WORKDIR /app
   COPY package*.json ./
   RUN npm install
   COPY . .
   EXPOSE 3000
   CMD ["npm", "start"]
   ```

2. **Construction de l'Image**:

   ```bash
   docker build -t mon-app-nodejs:1.0 .
   ```

3. **Exécution d'un Conteneur avec l'Image Créée**:

   ```bash
   docker run -p 3000:3000 mon-app-nodejs:1.0
   ```

   - Ouvrez votre navigateur à [http://localhost:3000](http://localhost:3000) pour accéder à l'application Node.js.

4. **Suppression de l'Image (facultatif)**:

   ```bash
   docker rmi mon-app-nodejs:1.0
   ```

## 3. Gestion des Tags d'Image

Les tags permettent de versionner les images. Par défaut, le tag est `latest`.

- **Ajout d'un Tag lors de la Construction**:

  ```bash
  docker build -t mon-app-nodejs:version .
  ```

- **Modification du Tag d'une Image Existante**:

  ```bash
  docker tag mon-app-nodejs:version mon-app-nodejs:nouvelle_version
  ```

## Lexique

- **Dockerfile**: Script texte décrivant les étapes pour créer une image Docker.
- **`docker images`**: Commande pour lister les images.
- **`docker pull`**: Commande pour télécharger une image depuis un registre.
- **`docker build`**: Commande pour construire une image à partir d'un Dockerfile.
- **`docker rmi`**: Commande pour supprimer une image.
- **Tag d'Image**: Identifiant associé à une version spécifique de l'image.

## Liens Utiles

1. [Dockerizing Node.js Apps](https://nodejs.org/en/docs/guides/nodejs-docker-webapp/)
2. [Dockerfile Best Practices](https://docs.docker.com/engine/userguide/eng-image/dockerfile_best-practices/)
3. [Docker Hub](https://hub.docker.com/)
4. [Docker Documentation - Managing Images](https://docs.docker.com/engine/userguide/storagedriver/imagesandcontainers/)
