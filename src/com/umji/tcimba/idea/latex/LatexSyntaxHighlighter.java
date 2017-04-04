package com.umji.tcimba.idea.latex;

/**
 * Created by liu on 17-4-2.
 */

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.*;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.umji.tcimba.idea.latex.psi.LatexTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class LatexSyntaxHighlighter extends SyntaxHighlighterBase{

    public static final TextAttributesKey SEPARATOR =
            createTextAttributesKey("LATEX_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey KEY =
            createTextAttributesKey("LATEX_KEY", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey VALUE =
            createTextAttributesKey("LATEX_VALUE", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("LATEX_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("LATEX_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);


    public static final TextAttributesKey INSTANCE_FIELD =
            createTextAttributesKey("LATEX_INSTANCE_FIELD", DefaultLanguageHighlighterColors.INSTANCE_FIELD);

    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] SEPARATOR_KEYS = new TextAttributesKey[]{SEPARATOR};
    private static final TextAttributesKey[] KEY_KEYS = new TextAttributesKey[]{KEY};
    private static final TextAttributesKey[] VALUE_KEYS = new TextAttributesKey[]{VALUE};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    private static final TextAttributesKey[] INSTANCE_FIELD_KEYS = new TextAttributesKey[]{INSTANCE_FIELD};

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new LatexLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(LatexTypes.SEPARATOR)) {
            return SEPARATOR_KEYS;
        } else if (tokenType.equals(LatexTypes.COMMAND) || tokenType.equals(LatexTypes.BEGIN_ENV) || tokenType.equals(LatexTypes.END_ENV)) {
            return KEY_KEYS;
        } else if (tokenType.equals(LatexTypes.OPTION_EQUAL) || tokenType.equals(LatexTypes.OPTION_COMMA)) {
            return EMPTY_KEYS;
        } else if (tokenType.equals(LatexTypes.OPTION_NAME)) {
            return INSTANCE_FIELD_KEYS;
        } else if (tokenType.equals(LatexTypes.VALUE)) {
            return VALUE_KEYS;
        } else if (tokenType.equals(LatexTypes.COMMENT)) {
            return COMMENT_KEYS;
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        } else {
            return EMPTY_KEYS;
        }
    }

}
