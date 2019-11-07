#
# makefile 
#
# input file for 'make' build tool ( /usr/bin/make )
# to build solution for JUnit sample
#
# @author CS5666
# @version Fall 2019
#

HAMCREST_JAR = /usr/share/java/hamcrest/core-1.1.jar
JUNIT5_JAR = junit-platform-console-standalone-1.2.0.jar 
JUNIT5_RUNNER = org.junit.platform.console.ConsoleLauncher
CKSTYLE_COMMAND =  -jar /usr/local/checkstyle-5.5/checkstyle-5.5-all.jar
CKSTYLE_XML = cs_appstate_checks.xml

default: 
	@echo "usage: make target"
	@echo "targets available:"
	@echo "____ clean-all, clean-extract, clean-selection, clean-analysis"

# makefile syntax
#target-name: files dependent on (can use multiple lines by ending
#             lines with \
#<TAB char>Unix command-line command
#<TAB char>Unix command-line command
#etc.
#Essential that command lines start with single TAB character

######################################################################
# Dr. Fenwick worked on below to show one way to have a top-level
# makefile that can build parts or all. Need some actual "rm" commands
# to remove backup files, class files, etc.
######################################################################
clean-all:
	@echo "cleaning all"
	@make --silent clean-extract
	@make --silent clean-selection
	@make --silent clean-analysis

clean-extract:
	@echo "cleaning extract/"

clean-analysis:
	@echo "cleaning analysis/"

clean-selection:
	@echo "cleaning selection/"

######################################################################
######################################################################
run:
	make compile
	make test

compile:
	make extract
	make collab
	make commit
	make repo
	make issue
	make comment


extract: Extraction.java ExtractionTest.java $(JUNIT5_JAR)
	javac -cp .:$(JUNIT5_JAR) ExtractionTest.java
	javac Extraction.java

collab:	Collaborator.java CollaboratorTest.java $(JUNIT5_JAR)
	javac -cp .:$(JUNIT5_JAR) CollaboratorTest.java
	javac Collaborator.java

commit:	Commit.java CommitTest.java $(JUNIT5_JAR)
	javac -cp .:$(JUNIT5_JAR) CommitTest.java
	javac Commit.java
    
issue: Issue.java IssueTest.java $(JUNIT5_JAR)
	javac -cp .:$(JUNIT5_JAR) IssueTest.java
	javac Issue.java
    
comment: Comment.java CommentTest.java $(JUNIT5_JAR)
	javac -cp .:$(JUNIT5_JAR) CommentTest.java
	javac Comment.java

repo: Repository.java RepoTest.java $(JUNIT5_JAR)
	javac -cp .:$(JUNIT5_JAR) RepoTest.java
	javac Repository.java

clean:
	rm -f *~
	rm -f Extraction*.class

test: $(JUNIT5_JAR)
	java -cp .:$(JUNIT5_JAR) $(JUNIT5_RUNNER) --scan-class-path 

defchk: Extraction.java $(CKSTYLE_XML)
#	checkstyle Calculator.java
	java $(CKSTYLE_COMMAND) -c $(CKSTYLE_XML) Extraction.java

customchk: Extraction.java style.xml
	java $(CKSTYLE_COMMAND) -c style.xml Extraction.java

style.xml:
	@echo "Custom checkstyle needs a local style.xml file."
	@echo "Copy cs_appstate_checks.xml into style.xml and edit as needed."
	@echo "--------------------------------------------------------------"

