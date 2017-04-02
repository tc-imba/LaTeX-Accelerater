package com.tcimba.idea.latex.psi.impl;

/**
 * Created by liu on 17-4-2.
 */

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.tcimba.idea.latex.psi.LatexNamedElement;
import org.jetbrains.annotations.NotNull;

public abstract class LatexNamedElementImpl extends ASTWrapperPsiElement implements LatexNamedElement{

    public LatexNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }

}
