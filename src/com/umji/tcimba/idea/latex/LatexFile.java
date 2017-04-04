package com.umji.tcimba.idea.latex;

/**
 * Created by liu on 2017/4/2.
 */

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.umji.tcimba.idea.latex.*;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class LatexFile extends PsiFileBase {

    public LatexFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, LatexLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return LatexFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return LatexLanguage.NAME + " File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }

}
