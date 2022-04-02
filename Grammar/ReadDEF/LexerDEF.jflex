/* SECTION 1: user code */
package Back.Analizers.DEF;

import java_cup.runtime.Symbol;
import java.util.ArrayList;
import Back.Analizers.ErrorLP;

/* SECTION 2: config */
%%
%class LexerDEF
%type java_cup.runtime.Symbol
%full
%cup
%unicode
%caseless
%ignorecase
%line
%column
%public

%{
    private ArrayList<ErrorLP> errors = new ArrayList<>();

    public void viewSymbol(int sym, int line, int column, String value) {
        System.out.println("L: " + line + " C: " + column + "Tipo:" + symDEF.terminalNames[sym] + "\t Content: " + value);
    }

    public void addError(String lexema, int line, int column){
        errors.add(new ErrorLP(line, column, lexema, 0, "El símbolo no se reconoce "));
    }

    public ArrayList<ErrorLP> getErrors(){
        return errors;
    }
%}

//Variable entrys
STR = (\"[^\"\n\r]*\")
NUMBER = ((\d)+)
ID = ([a-zA-ZÀ-ÿ\u00f1\u00d1|\d|_|]+)
COMM = (\<\/([^\<]|[\r\n]|(\*+([^\<\/]|[\r\n])))*\/+\>)
WHITE = ([\s\t\r\n]+)
IGNORE = ((\”\Ñ\ñ)+)

%%

/* SECTION 3: lexical rules */
//Symbols of agrupation
("(")          {viewSymbol(symDEF.O_PARENT, yyline+1, yycolumn+1, yytext());}
(")")          {viewSymbol(symDEF.C_PARENT, yyline+1, yycolumn+1, yytext());}
("[")          {viewSymbol(symDEF.O_SBRACKET, yyline+1, yycolumn+1, yytext());}
("]")          {viewSymbol(symDEF.C_SBRACKET, yyline+1, yycolumn+1, yytext());}
(":")          {viewSymbol(symDEF.COLONS, yyline+1, yycolumn+1, yytext());}
(".")          {viewSymbol(symDEF.DOT, yyline+1, yycolumn+1, yytext());}
(",")          {viewSymbol(symDEF.COMMA, yyline+1, yycolumn+1, yytext());}
(";")          {viewSymbol(symDEF.SEMICOLON, yyline+1, yycolumn+1, yytext());}
("+")          {viewSymbol(symDEF.SUM, yyline+1, yycolumn+1, yytext());}
("-")          {viewSymbol(symDEF.REST, yyline+1, yycolumn+1, yytext());}
("*")          {viewSymbol(symDEF.MULTIPLY, yyline+1, yycolumn+1, yytext());}
("/")          {viewSymbol(symDEF.DIV, yyline+1, yycolumn+1, yytext());}
("=")          {viewSymbol(symDEF.EQUAL, yyline+1, yycolumn+1, yytext());}
("<")          {viewSymbol(symDEF.SMALLER, yyline+1, yycolumn+1, yytext());}
(">")          {viewSymbol(symDEF.HIGHER, yyline+1, yycolumn+1, yytext());}
("$$")         {viewSymbol(symDEF.D_DOLLAR, yyline+1, yycolumn+1, yytext());}

(Score)        {viewSymbol(symDEF.SCORE, yyline+1, yycolumn+1, yytext());}
(Clases)       {viewSymbol(symDEF.CLASSES, yyline+1, yycolumn+1, yytext());}
(Variables)    {viewSymbol(symDEF.VARIABLES, yyline+1, yycolumn+1, yytext());}
(Metodos)      {viewSymbol(symDEF.METHODS, yyline+1, yycolumn+1, yytext());}
(Comentarios)  {viewSymbol(symDEF.COMMENTS, yyline+1, yycolumn+1, yytext());}
(Nombre)       {viewSymbol(symDEF.NAME, yyline+1, yycolumn+1, yytext());}
(Tipo)         {viewSymbol(symDEF.TYPE, yyline+1, yycolumn+1, yytext());}
(Funcion)      {viewSymbol(symDEF.FUNCTION, yyline+1, yycolumn+1, yytext());}
(Parametros)   {viewSymbol(symDEF.PARAMETERS, yyline+1, yycolumn+1, yytext());}
(Texto)        {viewSymbol(symDEF.TEXT, yyline+1, yycolumn+1, yytext());}

//Variables
(Integer)    {viewSymbol(symDEF.T_INT, yyline+1, yycolumn+1, yytext());}
("String")     {viewSymbol(symDEF.T_STRING, yyline+1, yycolumn+1, yytext());}
(RESULT)     {viewSymbol(symDEF.T_RESULT, yyline+1, yycolumn+1, yytext());}

//HTML tags
(<html>)       {viewSymbol(symDEF.O_HTML, yyline+1, yycolumn+1, yytext());}
(<\/html>)     {viewSymbol(symDEF.C_HTML, yyline+1, yycolumn+1, yytext());}
(<h1>)         {viewSymbol(symDEF.O_H1, yyline+1, yycolumn+1, yytext());}
(<\/h1>)       {viewSymbol(symDEF.C_H1, yyline+1, yycolumn+1, yytext());}
(<h2>)         {viewSymbol(symDEF.O_H2, yyline+1, yycolumn+1, yytext());}
(<\/h2>)       {viewSymbol(symDEF.C_H2, yyline+1, yycolumn+1, yytext());}
(<table>)      {viewSymbol(symDEF.O_TABLE, yyline+1, yycolumn+1, yytext());}
(<\/table>)    {viewSymbol(symDEF.C_TABLE, yyline+1, yycolumn+1, yytext());}
(<tr>)         {viewSymbol(symDEF.O_TR, yyline+1, yycolumn+1, yytext());}
(<\/tr>)       {viewSymbol(symDEF.C_TR, yyline+1, yycolumn+1, yytext());}
(<th>)         {viewSymbol(symDEF.O_TH, yyline+1, yycolumn+1, yytext());}
(<\/th>)       {viewSymbol(symDEF.C_TH, yyline+1, yycolumn+1, yytext());}
(<td>)         {viewSymbol(symDEF.O_TD, yyline+1, yycolumn+1, yytext());}
(<\/td>)       {viewSymbol(symDEF.C_TD, yyline+1, yycolumn+1, yytext());}
(<br>)         {viewSymbol(symDEF.BR, yyline+1, yycolumn+1, yytext());}
(for)          {viewSymbol(symDEF.FOR, yyline+1, yycolumn+1, yytext());}
(iterador)     {viewSymbol(symDEF.ITERATOR, yyline+1, yycolumn+1, yytext());}
(hasta)        {viewSymbol(symDEF.UNTIL, yyline+1, yycolumn+1, yytext());}

//Declarateds
{NUMBER}       {viewSymbol(symDEF.INTEGER, yyline+1, yycolumn+1, yytext());}
{ID}           {viewSymbol(symDEF.ID, yyline+1, yycolumn+1, yytext());}
{STR}          {viewSymbol(symDEF.STRING, yyline+1, yycolumn+1, yytext());}
{COMM}         {/*Ignore*/}
{WHITE}        {/*Ignore*/}
{IGNORE}       {addError(yytext(), yyline+1, yycolumn+1);} 

[^]            {addError(yytext(), yyline+1, yycolumn+1);}
