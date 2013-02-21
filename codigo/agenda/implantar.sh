#!/bin/bash
# Executar com o JBoss AS ja iniciado
echo "*******************************************************************************"
echo "Agenda de Contatos"
echo -e "*******************************************************************************\n"
mvn clean compile package install
cd agenda-web
mvn jboss-as:deploy
echo -e "\nA aplicacao ja pode ser acessada pelo endereco http://localhost:8080/agenda/"