#!/bin/bash
# Executar com o JBoss AS ja iniciado
echo "*******************************************************************************"
echo "Exemplo 07 - Servidor"
echo -e "*******************************************************************************\n"
mvn clean install
mvn jboss-as:deploy