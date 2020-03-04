#!/bin/bash

sh compiler.sh

#compilation tests
#javac -classpath classestest:/usr/share/java/junit4.jar:classes:/usr/share/java/hamcrest-library.jar -sourcepath ./srctest -d ./classestest ./srctest/*.java

#compilation tests element
javac -classpath /usr/share/java/junit4.jar:classes:/usr/share/java/hamcrest-library.jar -sourcepath ./srctest -d ./classestest ./srctest/fr/insarouen/asi/prog/asiaventure/elements/*.java

#compilation alltests
javac -classpath /usr/share/java/junit4.jar:classes:/usr/share/java/hamcrest-library.jar -sourcepath ./srctest -d ./classestest ./srctest/*.java

#java -classpath classestest:/usr/share/java/junit4.jar:classes:/usr/share/java/hamcrest-library.jar AllTests

java -classpath /usr/share/java/junit4.jar:classestest:classes org.junit.runner.JUnitCore AllTests
