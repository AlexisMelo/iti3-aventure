#!/bin/bash

sh compiler.sh

cd classes
hamcrestjar="hamcrest-core-1.3.jar"
junitjar="junit-4.13.jar"

orgdir="org"
junitdir="junit"

if [ ! -d $orgdir ]
then
  echo "$orgdir existe pas"
  jar xvf ../$hamcrestjar
fi

if [ ! -d $junitdir ]
then
  echo "$junitdir existe pas"
  jar xvf ../$junitjar
fi

cd ..
#compilation test Entite
javac -classpath classes -sourcepath ./src -d ./classes ./src/fr/insarouen/asi/asiaventure/tests/*.java

java -classpath classes fr.insarouen.asi.asiaventure.tests.TestRunner
