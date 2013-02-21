@echo off
:: Executar com o JBoss AS ja iniciado
echo.
echo *******************************************************************************
echo Agenda de Contatos
echo *******************************************************************************
echo.
call mvn clean compile package install
cd agenda-web
call mvn jboss-as:deploy
echo.
echo A aplicacao ja pode ser acessada pelo endereco http://localhost:8080/agenda/
pause