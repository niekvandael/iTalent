@ECHO OFF
cd %1
mvn spring-boot:run ^> ../logs/%1.txt