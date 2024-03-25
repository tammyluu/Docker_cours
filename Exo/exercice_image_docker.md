
**Exercice : Gestion d'images Docker**

En ligne de commande on souhaite :

1. **Téléchargement d'une image :**
   - Recherchez et téléchargez l'image Docker officielle pour le serveur web Nginx.
    => docker pull nginx

2. **Liste d'images :**
   - Affichez la liste des images Docker présentes sur votre machine.
   => docker images

3. **Suppression d'une image :**
   - Supprimez l'image Nginx que vous venez de télécharger de votre machine.
   => docker image rm nginx

4. **Téléchargement de plusieurs images :**
   - Téléchargez les images Docker officielles pour MySQL et Redis sur votre machine.
   => docker pull mysql
      docker pull redis

5. **Liste d'images après téléchargement :**
   - Affichez à nouveau la liste des images Docker sur votre machine pour vérifier que les images de MySQL et Redis ont été téléchargées avec succès.
  =>  docker images

6. **Affichage détaillé d'une image :**
   - Affichez les détails (metadata) de l'image Mysql que vous avez téléchargée précédemment.
      => docker image inspect mysql
7. **Historique d'une image :**
   - Affichez l'historique de l'image MySQL pour voir les différentes "couches" qui la composent.
   => docker history mysql

8. **Recherche d'images :**
   - Rechercher une image Docker liée à un service ou une technologie de votre choix. 
   => docker search database
   => docker search wordpress
   Choisissez une image intéressante et affichez quelques informations à son sujet.
   => docker pull wordpress
   => docker image inspect wordpress

Cet exercice devrait vous permettre de vous familiariser avec la manipulation d'images Docker à un niveau basique. N'hésitez pas à consulter la documentation Docker au besoin.



