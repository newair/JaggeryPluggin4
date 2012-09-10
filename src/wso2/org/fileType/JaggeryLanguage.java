package wso2.org.fileType;

import com.intellij.lang.Language;
import com.intellij.psi.templateLanguages.TemplateLanguage;


public class JaggeryLanguage extends Language implements TemplateLanguage {


    public static final JaggeryLanguage INSTANCE = new JaggeryLanguage();

    protected JaggeryLanguage() {
        super("jaggery","application/x-jaggery-template");


    }
}
