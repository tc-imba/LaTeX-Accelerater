package com.tcimba.idea.latex;

/**
 * Created by liu on 17-4-2.
 */

import com.intellij.openapi.fileTypes.*;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

public class LatexSyntaxHighlighterFactory extends SyntaxHighlighterFactory{

    @NotNull
    @Override
    public SyntaxHighlighter getSyntaxHighlighter(Project project, VirtualFile virtualFile) {
        return new LatexSyntaxHighlighter();
    }
}
