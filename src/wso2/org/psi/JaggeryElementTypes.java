package wso2.org.psi;

import com.intellij.lang.Language;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.IStubFileElementType;
import wso2.org.fileType.JaggeryLanguage;


/**
 * Created with IntelliJ IDEA.
 * User: amila
 * Date: 6/22/12
 * Time: 9:56 AM
 * To change this template use File | Settings | File Templates.
 */
public interface JaggeryElementTypes {

    JaggeryLanguage LANG = Language.findInstance(JaggeryLanguage.class);

    IFileElementType FILE = new IStubFileElementType(LANG);


}
