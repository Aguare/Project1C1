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
%line
%column
%public

%{
    private ArrayList<ErrorLP> errors = new ArrayList<>();

    public void viewSymbol(int sym, int line, int column, String value) {
        System.out.println("L: " + line + " C: " + column + " Tipo:" + symDEF.terminalNames[sym] + "\t Content: " + value);
    }

    public void addError(String lexema, int line, int column){
        errors.add(new ErrorLP(line, column, lexema, 0, "El símbolo no se reconoce", null));
    }

    public ArrayList<ErrorLP> getErrors(){
        return errors;
    }

    public Symbol getSymbol(String text, int line, int column, boolean isClose){
        int type = 0;
        text = text.replaceAll("<|>|/", "");
        switch(text.toLowerCase()){
            case "h1":
                type = isClose ? symDEF.C_H1 : symDEF.O_H1;
                return new Symbol(type, yyline+1, yycolumn+1, yytext());
            case "h2":
                type = isClose ? symDEF.C_H2 : symDEF.O_H2;
                return new Symbol(type, yyline+1, yycolumn+1, yytext());
            case "html":
                type = isClose ? symDEF.C_HTML : symDEF.O_HTML;
                return new Symbol(type, yyline+1, yycolumn+1, yytext());
            case "table":
                type = isClose ? symDEF.C_TABLE : symDEF.O_TABLE;
                return new Symbol(type, yyline+1, yycolumn+1, yytext());
            case "tr":
                type = isClose ? symDEF.C_TR : symDEF.O_TR;
                return new Symbol(type, yyline+1, yycolumn+1, yytext());
            case "td":
                type = isClose ? symDEF.C_TD : symDEF.O_TD;
                return new Symbol(type, yyline+1, yycolumn+1, yytext());
            case "th":
                type = isClose ? symDEF.C_TH : symDEF.O_TH;
                return new Symbol(type, yyline+1, yycolumn+1, yytext());
            case "br":
                return new Symbol(symDEF.BR, yyline+1, yycolumn+1, yytext());
            case "for":
                type = isClose ? symDEF.FOR_C : symDEF.FOR;
                return new Symbol(type, yyline+1, yycolumn+1, yytext());
            default:
                errors.add(new ErrorLP(line, column, text, 0, "No corresponde a una etiqueta HTML", null));
                return new Symbol(symDEF.UNDEFINED, yyline+1, yycolumn+1, yytext());
        }
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
("(")          {return new Symbol(symDEF.O_PARENT, yyline+1, yycolumn+1, yytext());}
(")")          {return new Symbol(symDEF.C_PARENT, yyline+1, yycolumn+1, yytext());}
("[")          {return new Symbol(symDEF.O_SBRACKET, yyline+1, yycolumn+1, yytext());}
("]")          {return new Symbol(symDEF.C_SBRACKET, yyline+1, yycolumn+1, yytext());}
(":")          {return new Symbol(symDEF.COLONS, yyline+1, yycolumn+1, yytext());}
(".")          {return new Symbol(symDEF.DOT, yyline+1, yycolumn+1, yytext());}
(",")          {return new Symbol(symDEF.COMMA, yyline+1, yycolumn+1, yytext());}
(";")          {return new Symbol(symDEF.SEMICOLON, yyline+1, yycolumn+1, yytext());}
("+")          {return new Symbol(symDEF.SUM, yyline+1, yycolumn+1, yytext());}
("-")          {return new Symbol(symDEF.REST, yyline+1, yycolumn+1, yytext());}
("*")          {return new Symbol(symDEF.MULTIPLY, yyline+1, yycolumn+1, yytext());}
("/")          {return new Symbol(symDEF.DIV, yyline+1, yycolumn+1, yytext());}
("=")          {return new Symbol(symDEF.EQUAL, yyline+1, yycolumn+1, yytext());}
("<")          {return new Symbol(symDEF.SMALLER, yyline+1, yycolumn+1, yytext());}
(">")          {return new Symbol(symDEF.HIGHER, yyline+1, yycolumn+1, yytext());}
("$$")         {return new Symbol(symDEF.D_DOLLAR, yyline+1, yycolumn+1, yytext());}

(Score)        {return new Symbol(symDEF.SCORE, yyline+1, yycolumn+1, yytext());}
(Clases)       {return new Symbol(symDEF.CLASSES, yyline+1, yycolumn+1, yytext());}
(Variables)    {return new Symbol(symDEF.VARIABLES, yyline+1, yycolumn+1, yytext());}
(Metodos)      {return new Symbol(symDEF.METHODS, yyline+1, yycolumn+1, yytext());}
(Comentarios)  {return new Symbol(symDEF.COMMENTS, yyline+1, yycolumn+1, yytext());}
(.Nombre)      {return new Symbol(symDEF.NAME, yyline+1, yycolumn+1, yytext());}
(.Tipo)        {return new Symbol(symDEF.TYPE, yyline+1, yycolumn+1, yytext());}
(.Funcion)     {return new Symbol(symDEF.FUNCTION, yyline+1, yycolumn+1, yytext());}
(.Parametros)  {return new Symbol(symDEF.PARAMETERS, yyline+1, yycolumn+1, yytext());}
(.Texto)       {return new Symbol(symDEF.TEXT, yyline+1, yycolumn+1, yytext());}

//Variables
(Integer)      {return new Symbol(symDEF.T_INT, yyline+1, yycolumn+1, yytext());}
(String)       {return new Symbol(symDEF.T_STRING, yyline+1, yycolumn+1, yytext());}
(RESULT)       {return new Symbol(symDEF.T_RESULT, yyline+1, yycolumn+1, yytext());}

//HTML tags
(\<{ID}\>)     {return getSymbol(yytext(), yyline+1, yycolumn+1, false); }
(\<\/{ID}\>)   {return getSymbol(yytext(), yyline+1, yycolumn+1, true); }
(for)          {return new Symbol(symDEF.FOR, yyline+1, yycolumn+1, yytext());}
(iterador)     {return new Symbol(symDEF.ITERATOR, yyline+1, yycolumn+1, yytext());}
(hasta)        {return new Symbol(symDEF.UNTIL, yyline+1, yycolumn+1, yytext());}

//Declarateds
{NUMBER}       {return new Symbol(symDEF.INTEGER, yyline+1, yycolumn+1, yytext());}
{ID}           {return new Symbol(symDEF.ID, yyline+1, yycolumn+1, yytext());}
{STR}          {return new Symbol(symDEF.STRING, yyline+1, yycolumn+1, yytext());}
{COMM}         {/*Ignore*/}
{WHITE}        {/*Ignore*/}
{IGNORE}       {addError(yytext(), yyline+1, yycolumn+1);} 

[^]            {addError(yytext(), yyline+1, yycolumn+1);}
