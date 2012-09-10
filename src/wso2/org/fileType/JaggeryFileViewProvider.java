package wso2.org.fileType;

import com.intellij.lang.Language;
import com.intellij.lang.LanguageParserDefinitions;
import com.intellij.openapi.fileTypes.PlainTextLanguage;
import com.intellij.openapi.fileTypes.StdFileTypes;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.LanguageSubstitutors;
import com.intellij.psi.MultiplePsiFilesPerDocumentFileViewProvider;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.impl.source.PsiFileImpl;
import com.intellij.psi.templateLanguages.TemplateDataLanguageMappings;
import com.intellij.psi.templateLanguages.TemplateLanguage;
import com.intellij.psi.templateLanguages.TemplateLanguageFileViewProvider;
import gnu.trove.THashSet;
import org.jetbrains.annotations.NotNull;
import wso2.org.JaggeryTokenTypes;

import java.util.Arrays;
import java.util.Set;


public class JaggeryFileViewProvider extends MultiplePsiFilesPerDocumentFileViewProvider implements TemplateLanguageFileViewProvider {

    private Language myTemplateDataLanguage;

    public JaggeryFileViewProvider(PsiManager manager, VirtualFile virtualFile, boolean physical) {

        super(manager, virtualFile, physical);

        Language dataLang = TemplateDataLanguageMappings.getInstance(manager.getProject()).getMapping(virtualFile);
        if(dataLang == null)


        {dataLang = StdFileTypes.JS.getLanguage();}


        if(dataLang instanceof TemplateLanguage) {
            myTemplateDataLanguage = PlainTextLanguage.INSTANCE;
        } else {
            myTemplateDataLanguage = LanguageSubstitutors.INSTANCE.substituteLanguage(dataLang, virtualFile, manager.getProject());
        }

    }


    public JaggeryFileViewProvider(PsiManager manager, VirtualFile virtualFile, boolean physical, Language language){
        super(manager, virtualFile, physical);
        this.myTemplateDataLanguage = language;
    }

    @NotNull
    @Override
    public Language getBaseLanguage() {
        return JaggeryLanguage.INSTANCE ;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @NotNull
    @Override
    public Language getTemplateDataLanguage() {
        return myTemplateDataLanguage;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected MultiplePsiFilesPerDocumentFileViewProvider cloneInner(VirtualFile virtualFile) {
        return  new JaggeryFileViewProvider(getManager(), virtualFile, false, myTemplateDataLanguage);  //To change body of implemented methods use File | Settings | File Templates.
    }


    @NotNull
    @Override
    public Set<Language> getLanguages() {
        return new THashSet<Language>(Arrays.asList(new Language[]{JaggeryLanguage.INSTANCE, myTemplateDataLanguage}));
    }

    @Override
    protected PsiFile createFile(Language lang) {
        // creating file for main lang (HTML)
        if(lang == myTemplateDataLanguage) {

            PsiFileImpl file = (PsiFileImpl) LanguageParserDefinitions.INSTANCE.forLanguage(lang).createFile(this);
            file.setContentElementType(JaggeryTokenTypes.TEMPLATE_DATA);
            return file;
        } else if(lang == JaggeryLanguage.INSTANCE) {
            return LanguageParserDefinitions.INSTANCE.forLanguage(lang).createFile(this);
        } else {
            return null;
        }
    }

}
