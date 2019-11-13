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
# Package for json.jar running in GitUser.java
JSON_JAR = json-lib-2.4-jdk15.jar
EZMORPH_JAR = ezmorph-1.0.6.jar
COMMONS_LOGGING_JAR = commons-logging-1.1.1.jar
COMMONS_LANG_JAR = commons-lang-2.6.jar
COMMONS_COLLECTION_JAR = commons-collections-3.2.1.jar
COMMONS_BEANUTILS_JAR = commons-beanutils-1.8.3.jar

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
	make compile
	make test

compile:
	make extract
	make collab
	make commit
	make repo
	make issue
	make comment

compile2: Extraction.java $(JSON_JAR) $(EZMORPH_JAR) $(COMMONS_LOGGING_JAR) $(COMMONS_LANG_JAR) $(COMMONS_COLLECTION_JAR) $(COMMONS_BEANUTILS_JAR)
	javac -cp .:$(JSON_JAR):$(EZMORPH_JAR):$(COMMONS_LOGGING_JAR):$(COMMONS_LANG_JAR):$(COMMONS_COLLECTION_JAR):$(COMMONS_BEANUTILS_JAR) Extraction.java
	java -cp .:$(JSON_JAR):$(EZMORPH_JAR):$(COMMONS_LOGGING_JAR):$(COMMONS_LANG_JAR):$(COMMONS_COLLECTION_JAR):$(COMMONS_BEANUTILS_JAR) Extraction

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

