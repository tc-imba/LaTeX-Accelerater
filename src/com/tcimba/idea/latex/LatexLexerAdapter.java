package com.tcimba.idea.latex;

/**
 * Created by liu on 2017/4/1.
 */

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

public class LatexLexerAdapter extends FlexAdapter {

    public LatexLexerAdapter() {
        super(new LatexLexer((Reader) null));
    }

}
