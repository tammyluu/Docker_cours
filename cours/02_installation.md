# Installation

# Installation de Docker

## 1. Prérequis

Avant d'installer Docker sur votre machine, assurez-vous de satisfaire les conditions préalables suivantes:

- **Linux**: Le support varie selon la distribution. Consultez la [documentation officielle de Docker pour Linux](https://docs.docker.com/install/linux/) pour les détails spécifiques à votre distribution.

- **Windows**: Docker Desktop nécessite Windows 10 Pro/Enterprise ou Windows Server 2016. Assurez-vous que la virtualisation est activée dans le BIOS. Plus de détails sont disponibles dans la [documentation officielle de Docker pour Windows](https://docs.docker.com/install/windows/).

- **macOS**: Docker Desktop nécessite macOS El Capitan 10.11 et versions ultérieures. Plus d'informations sont disponibles dans la [documentation officielle de Docker pour macOS](https://docs.docker.com/install/mac/).

## 2. Installation sur différentes plateformes

### 2.1 Installation sur Linux

1. Mettez à jour le cache des paquets:
   ```bash
   sudo apt-get update
   ```

2. Installez les paquets permettant l'utilisation de HTTPS:
   ```bash
   sudo apt-get install apt-transport-https ca-certificates curl software-properties-common
   ```

3. Ajoutez la clé GPG officielle de Docker:
   ```bash
   curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /usr/share/keyrings/docker-archive-keyring.gpg
   ```

4. Configurez le repository stable:
   ```bash
   echo "deb [signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
   ```

5. Installez Docker:
   ```bash
   sudo apt-get update
   sudo apt-get install docker-ce docker-ce-cli containerd.io
   ```

### 2.2 Installation sur Windows et macOS

1. Téléchargez Docker Desktop à partir du [site officiel](https://www.docker.com/products/docker-desktop) et suivez les [instructions d'installation](https://docs.docker.com/desktop/install/windows-install/).

2. Pour confirmer la bonne installation de Docker, nous pouvons lancer la commande :

```
docker run hello-world 
```

Celle-ci nous confirme la bonne installation de Docker et nous montre les différentes étapes réalisées suite à la commande docker run.

#### 2.2.1 WSL

Lors de l'installation de Docker sur Windows, Docker Desktop utilise Windows Subsystem for Linux (WSL) pour exécuter les conteneurs Linux. WSL est une fonctionnalité de Windows 10 qui permet d'exécuter un environnement Linux directement sur un système Windows, sans nécessiter de machine virtuelle.

Voici une explication plus détaillée sur WSL :

##### Windows Subsystem for Linux (WSL)

##### Qu'est-ce que WSL?

WSL est une fonctionnalité de Windows 10 qui permet d'exécuter un sous-système Linux directement sur une machine Windows. Il fournit un environnement d'exécution Linux complet, permettant d'exécuter des binaires Linux, des commandes et même des applications en ligne de commande directement sur Windows.

##### Comment fonctionne WSL?

WSL utilise une architecture de traduction de syscall pour permettre aux applications Linux de s'exécuter sur le noyau Windows. Il ne s'agit pas d'une machine virtuelle traditionnelle, mais plutôt d'une couche d'émulation qui offre une compatibilité élevée entre les commandes Linux et les outils de développement.

##### Avantages de WSL pour Docker

1. **Intégration Transparente**: Permet d'exécuter des conteneurs Linux directement sur Windows sans nécessiter de machine virtuelle distincte.

2. **Performances Améliorées**: Les performances sont généralement meilleures par rapport à d'autres solutions de virtualisation, car WSL partage le noyau avec Windows.

3. **Interopérabilité**: Facilite l'intégration et l'interaction entre les outils Windows et Linux.

4. **Développement Croisé**: Permet aux développeurs de travailler avec des outils et des environnements de développement Linux tout en restant sur Windows.

##### Comment Docker utilise WSL?

Lorsque Docker Desktop est installé sur Windows, il configure automatiquement WSL pour exécuter les conteneurs Linux. Cela permet aux développeurs d'utiliser des images Docker Linux sans avoir à utiliser une machine virtuelle dédiée.

L'utilisation de WSL avec Docker sur Windows simplifie le développement et le déploiement d'applications basées sur des conteneurs, en fournissant un environnement Linux cohérent et intégré sur une plate-forme Windows.

[Installation de WSL](https://learn.microsoft.com/fr-fr/windows/wsl/install)

Verifier si WSL est installe sur votre poste :

```
wsl -l -v
```

## Lexique

- **Démon Docker**: Processus en arrière-plan gérant la création, l'exécution et la gestion des conteneurs.
- **Registre Docker**: Répertoire centralisé pour stocker et partager des images Docker.
- **Image Docker**: Modèle léger permettant de créer des conteneurs Docker.
- **Conteneur Docker**: Instance exécutable d'une image Docker.
- **Dockerfile**: Script texte spécifiant les étapes pour créer une image Docker.

## Liens Utiles

1. [Documentation officielle Docker](https://docs.docker.com/)
2. [Tutoriels Docker sur Docker Hub](https://hub.docker.com/)
3. [Forum Docker](https://forums.docker.com/)
4. [Stack Overflow - Questions Docker](https://stackoverflow.com/questions/tagged/docker)
5. [Docker Cheat Sheet](https://www.docker.com/sites/default/files/d8/2019-09/docker-cheat-sheet.pdf) - Référence rapide des commandes Docker.

Après avoir suivi ces étapes d'installation, vous êtes prêt à plonger dans l'univers de Docker et à explorer ses fonctionnalités avancées.


# Gestion des Erreurs Courantes lors de l'Installation de Docker

L'installation de Docker peut parfois rencontrer des problèmes courants. Voici quelques erreurs fréquemment rencontrées et leurs solutions potentielles:

## 1. Problèmes d'autorisation

### Symptômes:
L'utilisateur n'a pas les autorisations nécessaires pour exécuter des commandes Docker.

### Solutions:
- Assurez-vous d'être membre du groupe Docker (sur Linux).
- Utilisez `sudo` pour les commandes Docker sur Linux si l'utilisateur n'est pas dans le groupe Docker.
- Sur Windows, exécutez Docker Desktop en tant qu'administrateur.

## 2. Problèmes de Virtualisation

### Symptômes:
Les problèmes liés à la virtualisation empêchent le démarrage des conteneurs.

### Solutions:
- Activez la virtualisation dans le BIOS/UEFI de votre machine.
- Sur Windows, assurez-vous que Hyper-V est activé dans les fonctionnalités Windows.

## 3. Problèmes de Connexion au Registre Docker

### Symptômes:
Échec de la connexion au registre Docker lors du téléchargement des images.

### Solutions:
- Vérifiez votre connexion Internet.
- Si vous utilisez un proxy, configurez Docker pour l'utiliser via les paramètres système.

## 4. Espace Disque Insuffisant

### Symptômes:
Manque d'espace disque lors du téléchargement d'images.

### Solutions:
- Libérez de l'espace disque en supprimant des images et des conteneurs inutilisés.
- Changez le répertoire de stockage Docker vers un autre emplacement avec plus d'espace.

## 5. Problèmes de Version

### Symptômes:
Les versions incompatibles de Docker et Docker Compose peuvent entraîner des erreurs.

### Solutions:
- Assurez-vous que les versions de Docker et Docker Compose sont compatibles.
- Consultez la documentation officielle pour connaître les versions recommandées.

## 6. Échec de l'Installation sur Windows

### Symptômes:
Des problèmes spécifiques à l'installation de Docker Desktop sur Windows.

### Solutions:
- Consultez les forums Docker pour des solutions spécifiques aux problèmes Windows.
- Assurez-vous que les prérequis de Windows sont satisfaits.

En cas de problèmes persistants, référez-vous à la [documentation officielle de Docker](https://docs.docker.com/) et aux forums communautaires pour obtenir une assistance supplémentaire.
