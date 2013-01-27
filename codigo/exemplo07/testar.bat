@echo off
echo.
echo *******************************************************************************
echo Exemplo 07
echo *******************************************************************************
echo.
cd servidor
call mvn clean install
call mvn jboss-as:deploy
cd ../cliente
call mvn clean compile
call mvn exec:java
pause