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
%cup
%unicode
%line
%column
%public

%{
    private ArrayList<ErrorLP> errors = new ArrayList<>();

    public void viewToken(Symbol cur_token){
        System.out.println("Simbolo detectado " + sym.terminalNames[cur_token.sym]);
        System.out.println(String.format("En la posicion: %d, %d", cur_token.left, cur_token.right));
    }

    public void addError(String lexema, int line, int column){
        errors.add(new ErrorLP(line, column, lexema, 0, "El símbolo no se reconoce"));
        System.out.println("Error -> "+lexema+" L:"+line+" C:"+column);
    }

    public ArrayList<ErrorLP> getErrors(){
        return errors;
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
WHITE = ([\s\t\r\n]+)
//Others with expression
OTHER = ([\|\||\|])
%%

/* SECTION 3: lexical rules */
//Symbols of agrupation
("{")          {return new Symbol(sym.O_BRACE, yyline+1, yycolumn+1, yytext());}
("}")          {return new Symbol(sym.C_BRACE, yyline+1, yycolumn+1, yytext());}
("[")          {return new Symbol(sym.O_SBRACKET, yyline+1, yycolumn+1, yytext());}
("]")          {return new Symbol(sym.C_SBRACKET, yyline+1, yycolumn+1, yytext());}
("(")          {return new Symbol(sym.O_PARENT, yyline+1, yycolumn+1, yytext());}
(")")          {return new Symbol(sym.C_PARENT, yyline+1, yycolumn+1, yytext());}
(";")          {return new Symbol(sym.SEMICOLON, yyline+1, yycolumn+1, yytext());}
(":")          {return new Symbol(sym.COLONS, yyline+1, yycolumn+1, yytext());}
(",")          {return new Symbol(sym.COMMA, yyline+1, yycolumn+1, yytext());}
(".")          {return new Symbol(sym.DOT, yyline+1, yycolumn+1, yytext());}
("'")          {return new Symbol(sym.APOS, yyline+1, yycolumn+1, yytext());}

//Arithmetic operators and logicals
("+")          {return new Symbol(sym.SUM, yyline+1, yycolumn+1, yytext());}
("-")          {return new Symbol(sym.REST, yyline+1, yycolumn+1, yytext());}
("*")          {return new Symbol(sym.MULTIPLY, yyline+1, yycolumn+1, yytext());}
("/")          {return new Symbol(sym.DIV, yyline+1, yycolumn+1, yytext());}
("=")          {return new Symbol(sym.EQUAL, yyline+1, yycolumn+1, yytext());}
("==")         {return new Symbol(sym.D_EQUAL, yyline+1, yycolumn+1, yytext());}
("%")          {return new Symbol(sym.MOD, yyline+1, yycolumn+1, yytext());}
("!=")         {return new Symbol(sym.DIFFERENCE, yyline+1, yycolumn+1, yytext());}
(">")          {return new Symbol(sym.HIGHER, yyline+1, yycolumn+1, yytext());}
(">=")         {return new Symbol(sym.H_EQUAL, yyline+1, yycolumn+1, yytext());}
("<")          {return new Symbol(sym.SMALLER, yyline+1, yycolumn+1, yytext());}
("<=")         {return new Symbol(sym.S_EQUAL, yyline+1, yycolumn+1, yytext());}
("&" | "&&")   {return new Symbol(sym.AND, yyline+1, yycolumn+1, yytext());}
("++")         {return new Symbol(sym.INCREMENT, yyline+1, yycolumn+1, yytext());}
("--")         {return new Symbol(sym.DECREMENT, yyline+1, yycolumn+1, yytext());}
("+=")         {return new Symbol(sym.C_SUM, yyline+1, yycolumn+1, yytext());}
("-=")         {return new Symbol(sym.C_REST, yyline+1, yycolumn+1, yytext());}
("*=")         {return new Symbol(sym.C_MULTIPLY, yyline+1, yycolumn+1, yytext());}
("/=")         {return new Symbol(sym.C_DIV, yyline+1, yycolumn+1, yytext());}

//Sentences of control
(if)           {return new Symbol(sym.IF, yyline+1, yycolumn+1, yytext());}
(else)         {return new Symbol(sym.ELSE, yyline+1, yycolumn+1, yytext());}
(for)          {return new Symbol(sym.FOR, yyline+1, yycolumn+1, yytext());}
(while)        {return new Symbol(sym.WHILE, yyline+1, yycolumn+1, yytext());}
(do)           {return new Symbol(sym.DO, yyline+1, yycolumn+1, yytext());}
(switch)       {return new Symbol(sym.SWITCH, yyline+1, yycolumn+1, yytext());}
(case)         {return new Symbol(sym.CASE, yyline+1, yycolumn+1, yytext());}
(default)      {return new Symbol(sym.DEFAULT, yyline+1, yycolumn+1, yytext());}

//Sentences of out
(break)        {return new Symbol(sym.BREAK, yyline+1, yycolumn+1, yytext());}
(return)       {return new Symbol(sym.RETURN, yyline+1, yycolumn+1, yytext());}

//Other words
(import)       {return new Symbol(sym.IMPORT, yyline+1, yycolumn+1, yytext());}
(Object)       {return new Symbol(sym.OBJECT, yyline+1, yycolumn+1, yytext());}
(final)        {return new Symbol(sym.FINAL, yyline+1, yycolumn+1, yytext());}
(static)       {return new Symbol(sym.STATIC, yyline+1, yycolumn+1, yytext());}
(void)         {return new Symbol(sym.VOID, yyline+1, yycolumn+1, yytext());}
(class)        {return new Symbol(sym.CLASS, yyline+1, yycolumn+1, yytext());}
(package)      {return new Symbol(sym.PACKAGE, yyline+1, yycolumn+1, yytext());}
(new)          {return new Symbol(sym.NEW, yyline+1, yycolumn+1, yytext());}
(this)         {return new Symbol(sym.THIS, yyline+1, yycolumn+1, yytext());}
//(@Override)    {return new Symbol(sym.OVERRIDE, yyline+1, yycolumn+1, yytext());}

//Declarateds
{VC}           {return new Symbol(sym.VISIBILITY, yyline+1, yycolumn+1, yytext());}
{OTHER}        {return new Symbol(sym.OR, yyline+1, yycolumn+1, yytext());}
{T_VAR}        {return new Symbol(sym.TYPE_VARIABLE, yyline+1, yycolumn+1, yytext());}
{STR}          {return new Symbol(sym.STRING, yyline+1, yycolumn+1, yytext());}
{INTEGER}      {return new Symbol(sym.INTEGER, yyline+1, yycolumn+1, yytext());}
{DECIMAL}      {return new Symbol(sym.DECIMAL, yyline+1, yycolumn+1, yytext());}
{BOOLEAN}      {return new Symbol(sym.BOOLEAN, yyline+1, yycolumn+1, yytext());}
{CHAR}         {return new Symbol(sym.CHAR, yyline+1, yycolumn+1, yytext());}
{ID}           {return new Symbol(sym.ID, yyline+1, yycolumn+1, yytext());}
{COM}          {/*Ignore*/}
{COMM}         {/*Ignore*/}
{WHITE}        {/*Ignore*/}

[^]            {addError(yytext(), yyline+1, yycolumn+1);}
