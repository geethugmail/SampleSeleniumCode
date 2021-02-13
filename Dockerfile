FROM markhobson/maven-chrome:jdk-8

ENV HOME=/home/seluser

USER root

USER 1001
WORKDIR $HOME
