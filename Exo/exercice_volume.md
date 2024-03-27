
    1. Créer un serveur-web avec un site web personnalisé qui utilisera comme technologie apache
    2. En suite, le modifier finalement déployer avec techno nginx mais toujours le meme site web (utiliser volume qui persistent data à part)
docker volume ls
docker volume create mywebsite 
docker volume ls
docker run -v mywebsite:/root -it httpd
docker run -d -p 80:80 --name myserverweb httpd
docker exec -it myserverweb sh
docker cp D:\01_ENV\WorkSpace\Docker_cours\Exo\files_tp_conteneur\html5up-massively.zip myserverweb:/root
docker ps
docker stop myserverweb
docker rm myserverweb
docker run -v mysiteweb:/root -it nginx
docker run -d -p 80:80 --name mynewserver httpd
docker exec -it mynewserver bash
cd /root
ls
html5up-massively.zip
apt upgrade
apt update
apt install unzip
unzip html5up-massively -d.
exit   