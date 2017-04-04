package com.umji.tcimba.idea.latex;
/**
 * Created by liu on 2017/3/31.
 */

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.*;

import javax.swing.*;

public class LatexFileType extends LanguageFileType {

    public static final LatexFileType INSTANCE = new LatexFileType();

    private LatexFileType() {
        super(LatexLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return LatexLanguage.NAME + " file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return LatexLanguage.NAME + " language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return LatexLanguage.EXTENSION;
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return LatexIcons.FILE;
    }
}
