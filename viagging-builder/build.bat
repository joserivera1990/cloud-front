@echo off
echo 1. Pre-procesador
java -jar viagging-builder.jar
pause

echo 2. Eliminando archivos desactualizados
del /s /q deploy\*.*
cd..
del /s /q viagging-admin-web\target\*.*
del /s /q viagging-providers-web\target\*.*
del /s /q viagging-api\target\*.*
del /s /q viagging-api-report\target\*.*
del /s /q viagging-api-weather\target\*.*
del /s /q viagging-api-message\target\*.*
del /s /q viagging-market-place-web\target\*.*
pause

echo 3. Ejecutando Maven
start mvn clean install
pause

echo 4. Copiando archivos de despliegue
xcopy /s viagging-admin-web\target\viagging-admin-web.war viagging-builder\deploy\
xcopy /s viagging-providers-web\target\viagging-providers-web.war viagging-builder\deploy\
xcopy /s viagging-api\target\viagging-api.war viagging-builder\deploy\
xcopy /s viagging-api-report\target\viagging-api-report.war viagging-builder\deploy\
xcopy /s viagging-api-weather\target\viagging-api-weather.war viagging-builderr\deploy\
xcopy /s viagging-api-message\target\viagging-api-message.war viagging-builder\deploy\
xcopy /s viagging-market-place-web\target\viagging-market-place-web.war viagging-builder\deploy\

echo Proceso finalizado

