package com.tcimba.idea.latex;
/**
 * Created by liu on 2017/3/31.
 */

import com.intellij.openapi.fileTypes.*;
import org.jetbrains.annotations.NotNull;

public class LatexFileTypeFactory extends FileTypeFactory {
    @Override
    public void createFileTypes(@NotNull FileTypeConsumer fileTypeConsumer) {
        fileTypeConsumer.consume(LatexFileType.INSTANCE, "tex");
    }
}
