#compilation fichiers dans package asiaventure
javac -classpath ./classes -sourcepath ./src -d ./classes ./src/fr/insarouen/asi/asiaventure/*.java

#compilation fichiers dans elements
javac -classpath ./classes -sourcepath ./src  -d ./classes ./src/fr/insarouen/asi/asiaventure/elements/*.java

#compilation fichiers dans objet
javac -classpath ./classes -sourcepath ./src  -d ./classes ./src/fr/insarouen/asi/asiaventure/elements/objets/*.java

#compilation fichiers dans serrurerie
javac -classpath ./classes -sourcepath ./src  -d ./classes ./src/fr/insarouen/asi/asiaventure/elements/objets/serrurerie/*.java

#compilation fichiers dans structure
javac -classpath ./classes -sourcepath ./src  -d ./classes ./src/fr/insarouen/asi/asiaventure/elements/structure/*.java

#compilation fichiers dans vivants
javac -classpath ./classes -sourcepath ./src  -d ./classes ./src/fr/insarouen/asi/asiaventure/elements/vivants/*.java
