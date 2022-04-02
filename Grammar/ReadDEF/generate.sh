echo "GENERATING ARCHIVES FOR LEXER AND PARSER FOR READ DEF"
echo "------> deleting files on project AppClient"
rm -rf ../../AppClient/src/main/java/Back/Analizers/DEF/LexerDEF.java 
echo "------> compiling .jflex files"
jflex LexerDEF.jflex
echo "------> moving new .jflex files to /LexerDEF/"
mv .java LexerDEF.java ../../AppClient/src/main/java/Back/Analizers/DEF
echo "GENERATING PARSERS AND SYM TABLE" 
echo "------> deleting files on /Parser/"
rm -rf ../../AppClient/src/main/java/Back/Analizers/DEF/SintacticDEF.java ../../AppClient/src/main/java/Back/Analizers/DEF/symDEF.java
echo "------> compiling .cup file"
cup -parser SintacticDEF -symbols symDEF SintacticDEF.cup 
echo "------> moving new .java files to /Parser/"
mv SintacticDEF.java symDEF.java ../../AppClient/src/main/java/Back/Analizers/DEF/
