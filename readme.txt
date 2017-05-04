201710_CSOF5101_01 - CONCEPTOS AVANZADOS DE INGENIERÍA DE SOFTWARE
Tarea 7 - Programa 7, correlación, significancia, regresión e intervalo de preddicón 70%
JUAN PABLO OSPINO SOLANO
20170501
repositorio: https://github.com/jpospino/tarea7.git

0. Clonar el repositorio
para clonar ejecute el siguiente comando en DOS
 	
	git clone https://github.com/jpospino/tarea7.git
	
a continuación vaya a la ruta de las fuentes con el siguiente comando
	
	cd tarea6\src\tarea7\

1. Compilación en maven
ubicado en la ruta donde se encuenrtan las fuentes ejecute los siguientes comandos para compilar

	mvn clean
	mvn package

también puede compilar utilizando el siguiente comando como lo sugiere heroku
	
	mvn clean install

y el comando para correr local:
	
	heroku local web

y en un navegador web o un cliente de servicios rest como Postman enviar el siguiente request

	http://localhost:5000/calculoCorrelacionSignificancia?tablaValor=[{ programID: 1, estimatedProxySize: 130, planAddedModifiedSize: 163, actualAddedModifiedSize: 186, actualDevelopmentTime: 15.000000 },{ programID: 2, estimatedProxySize: 650, planAddedModifiedSize: 765, actualAddedModifiedSize: 699, actualDevelopmentTime: 69.900000 },{ programID: 3, estimatedProxySize: 99, planAddedModifiedSize: 141, actualAddedModifiedSize: 132, actualDevelopmentTime: 6.500000 },{ programID: 4, estimatedProxySize: 150, planAddedModifiedSize: 166, actualAddedModifiedSize: 272, actualDevelopmentTime: 22.400000 },{ programID: 5, estimatedProxySize: 128, planAddedModifiedSize: 137, actualAddedModifiedSize: 291, actualDevelopmentTime: 28.400000 },{ programID: 6, estimatedProxySize: 302, planAddedModifiedSize: 35, actualAddedModifiedSize: 331, actualDevelopmentTime: 65.900000 },{ programID: 7, estimatedProxySize: 95, planAddedModifiedSize: 136, actualAddedModifiedSize: 199, actualDevelopmentTime: 19.400000 },{ programID: 8, estimatedProxySize: 945, planAddedModifiedSize: 1206, actualAddedModifiedSize: 1890, actualDevelopmentTime: 198.700000 },{ programID: 9, estimatedProxySize: 368, planAddedModifiedSize: 433, actualAddedModifiedSize: 788, actualDevelopmentTime: 38.800000 },{ programID: 10, estimatedProxySize: 961, planAddedModifiedSize: 1130, actualAddedModifiedSize: 1601, actualDevelopmentTime: 138.200000 }]&tipoCalculo=EPSADT&tamanhoProxy=386
	
se adjunta dentro de las carpeta de test el resultado de la compilación y pruebas unitarias ver test1.txt, test2.txt, test3.txt y test4.txt.


2. Acceso a heroku


el programa está publicado en heroku como un servicio REST para su ejecución. 
puede ver los archivo test1.txt, test2.txt, test3.txt y test4.txt. en ellos copie la url y navegela en un browser.


cambie los parametros segun los valores que se quiera introducir
tablaValor
tipoCalculo
tamanhoProxy

3. Accesos a JAVADOC
Entre a la ruta src/tarea7/target/site/apidocs/index.html


***************************************