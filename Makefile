# Ensimag 2A POO - TP 2015/16
# ============================
#
# Ce Makefile permet de compiler le test de l'ihm en ligne de commande.
# Alternative (recommandee?): utiliser un IDE (eclipse, netbeans, ...)
# Le but est d'illustrer les notions de "classpath", a vous de l'adapter
# a votre projet.
#
# Organisation:
#  1) Les sources (*.java) se trouvent dans le repertoire src
#     Les classes d'un package toto sont dans src/toto
#     Les classes du package par defaut sont dans src
#
#  2) Les bytecodes (*.class) se trouvent dans le repertoire bin
#     La hierarchie des sources (par package) est conservee.
#     Pour un package (ici gui.jar), il est aussi dans bin.
#
# Compilation:
#  Options de javac:
#   -d : repertoire dans lequel sont places les .class compiles
#   -classpath : repertoire dans lequel sont cherches les .class deja compiles
#   -sourcepath : repertoire dans lequel sont cherches les .java (dependances)

all: testGUI TestGrilleConway TestGrilleSimulator TestGrilleSchelling TestGrilleImmigration TestBoidsSimulator

testGUI:
	javac -d bin -classpath bin/gui.jar -sourcepath src src/TestGUI.java


# Execution:
# on peut taper directement la ligne de commande :
#   > java -classpath bin TestGUI
# ou bien lancer l'execution en passant par ce Makefile:
#   > make exeIHM
exeGUI:
	java -classpath bin:bin/gui.jar TestGUI

# A servi pendant les tests:
TestGrilleSimulator:
	javac -d bin -classpath bin:bin/gui.jar -sourcepath src src/conway/TestGrilleSimulator.java

exeGrilleSimulator:
	java -classpath bin:bin/conway:bin/gui.jar conway.TestGrilleSimulator

# Pour faire rebondir les balles:
TestBallsSimulator:
	javac -d bin -classpath bin:bin/gui.jar -sourcepath src src/TestBallsSimulator.java

exeBallsSimulator:
	java -classpath bin:bin/gui.jar TestBallsSimulator

# Pour tester le jeu de la vie:
TestGrilleConway:
	javac -d bin -classpath bin:bin/gui.jar -sourcepath src src/conway/TestGrilleConway.java

exeGrilleConway:
	java -classpath bin:bin/conway:bin/gui.jar conway.TestGrilleConway

# Pour le modèle de l'immigration:
TestGrilleImmigration:
	javac -d bin -classpath bin:bin/gui.jar -sourcepath src src/conway/TestGrilleImmigration.java

exeGrilleImmigration:
	java -classpath bin:bin/conway:bin/gui.jar conway.TestGrilleImmigration

#Pour le modèle de Schelling:
TestGrilleSchelling:
	javac -d bin -classpath bin:bin/gui.jar -sourcepath src src/conway/TestGrilleSchelling.java

exeGrilleSchelling:
	java -classpath bin:bin/conway:bin/gui.jar conway.TestGrilleSchelling

TestBoidsSimulator:
	javac -d bin -classpath bin:bin/gui.jar -sourcepath src src/boids/TestBoidsSimulator.java

exeBoidsSimulator:
	java -classpath bin:bin/boids:bin/gui.jar boids.TestBoidsSimulator



clean:
	rm -rf bin/*.class
