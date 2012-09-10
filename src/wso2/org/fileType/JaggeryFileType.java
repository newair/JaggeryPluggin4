package wso2.org.fileType;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.IconLoader;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;




public class JaggeryFileType extends LanguageFileType {


  public static final JaggeryFileType Jaggery_FILE_TYPE = new JaggeryFileType();
    /*  public static final com.intellij.lang.Language JAGGERY_LANGUAGE = Jaggery_FILE_TYPE.getLanguage();*/


  //  public  static final String DEFAULT = "jag";
    public static final Icon FILE_ICON = IconLoader.getIcon("monitor.png");

   // public static  LanguageFileType FILE_TYPE = new JaggeryFileType();

   // public static Language LANGUAGE = FILE_TYPE.getLanguage();

    @NonNls
    public static final String DEFAULT_EXTENSION = "jag";



    protected JaggeryFileType() {

        super(JaggeryLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "jaggery";  //To change body of implemented methods use File | Settings | File Templates.
    }


    @NotNull
    @Override
    public String getDescription() {
        return "jaggery";  //To change body of implemented methods use File | Settings | File Templates.
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return DEFAULT_EXTENSION;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Icon getIcon() {

     return FILE_ICON;


    }


    
}
