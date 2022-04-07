/* SECTION 1: user code */
package Back.Analizers.JSON;

import java_cup.runtime.Symbol;
import java.util.ArrayList;
import Back.Analizers.ErrorLP;

/* SECTION 2: config */
%%
%class LexerJSON
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

    public void addError(String lexema, int line, int column){
        errors.add(new ErrorLP(line, column, lexema, 0, "El símbolo no se reconoce ", null));
    }

    public ArrayList<ErrorLP> getErrors(){
        return errors;
    }
%}

//Variable entrys
STR = ("\""[^\"\n\r]*"\"")
COMM2 = (\"\/\/((.)|a-zA-ZÀ-ÿ\u00f1\u00d1)+\")
COMM = (\"\/\*([^\*]|[\r\n]|(\*+([^\*\/]|[\r\n])))*\*+\/\")
INTEGER = ([0-9]+)
WHITE = ([\s\t\r\n]+)

%%

/* SECTION 3: lexical rules */
//Symbols of agrupation
("{")          {return new Symbol(symJSON.O_BRACE, yyline+1, yycolumn+1, yytext());}
("}")          {return new Symbol(symJSON.C_BRACE, yyline+1, yycolumn+1, yytext());}
("[")          {return new Symbol(symJSON.O_SBRACKET, yyline+1, yycolumn+1, yytext());}
("]")          {return new Symbol(symJSON.C_SBRACKET, yyline+1, yycolumn+1, yytext());}
(":")          {return new Symbol(symJSON.COLONS, yyline+1, yycolumn+1, yytext());}
(",")          {return new Symbol(symJSON.COMMA, yyline+1, yycolumn+1, yytext());}

//Lists
(Score)        {return new Symbol(symJSON.SCORE, yyline+1, yycolumn+1, yytext());}
(Clases)       {return new Symbol(symJSON.CLASSES, yyline+1, yycolumn+1, yytext());}
(Variables)    {return new Symbol(symJSON.VARIABLES, yyline+1, yycolumn+1, yytext());}
(Metodos)      {return new Symbol(symJSON.METHODS, yyline+1, yycolumn+1, yytext());}
(Métodos)      {return new Symbol(symJSON.METHODS, yyline+1, yycolumn+1, yytext());}
(Comentarios)  {return new Symbol(symJSON.COMMENTS, yyline+1, yycolumn+1, yytext());}

//Attributes
(Nombre)       {return new Symbol(symJSON.NAME, yyline+1, yycolumn+1, yytext());}
(Tipo)         {return new Symbol(symJSON.TYPE, yyline+1, yycolumn+1, yytext());}
(Funcion)      {return new Symbol(symJSON.FUNCTION, yyline+1, yycolumn+1, yytext());}
(Función)      {return new Symbol(symJSON.FUNCTION, yyline+1, yycolumn+1, yytext());}
(Parametros)   {return new Symbol(symJSON.PARAMETERS, yyline+1, yycolumn+1, yytext());}
(Parámetros)   {return new Symbol(symJSON.PARAMETERS, yyline+1, yycolumn+1, yytext());}
(Texto)        {return new Symbol(symJSON.TEXT, yyline+1, yycolumn+1, yytext());}

//Declarateds
{STR}          {return new Symbol(symJSON.STRING, yyline+1, yycolumn+1, yytext());}
{COMM}         {return new Symbol(symJSON.COM, yyline+1, yycolumn+1, yytext());}
{COMM2}        {return new Symbol(symJSON.COM, yyline+1, yycolumn+1, yytext());}
{INTEGER}      {return new Symbol(symJSON.INTEGER, yyline+1, yycolumn+1, yytext());}
{WHITE}        {/*Ignore*/}

[^]            {addError(yytext(), yyline+1, yycolumn+1);}
