#!/bin/bash
# Executar com o JBoss AS ja iniciado
echo "*******************************************************************************"
echo "Exemplo 08"
echo -e "*******************************************************************************\n"
mvn clean compile package jboss-as:deploy
echo -e "\nA aplicacao ja pode ser acessada pelo endereco http://localhost:8080/exemplo08/"