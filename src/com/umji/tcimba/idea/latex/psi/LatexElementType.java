package com.umji.tcimba.idea.latex.psi;

/**
 * Created by liu on 2017/3/31.
 */

import com.intellij.psi.tree.IElementType;
import com.umji.tcimba.idea.latex.LatexLanguage;
import org.jetbrains.annotations.*;

public class LatexElementType extends IElementType {

    public LatexElementType(@NotNull @NonNls String debugName) {
        super(debugName, LatexLanguage.INSTANCE);
    }

}
