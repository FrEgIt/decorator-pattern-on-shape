all: compiler
doc: documentation  
zip: tape
clean: nettoyer
compiler: 
	javac -encoding UTF-8  **/*.java
nettoyer: 
	rm -r **/*.class
documentation: 
	javadoc -encoding UTF-8 -charset UTF-8 -docencoding UTF-8 -d javadoc/ **/*.java
tape:
	zip -9 -r decorator-pattern-on-shape.zip *
launch:
        java Main.main
