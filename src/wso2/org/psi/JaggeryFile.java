package wso2.org.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;
import wso2.org.fileType.JaggeryFileType;
import wso2.org.fileType.JaggeryLanguage;


/**
 * Created with IntelliJ IDEA.
 * User: amila
 * Date: 6/22/12
 * Time: 2:44 PM
 * To change this template use File | Settings | File Templates.
 */
public  class JaggeryFile extends PsiFileBase {


    protected JaggeryFile(@NotNull FileViewProvider viewProvider) {

        super(viewProvider, JaggeryLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return JaggeryFileType.Jaggery_FILE_TYPE;  //To change body of implemented methods use File | Settings | File Templates.
    }

    protected JaggeryFile(@NotNull FileViewProvider viewProvider, @NotNull Language language) {
        super(viewProvider, JaggeryLanguage.INSTANCE);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
