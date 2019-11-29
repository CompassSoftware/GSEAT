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
# Package for json.jar running in GitUser.java
JSON_JAR = json-lib-2.4-jdk15.jar
EZMORPH_JAR = ezmorph-1.0.6.jar
COMMONS_LOGGING_JAR = commons-logging-1.1.1.jar
COMMONS_LANG_JAR = commons-lang-2.6.jar
COMMONS_COLLECTION_JAR = commons-collections-3.2.1.jar
COMMONS_BEANUTILS_JAR = commons-beanutils-1.8.3.jar

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
	make -f makefile_ext clean_ext

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
	make -f makefile_ext compile_ext
	make compile_analysis

compile2:
	make -f makefile_ext compile2

compile_analysis: analysis/Analysis.java analysis/AnalysisTest.java $(JUNIT5_JAR)
	javac analysis/Analysis.java
	javac -cp .:$(JUNIT5_JAR) analysis/AnalysisTest.java

compileExtractionDemo: extraction/Extraction.java Extraction_Demo.java $(JSON_JAR) $(EZMORPH_JAR) $(COMMONS_LOGGING_JAR) $(COMMONS_LANG_JAR) $(COMMONS_COLLECTION_JAR) $(COMMONS_BEANUTILS_JAR)
	javac -cp .:$(JSON_JAR):$(EZMORPH_JAR):$(COMMONS_LOGGING_JAR):$(COMMONS_LANG_JAR):$(COMMONS_COLLECTION_JAR):$(COMMONS_BEANUTILS_JAR) extraction/Extraction.java Extraction_Demo.java
	java -cp .:$(JSON_JAR):$(EZMORPH_JAR):$(COMMONS_LOGGING_JAR):$(COMMONS_LANG_JAR):$(COMMONS_COLLECTION_JAR):$(COMMONS_BEANUTILS_JAR) Extraction_Demo

clean:
	rm -f analysis/*.class
	make -f makefile_ext clean_ext

test:
	make -f makefile_ext test_ext

defchk:
	make -f makefile_ext defchk_ext

customchk:
	make -f makefile_ext customchk_ext
