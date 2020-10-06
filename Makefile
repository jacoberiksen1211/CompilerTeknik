ANTLRJAR = C:\Javalib\antlr-4.7.1-complete.jar
antlr4 = java -jar $(ANTLRJAR)
grun   = java org.antlr.v4.gui.TestRig

SRCFILES = main.java Environment.java
GENERATED = implParser.java implBaseVisitor.java implVisitor.java implLexer.java

all:
	make main.class

main.class:	$(SRCFILES) $(GENERATED) impl.g4
	javac  $(SRCFILES) $(GENERATED)

implParser.java:	impl.g4
	$(antlr4) -visitor impl.g4

test:	main.class
	java main impl_additional.txt

tree:	$(GENERATED) impl.g4
	javac $(GENERATED)
	$(grun) impl start -tree -gui < impl_additional.txt
