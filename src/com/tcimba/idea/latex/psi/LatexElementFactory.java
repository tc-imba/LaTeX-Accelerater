package com.tcimba.idea.latex.psi;

/**
 * Created by liu on 17-4-2.
 */

import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.tcimba.idea.latex.LatexFile;
import com.tcimba.idea.latex.LatexFileType;

public class LatexElementFactory {

    public static LatexProperty createProperty(Project project, String name, String value) {
        final LatexFile file = createFile(project, name + " = " + value);
        return (LatexProperty) file.getFirstChild();
    }

    public static LatexProperty createProperty(Project project, String name) {
        final LatexFile file = createFile(project, name);
        return (LatexProperty) file.getFirstChild();
    }

    public static PsiElement createCRLF(Project project) {
        final LatexFile file = createFile(project, "\n");
        return file.getFirstChild();
    }

    public static LatexFile createFile(Project project, String text) {
        String name = "dummy.Latex";
        return (LatexFile) PsiFileFactory.getInstance(project).
                createFileFromText(name, LatexFileType.INSTANCE, text);
    }
    
}
