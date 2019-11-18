#
# makefile 
#
# input file for 'make' build tool ( /usr/bin/make )
# to build solution for JUnit sample
#
# @author Dr. Fenwick
# @version Summer 2018
#

HAMCREST_JAR = /usr/share/java/hamcrest/core-1.1.jar
JUNIT5_JAR = junit-platform-console-standalone-1.2.0.jar 
JUNIT5_RUNNER = org.junit.platform.console.ConsoleLauncher
CKSTYLE_COMMAND =  -jar /usr/local/checkstyle-5.5/checkstyle-5.5-all.jar
CKSTYLE_XML = cs_appstate_checks.xml

default: 
	@echo "usage: make target"
	@echo "7 available targets: clean - removes editor tmpfiles and .class files"
	@echo "____________________ compile, test - builds JUnit5 tests, runs all (4 and 5)"
	@echo "____________________ defchk, customchk - default or custom checkstyle"
	@echo "Just starting with make? Try these 4 make commands successively:"
	@echo "________ make clean ; make run (make compile ; make test) ; make defchk"

# makefile syntax
#target-name: files dependent on (can use multiple lines by ending
#             lines with \
#<TAB char>Unix command-line command
#<TAB char>Unix command-line command
#etc.
#Essential that command lines start with single TAB character

run:
	make extraction_package

extraction_package:
	make compile
	make test

compile:
	make extract
	make collab
	make commit
	make repo
	make issue
	make comment

extract: extraction/Extraction.java extraction/ExtractionTest.java $(JUNIT5_JAR)
	javac extraction/Extraction.java
	javac -cp .:$(JUNIT5_JAR) extraction/ExtractionTest.java

collab:	extraction/Collaborator.java extraction/CollaboratorTest.java $(JUNIT5_JAR)
	javac extraction/Collaborator.java
	javac -cp .:$(JUNIT5_JAR) extraction/CollaboratorTest.java

commit:	extraction/Commit.java extraction/CommitTest.java $(JUNIT5_JAR)
	javac extraction/Commit.java
	javac -cp .:$(JUNIT5_JAR) extraction/CommitTest.java
    
issue: extraction/Issue.java extraction/IssueTest.java $(JUNIT5_JAR)
	javac extraction/Issue.java
	javac -cp .:$(JUNIT5_JAR) extraction/IssueTest.java

comment: extraction/Comment.java extraction/CommentTest.java $(JUNIT5_JAR)
	javac extraction/Comment.java
	javac -cp .:$(JUNIT5_JAR) extraction/CommentTest.java

repo: extraction/Repository.java extraction/RepoTest.java $(JUNIT5_JAR)
	javac extraction/Repository.java
	javac -cp .:$(JUNIT5_JAR) extraction/RepoTest.java

clean:
	rm -f *~
	rm -f extraction/*.class

test: $(JUNIT5_JAR)
	java -cp .:$(JUNIT5_JAR) $(JUNIT5_RUNNER) --scan-class-path 

defchk: extraction/*.java $(CKSTYLE_XML)
#	checkstyle Calculator.java
	java $(CKSTYLE_COMMAND) -c $(CKSTYLE_XML) extraction/Extraction.java extraction/Collaborator.java extraction/Commit.java extraction/Issue.java extraction/Comment.java extraction/Repository.java

customchk: extraction/*.java style.xml
	java $(CKSTYLE_COMMAND) -c style.xml extraction/Extraction.java extraction/Collaborator.java extraction/Commit.java extraction/Issue.java extraction/Comment.java extraction/Repository.java

style.xml:
	@echo "Custom checkstyle needs a local style.xml file."
	@echo "Copy cs_appstate_checks.xml into style.xml and edit as needed."
	@echo "--------------------------------------------------------------"

