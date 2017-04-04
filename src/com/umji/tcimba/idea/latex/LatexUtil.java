package com.umji.tcimba.idea.latex;

/**
 * Created by liu on 17-4-2.
 */

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.*;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.indexing.FileBasedIndex;
import com.umji.tcimba.idea.latex.psi.*;
import com.umji.tcimba.idea.latex.psi.LatexProperty;

import java.util.*;


public class LatexUtil {

    public static List<LatexProperty> findProperties(Project project, String key) {
        List<LatexProperty> result = null;
        Collection<VirtualFile> virtualFiles =
                FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, LatexFileType.INSTANCE,
                        GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            LatexFile LatexFile = (LatexFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (LatexFile != null) {
                LatexProperty[] properties = PsiTreeUtil.getChildrenOfType(LatexFile, LatexProperty.class);
                if (properties != null) {
                    for (LatexProperty property : properties) {
                        if (key.equals(property.getKey())) {
                            if (result == null) {
                                result = new ArrayList<LatexProperty>();
                            }
                            result.add(property);
                        }
                    }
                }
            }
        }
        return result != null ? result : Collections.<LatexProperty>emptyList();
    }

    public static List<LatexProperty> findProperties(Project project) {
        List<LatexProperty> result = new ArrayList<LatexProperty>();
        Collection<VirtualFile> virtualFiles =
                FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, LatexFileType.INSTANCE,
                        GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            LatexFile LatexFile = (LatexFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (LatexFile != null) {
                LatexProperty[] properties = PsiTreeUtil.getChildrenOfType(LatexFile, LatexProperty.class);
                if (properties != null) {
                    Collections.addAll(result, properties);
                }
            }
        }
        return result;
    }
    
}
