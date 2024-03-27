FROM nginx
LABEL version="1.0"
MAINTAINER  TAMMY_LUU
WORKDIR /usr/share/nginx/html/

# nettoyage s'il existe fichier index.html. Mais éviter d'utiliser. C'est danger.
RUN rm -f ./*
RUN apt update && apt install -y git
# on a workdir => . à la fin
RUN git clone https://github.com/withaarzoo/3D-Rotate-Tube.git .
#RUN git clone https://github.com/withaarzoo/3D-Rotate-Tube.git ./root
# RUN git clone https://github.com/tammyluu/TP-react-pokemon.git

EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]

# docker build -t exo2 .

# docker run -p 3003:80 -d exo2