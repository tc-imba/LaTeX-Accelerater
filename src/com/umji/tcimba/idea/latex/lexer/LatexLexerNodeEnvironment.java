package com.umji.tcimba.idea.latex.lexer;

/**
 * Created by liu on 17-4-6.
 */
public class LatexLexerNodeEnvironment implements LatexLexerNodeInterface {

    public enum ENVIRONMENT_TYPE {
        CONTENT,
        MATH_INLINE,
        MATH_DISPLAY
    }

    public NODE_TYPE nodeType = NODE_TYPE.ENVIRONMENT;

    public ENVIRONMENT_TYPE environmentType = ENVIRONMENT_TYPE.CONTENT;

    private String name;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
