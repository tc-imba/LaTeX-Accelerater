package com.tcimba.idea.latex.psi;

/**
 * Created by liu on 2017/3/31.
 */

import com.intellij.psi.tree.IElementType;
import com.tcimba.idea.latex.LatexLanguage;
import org.jetbrains.annotations.*;

public class LatexTokenType extends IElementType{

    public LatexTokenType(@NotNull @NonNls String debugName) {
        super(debugName, LatexLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "LatexTokenType." + super.toString();
    }

}
