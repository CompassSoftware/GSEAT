#makefile for Selection team
#
#version: Fall 2019
#
#author: Yuanbo Zhou
#

JUNIT5_JAR = junit-platform-console-standalone-1.2.0.jar
JUNIT5_RUNNER = org.junit.platform.console.ConsoleLauncher
CKSTYLE_COMMAND =  -jar /usr/local/checkstyle-5.5/checkstyle-5.5-all.jar
CKSTYLE_XML = cs_appstate_checks.xml

default: 
	@echo "usage: make target"
	@echo "example: make helo"
	@echo "example: make targetlist"
targetlist:
	@echo "7 available targets: clean - removes editor tmpfiles and .class files"
	@echo "____________________ compile, test - builds JUnit5 tests, runs all (4 and 5)"
	@echo "____________________ compile4, test4 - builds/runs JUnit4 tests"
	@echo "____________________ defchk, customchk - default or custom checkstyle"
help:
	@echo "Just starting with make? Try these 4 make commands successively:"
	@echo "________ make clean ; make compile ; make test ; make defchk"

compile: Selection.java SelectionTest.java $(JUNIT5_JAR)
		javac -cp .:$(JUNIT5_JAR) SelectionTest.java
		javac Selection.java
		javac TestData/Comment.java
		javac TestData/MakeshiftExtraction.java
		javac TestData/Issue.java
clean:
		rm -f *~
		rm -f Selection*.class
		rm -f TestData *.class

test: $(JUNIT5_JAR)
		java -cp .:$(JUNIT5_JAR) $(JUNIT5_RUNNER) --scan-class-path

