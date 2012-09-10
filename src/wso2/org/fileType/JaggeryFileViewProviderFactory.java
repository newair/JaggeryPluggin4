package wso2.org.fileType;

import com.intellij.lang.Language;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.FileViewProviderFactory;
import com.intellij.psi.PsiManager;
import org.jetbrains.annotations.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: amila
 * Date: 7/2/12
 * Time: 3:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class JaggeryFileViewProviderFactory implements FileViewProviderFactory {
    @Override
    public FileViewProvider createFileViewProvider(@NotNull VirtualFile virtualFile, Language language, @NotNull PsiManager psiManager, boolean b) {
        return new JaggeryFileViewProvider(psiManager, virtualFile, b);  //To change body of implemented methods use File | Settings | File Templates.
    }
}
