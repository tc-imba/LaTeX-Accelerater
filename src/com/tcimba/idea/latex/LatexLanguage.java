package com.tcimba.idea.latex;
/**
 * Created by liu on 2017/3/31.
 */

import com.intellij.lang.Language;
import org.jetbrains.annotations.*;

public class LatexLanguage extends Language {

    public static final LatexLanguage INSTANCE = new LatexLanguage();

    @NonNls
    public static final String NAME = "LaTeX";

    @NonNls
    public static final String EXTENSION = "tex";

    private LatexLanguage() {
        super(NAME);
    }


}
