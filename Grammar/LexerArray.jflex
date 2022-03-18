/* SECTION 1: user code */
package Analizers;

import java_cup.runtime.Symbol;
import Analizers.sym;
import java.util.ArrayList;

/* SECTION 2: config */
%%
%class Lexer
%type java_cup.runtime.Symbol
%full
%unicode
%line
%column
%public

%{
    public ArrayList<String> tokens = new ArrayList<>();

    public void viewToken(Symbol cur_token){
        System.out.println("Simbolo detectado " + sym.terminalNames[cur_token.sym]);
        System.out.println(String.format("En la posicion: %d, %d", cur_token.left, cur_token.right));
    }

    public void addError(String lexema, int line, int column){
        System.out.println("Error -> "+lexema+" L:"+line+" C:"+column);
    }

    public void addToken(int type, int line, int column, String token){
        tokens.add("L:" + line + "\t C:" + column + "\t Tipo: " + sym.terminalNames[type] + "\t -> " + token);
    }

    public void showTokens(){
        for (String token : tokens) {
            System.out.println(token);
        }
    }
%}
//Comments
COM = (\/\/((.)|a-zA-ZÀ-ÿ\u00f1\u00d1)+)
COMM = (\/\*([^\*]|[\r\n]|(\*+([^\*\/]|[\r\n])))*\*+\/)
//Visibility of classes
VC = (public | private | protected)
//Variable types
T_VAR = (int | boolean | String | char | double)
//Variable entrys
STR = (\"((.)|a-zA-ZÀ-ÿ\u00f1\u00d1)+\")
INTEGER = ([0-9]+)
DECIMAL = (\d+(\.\d+)?)
BOOLEAN = (true | false)
CHAR = (\'[a-zA-ZÀ-ÿ\u00f1\u00d1]\')
ID = ([a-zA-ZÀ-ÿ\u00f1\u00d1|\d|_|]+)
WHITE = ([\s\t\r]+)
//Others with expression
OTHER = ([\|\||\|])
%%

/* SECTION 3: lexical rules */
//Symbols of agrupation
("{")          {addToken(sym.O_BRACE, yyline+1, yycolumn+1, yytext());}
("}")          {addToken(sym.C_BRACE, yyline+1, yycolumn+1, yytext());}
("[")          {addToken(sym.O_SBRACKET, yyline+1, yycolumn+1, yytext());}
("]")          {addToken(sym.C_SBRACKET, yyline+1, yycolumn+1, yytext());}
("(")          {addToken(sym.O_PARENT, yyline+1, yycolumn+1, yytext());}
(")")          {addToken(sym.C_PARENT, yyline+1, yycolumn+1, yytext());}
(";")          {addToken(sym.SEMICOLON, yyline+1, yycolumn+1, yytext());}
(":")          {addToken(sym.COLONS, yyline+1, yycolumn+1, yytext());}
(",")          {addToken(sym.COMMA, yyline+1, yycolumn+1, yytext());}
(".")          {addToken(sym.DOT, yyline+1, yycolumn+1, yytext());}
("'")          {addToken(sym.APOS, yyline+1, yycolumn+1, yytext());}

//Arithmetic operators and logicals
("+")          {addToken(sym.SUM, yyline+1, yycolumn+1, yytext());}
("-")          {addToken(sym.REST, yyline+1, yycolumn+1, yytext());}
("*")          {addToken(sym.MULTIPLY, yyline+1, yycolumn+1, yytext());}
("/")          {addToken(sym.DIV, yyline+1, yycolumn+1, yytext());}
("=")          {addToken(sym.EQUAL, yyline+1, yycolumn+1, yytext());}
("==")         {addToken(sym.D_EQUAL, yyline+1, yycolumn+1, yytext());}
("%")          {addToken(sym.MOD, yyline+1, yycolumn+1, yytext());}
("!=")         {addToken(sym.DIFFERENCE, yyline+1, yycolumn+1, yytext());}
(">")          {addToken(sym.HIGHER, yyline+1, yycolumn+1, yytext());}
(">=")         {addToken(sym.H_EQUAL, yyline+1, yycolumn+1, yytext());}
("<")          {addToken(sym.SMALLER, yyline+1, yycolumn+1, yytext());}
("<=")         {addToken(sym.S_EQUAL, yyline+1, yycolumn+1, yytext());}
("&" | "&&")   {addToken(sym.AND, yyline+1, yycolumn+1, yytext());}
("++")         {addToken(sym.INCREMENT, yyline+1, yycolumn+1, yytext());}
("--")         {addToken(sym.DECREMENT, yyline+1, yycolumn+1, yytext());}
("+=")         {addToken(sym.C_SUM, yyline+1, yycolumn+1, yytext());}
("-=")         {addToken(sym.C_REST, yyline+1, yycolumn+1, yytext());}
("*=")         {addToken(sym.C_MULTIPLY, yyline+1, yycolumn+1, yytext());}
("/=")         {addToken(sym.C_DIV, yyline+1, yycolumn+1, yytext());}

//Sentences of control
(if)           {addToken(sym.IF, yyline+1, yycolumn+1, yytext());}
(else)         {addToken(sym.ELSE, yyline+1, yycolumn+1, yytext());}
(for)          {addToken(sym.FOR, yyline+1, yycolumn+1, yytext());}
(while)        {addToken(sym.WHILE, yyline+1, yycolumn+1, yytext());}
(do)           {addToken(sym.DO, yyline+1, yycolumn+1, yytext());}
(switch)       {addToken(sym.SWITCH, yyline+1, yycolumn+1, yytext());}
(case)         {addToken(sym.CASE, yyline+1, yycolumn+1, yytext());}

//Sentences of out
(break)        {addToken(sym.BREAK, yyline+1, yycolumn+1, yytext());}
(return)       {addToken(sym.RETURN, yyline+1, yycolumn+1, yytext());}

//Other words
(import)       {addToken(sym.IMPORT, yyline+1, yycolumn+1, yytext());}
(Object)       {addToken(sym.OBJECT, yyline+1, yycolumn+1, yytext());}
(final)        {addToken(sym.FINAL, yyline+1, yycolumn+1, yytext());}
(static)       {addToken(sym.STATIC, yyline+1, yycolumn+1, yytext());}
(void)         {addToken(sym.VOID, yyline+1, yycolumn+1, yytext());}
(class)        {addToken(sym.CLASS, yyline+1, yycolumn+1, yytext());}
(package)      {addToken(sym.PACKAGE, yyline+1, yycolumn+1, yytext());}
(new)          {addToken(sym.NEW, yyline+1, yycolumn+1, yytext());}
//(@Override)    {addToken(sym.OVERRIDE, yyline+1, yycolumn+1, yytext());}

//Declarateds
{VC}           {addToken(sym.VISIBILITY, yyline+1, yycolumn+1, yytext());}
{OTHER}        {addToken(sym.OR, yyline+1, yycolumn+1, yytext());}
{T_VAR}        {addToken(sym.TYPE_VARIABLE, yyline+1, yycolumn+1, yytext());}
{STR}          {addToken(sym.STRING, yyline+1, yycolumn+1, yytext());}
{INTEGER}      {addToken(sym.INTEGER, yyline+1, yycolumn+1, yytext());}
{DECIMAL}      {addToken(sym.DECIMAL, yyline+1, yycolumn+1, yytext());}
{BOOLEAN}      {addToken(sym.BOOLEAN, yyline+1, yycolumn+1, yytext());}
{CHAR}         {addToken(sym.CHAR, yyline+1, yycolumn+1, yytext());}
{ID}           {addToken(sym.ID, yyline+1, yycolumn+1, yytext());}
{COM}          {/*Ignore*/}
{COMM}         {/*Ignore*/}
{WHITE}        {/*Ignore*/}

[^]            {addError(yytext(), yyline+1, yycolumn+1);}
