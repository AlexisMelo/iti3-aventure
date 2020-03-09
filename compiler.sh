#compilation fichiers dans package asiaventure
javac  -classpath ./classes -sourcepath ./src -d ./classes ./src/fr/insarouen/asi/prog/asiaventure/*.java

#compilation fichiers dans elements
javac  -classpath ./classes -sourcepath ./src  -d ./classes ./src/fr/insarouen/asi/prog/asiaventure/elements/*.java

#compilation fichiers dans objet
javac  -classpath ./classes -sourcepath ./src  -d ./classes ./src/fr/insarouen/asi/prog/asiaventure/elements/objets/*.java

#compilation fichiers dans serrurerie
javac -Xlint -classpath ./classes -sourcepath ./src  -d ./classes ./src/fr/insarouen/asi/prog/asiaventure/elements/objets/serrurerie/*.java

#compilation fichiers dans structure
javac  -classpath ./classes -sourcepath ./src  -d ./classes ./src/fr/insarouen/asi/prog/asiaventure/elements/structure/*.java

#compilation fichiers dans vivants
javac  -classpath ./classes -sourcepath ./src  -d ./classes ./src/fr/insarouen/asi/prog/asiaventure/elements/vivants/*.java
