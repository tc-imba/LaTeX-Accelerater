package com.tcimba.idea.latex.psi.impl;

/**
 * Created by liu on 17-4-2.
 */

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.*;
import com.tcimba.idea.latex.LatexIcons;
import com.tcimba.idea.latex.psi.*;
import org.jetbrains.annotations.Nullable;
import javax.swing.*;


public class LatexPsiImplUtil {

    public static String getKey(LatexProperty element) {
        ASTNode keyNode = element.getNode().findChildByType(LatexTypes.KEY);
        if (keyNode != null) {
            // IMPORTANT: Convert embedded escaped spaces to Latex spaces
            return keyNode.getText().replaceAll("\\\\ ", " ");
        } else {
            return null;
        }
    }

    public static String getValue(LatexProperty element) {
        ASTNode valueNode = element.getNode().findChildByType(LatexTypes.VALUE);
        if (valueNode != null) {
            return valueNode.getText();
        } else {
            return null;
        }
    }

    public static String getName(LatexProperty element) {
        return getKey(element);
    }

    public static PsiElement setName(LatexProperty element, String newName) {
        ASTNode keyNode = element.getNode().findChildByType(LatexTypes.KEY);
        if (keyNode != null) {
            LatexProperty property = LatexElementFactory.createProperty(element.getProject(), newName);
            ASTNode newKeyNode = property.getFirstChild().getNode();
            element.getNode().replaceChild(keyNode, newKeyNode);
        }
        return element;
    }

    public static PsiElement getNameIdentifier(LatexProperty element) {
        ASTNode keyNode = element.getNode().findChildByType(LatexTypes.KEY);
        if (keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }

    public static ItemPresentation getPresentation(final LatexProperty element) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return element.getKey();
            }

            @Nullable
            @Override
            public String getLocationString() {
                PsiFile containingFile = element.getContainingFile();
                return containingFile == null ? null : containingFile.getName();
            }

            @Nullable
            @Override
            public Icon getIcon(boolean unused) {
                return LatexIcons.FILE;
            }
        };
    }

}
