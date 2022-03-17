echo "GENERATING ARCHIVES FOR LEXER AND PARSER"
echo "------> deleting files on project ServerAnalizer"
rm -rf ../ServerAnalizer/src/main/java/Analizers/Lexer.java 
echo "------> compiling .jflex files"
jflex LexerArray.jflex
echo "------> moving new .jflex files to /Lexer/"
mv .java Lexer.java ../ServerAnalizer/src/main/java/Analizers
echo "GENERATING PARSERS AND SYM TABLE" 
echo "------> deleting files on /Parser/"
rm -rf ../ServerAnalizer/src/main/java/Analizers/Sintactic.java ../ServerAnalizer/src/main/java/Analizers/sym.java
echo "------> compiling .cup file"
cup -parser Sintactic -symbols sym Sintactic.cup 
echo "------> moving new .java files to /Parser/"
mv Sintactic.java sym.java ../ServerAnalizer/src/main/java/Analizers/
