echo "GENERATING ARCHIVES FOR LEXER AND PARSER FOR READ JSON"
echo "------> deleting files on project AppClient"
rm -rf ../../AppClient/src/main/java/Back/Analizers/JSON/LexerJSON.java 
echo "------> compiling .jflex files"
jflex LexerJSON.jflex
echo "------> moving new .jflex files to /LexerJSON/"
mv .java LexerJSON.java ../../AppClient/src/main/java/Back/Analizers/JSON
echo "GENERATING PARSERS AND SYM TABLE" 
echo "------> deleting files on /Parser/"
rm -rf ../../AppClient/src/main/java/Back/Analizers/JSON/SintacticJSON.java ../../AppClient/src/main/java/Back/Analizers/JSON/symJSON.java
echo "------> compiling .cup file"
cup -parser SintacticJSON -symbols symJSON SintacticJSON.cup 
echo "------> moving new .java files to /Parser/"
mv SintacticJSON.java symJSON.java ../../AppClient/src/main/java/Back/Analizers/JSON/
