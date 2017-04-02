package com.tcimba.idea.latex;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import com.intellij.psi.TokenType;
import com.tcimba.idea.latex.psi.LatexTypes;

%%

%{
  public _LatexLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _LatexLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

CRLF=\R
WHITE_SPACE=[\ \n\t\f]
FIRST_VALUE_CHARACTER=[^ \n\f\\] | "\\"{CRLF} | "\\".
VALUE_CHARACTER=[^\n\f\\] | "\\"{CRLF} | "\\".
END_OF_LINE_COMMENT=("%")[^\r\n]*
SEPARATOR=[:=]
//KEY_CHARACTER=[^:=\ \n\t\f\\] | "\\ "

KEY_CHARACTER=\\[:letter:]+

TEXT                = [^\(\)\{\}\[\]\\\%\ \t\f\r\n]|"\\\%"|("\\"{SPECIAL})
SPECIAL             = "$"|"&"|"#"|"_"|"~"|"^"|"\\"


// The begin and end clause of environments
BEGIN_COMMAND = \\[:letter:]+
BEGIN_ENV = "\\begin"
END_ENV = "\\end"


%state WAITING_VALUE
%state ARGUMENT
%state OPTION

%%

// brackets
//<YYINITIAL> "("             { yybegin(IN_ARGUMENT); return LPAREN; }
//<YYINITIAL> ")"             { return RPAREN; }
//<YYINITIAL> "["             { yybegin(IN_ARGUMENT); return LBRACKET; }
//<YYINITIAL> "]"             { return RBRACKET; }


<YYINITIAL> {BEGIN_ENV}                                     { return LatexTypes.BEGIN_ENV; }
<YYINITIAL> {END_ENV}                                       { return LatexTypes.END_ENV; }
<YYINITIAL> {BEGIN_COMMAND}                                 { return LatexTypes.COMMAND; }

<YYINITIAL> "{"                                             { yybegin(ARGUMENT); return LatexTypes.LBRACE; }
<YYINITIAL> "}"                                             { return LatexTypes.RBRACE; }
<YYINITIAL> "["                                             { yybegin(OPTION); return LatexTypes.LBRACKET; }
<YYINITIAL> "]"                                             { return LatexTypes.RBRACKET; }
<YYINITIAL> "<"                                             { yybegin(ARGUMENT); return LatexTypes.LANGLE; }
<YYINITIAL> ">"                                             { return LatexTypes.RANGLE; }
<YYINITIAL> "("                                             { yybegin(ARGUMENT); return LatexTypes.LPAREN; }
<YYINITIAL> ")"                                             { return LatexTypes.RPAREN; }


<ARGUMENT> {
    [^\(\)\{\}\[\]\\,]+                                     { return LatexTypes.TEXT; }
    ","                                                     { yybegin(OPTION); return LatexTypes.OPTION_COMMA; }
    .                                                       { yypushback(1); yybegin(YYINITIAL); }
}

<OPTION> {
    [^\(\)\{\}\[\]\\,=]+                                    { return LatexTypes.OPTION_NAME; }
    "="                                                     { return LatexTypes.OPTION_EQUAL; }
    ","                                                     { yypushback(1); yybegin(ARGUMENT); }
    .                                                       { yypushback(1); yybegin(ARGUMENT); }
}

<YYINITIAL> {END_OF_LINE_COMMENT}                           { yybegin(YYINITIAL); return LatexTypes.COMMENT; }

<YYINITIAL> {KEY_CHARACTER}+                                { yybegin(YYINITIAL); return LatexTypes.KEY; }

<YYINITIAL> {SEPARATOR}                                     { yybegin(WAITING_VALUE); return LatexTypes.SEPARATOR; }

<WAITING_VALUE> {CRLF}({CRLF}|{WHITE_SPACE})+               { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

<WAITING_VALUE> {WHITE_SPACE}+                              { yybegin(WAITING_VALUE); return TokenType.WHITE_SPACE; }

<WAITING_VALUE> {FIRST_VALUE_CHARACTER}{VALUE_CHARACTER}*   { yybegin(YYINITIAL); return LatexTypes.VALUE; }

({CRLF}|{WHITE_SPACE})+                                     { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

.                                                           { return TokenType.BAD_CHARACTER; }