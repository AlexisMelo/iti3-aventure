sh compiler.sh

#compilation fichiers tests
javac -classpath ./classes -sourcepath ./src -d ./classes ./src/fr/insarouen/asi/testsUnitaires/*.java

java -classpath classes fr.insarouen.asi.testsUnitaires.MainTests
