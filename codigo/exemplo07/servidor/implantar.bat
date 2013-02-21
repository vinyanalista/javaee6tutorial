@echo off
:: Executar com o JBoss AS ja iniciado
echo.
echo *******************************************************************************
echo Exemplo 07 - Servidor
echo *******************************************************************************
echo.
call mvn clean install
call mvn jboss-as:deploy
pause