# Base Commande Linux pour docker

# Formation aux Commandes de Base Linux pour l'utilisation de Docker

## Introduction

Avant de plonger dans Docker, il est essentiel de maîtriser quelques commandes de base du système d'exploitation Linux. Ces compétences vous seront utiles lors de l'interaction avec Docker, notamment pour la gestion des conteneurs, des images et des fichiers.

## 1. Navigation dans le Système de Fichiers

### 1.1 `pwd` - Afficher le Répertoire Actuel
```bash
pwd
```

### 1.2 `ls` - Liste le Contenu du Répertoire
```bash
ls
```

- option a :
montre tous les fichiers, y compris ceux dont le nom commence par un point (les fichiers cachés)
```bash
ls -a
```
- option l :
génère une liste détaillée qui inclut des informations telles que les permissions, le nombre de liens, le propriétaire, le groupe, la taille, la date de modification et le nom du fichier.
```bash
ls -l
```
- option a et l :
```bash
ls -la
```

### 1.3 `cd` - Changer de Répertoire
```bash
cd chemin/vers/le/dossier
```

## 2. Manipulation de Fichiers et de Répertoires

### 2.1 `mkdir` - Créer un Nouveau Répertoire
```bash
mkdir nom-du-repertoire
```

### 2.2 `touch` - Créer un Nouveau Fichier
```bash
touch nom-du-fichier
```

### 2.3 `cp` - Copier des Fichiers ou des Répertoires
```bash
cp source destination
```

### 2.4 `mv` - Déplacer/Renommer des Fichiers ou des Répertoires
```bash
mv source destination
```

### 2.5 `rm` - Supprimer des Fichiers ou des Répertoires
```bash
rm nom-du-fichier
```

- si le dossier contient des fichiers ou sous répertoires
```bash
rm -rf /chemin/vers/le/dossier
```

## 3. Gestion des Permissions

### 3.1 `chmod` - Modifier les Permissions
```bash
chmod +x fichier   # Ajouter les droits d'exécution
chmod -r fichier   # Retirer les droits de lecture
```

## 4. Commandes Système

### 4.1 `ps` - Afficher les Processus en Cours
```bash
ps aux
```

### 4.2 `kill` - Terminer un Processus
```bash
kill PID
```

## Démonstration Pratique avec Docker

Pour mettre en pratique ces commandes, créons un conteneur Docker basé sur une image légère. Utilisons l'image Alpine Linux pour cette démo.

1. Téléchargez l'image Alpine Linux depuis le registre Docker:
   ```bash
   docker pull alpine
   ```

2. Créez un conteneur interactif en utilisant l'image Alpine:
   ```bash
   docker run -it --name alpine-demo alpine
   ```

   explication :
   - **`-it`**: interactif -i fournie une entée au conteneur et -t alloue un terminal (pseudo-tty)
   - **`-name alpine-demo`**: donne un nom personnalisé à notre conteneur, non obligatoire, mais dans ce cas, Docker générera un nom aléatoire constitué d'un adjectif et d'un philosophe célèbre.
   - **`alpine`**: dernier argument, celui-ci correspond à l'image à utiliser. Si celle-ci n'est pas présente en local, Docker cherchera cette image sur Docker Hub (par défaut).


3. À l'intérieur du conteneur, explorez les commandes Linux:
   - Utilisez `ls` pour lister les fichiers.
   - Créez un nouveau répertoire avec `mkdir`.
   - Créez un fichier avec `touch`.
   - Modifiez les permissions avec `chmod`.
   - apk upgrade
   - apk update
   - apk add nano

4. Quittez le conteneur en tapant `exit`.

## Lexique

- **`pwd`**: Print Working Directory - Affiche le répertoire actuel.
- **`ls`**: List - Liste le contenu du répertoire.
- **`cd`**: Change Directory - Change de répertoire.
- **`mkdir`**: Make Directory - Crée un nouveau répertoire.
- **`touch`**: Crée un nouveau fichier.
- **`cp`**: Copy - Copie des fichiers ou des répertoires.
- **`mv`**: Move - Déplace/Renomme des fichiers ou des répertoires.
- **`rm`**: Remove - Supprime des fichiers ou des répertoires.
- **`chmod`**: Change Mode - Modifie les permissions.

## Liens Utiles

1. [Linux Command Cheat Sheet](https://www.linuxtrainingacademy.com/linux-commands-cheat-sheet/)
2. [Docker Cheat Sheet](https://docs.docker.com/get-started/docker_cheatsheet.pdf) - Référence rapide des commandes Docker.
3. [Documentation Docker](https://docs.docker.com/) - Pour des informations détaillées sur les commandes Docker.
