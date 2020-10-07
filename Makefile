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
	java main impl_input.txt

test2:	main.class
	java main impl_additional.txt

testcase1:	main.class
	java main testcase1.txt

testcase2:	main.class
	java main testcase2.txt

testcase3:	main.class
	java main testcase3.txt
	
testcase4:	main.class
	java main testcase4.txt
	
testcase5:	main.class
	java main testcase5.txt

testcaseall:	testcase1 testcase2 testcase3 testcase4 testcase5

tree:	$(GENERATED) impl.g4
	javac $(GENERATED)
	$(grun) impl start -tree -gui < impl_input.txt
