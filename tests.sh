sh compiler.sh

#compilation test Entite
javac -classpath ./classes -sourcepath ./src -d ./classes ./src/fr/insarouen/asi/asiaventure/tests/*.java

java -classpath classes fr.insarouen.asi.asiaventure.MainTest
