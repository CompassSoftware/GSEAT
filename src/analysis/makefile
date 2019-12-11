JUNIT5_JAR = junit-platform-console-standalone-1.2.0.jar 
JUNIT5_RUNNER = org.junit.platform.console.ConsoleLauncher
CKSTYLE_XML = cs_appstate_checks.xml
CKSTYLE_COMMAND =  @-jar /usr/local/checkstyle-5.5/checkstyle-5.5-all.jar

default: 
	@echo "4 available targets: clean - removes editor tmpfiles and .class files"
	@echo "____________________ compile, test - builds JUnit5 tests"
	@echo "____________________ chk runs checkstyle"

# makefile syntax
#target-name: files dependent on (can use multiple lines by ending
#             lines with \
#<TAB char>Unix command-line command
#<TAB char>Unix command-line command
#etc.
#Essential that command lines start with single TAB character

compile: Analysis.java AnalysisTest.java $(JUNIT5_JAR)
	@javac github/*.java
	@javac Analysis.java
	@javac Demo.java
	@javac -cp .:$(JUNIT5_JAR) AnalysisTest.java

clean:
	rm -f *~
	rm -f TestData/*.class
	rm -f Analysis*.class
	rm -f Demo.class

test: $(JUNIT5_JAR)
	@java -cp .:$(JUNIT5_JAR) $(JUNIT5_RUNNER) --scan-class-path 

chk: Analysis.java style.xml
	@java $(CKSTYLE_COMMAND) -c style.xml Analysis.java
	@java $(CKSTYLE_COMMAND) -c style.xml Demo.java

demo: Demo.java
	@java Demo

