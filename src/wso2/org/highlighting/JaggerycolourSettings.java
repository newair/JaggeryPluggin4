package wso2.org.highlighting;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import wso2.org.fileType.JaggeryFileType;

import javax.swing.*;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: amila
 * Date: 7/6/12
 * Time: 12:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class JaggerycolourSettings implements ColorSettingsPage {


    private static final AttributesDescriptor[] ATTRS = new AttributesDescriptor[]{

            new AttributesDescriptor("Variable", SyntaxHighlightHandler.VARIABLE),
            new AttributesDescriptor("Integer", SyntaxHighlightHandler.INTEGER),







    };











    @Override
    public Icon getIcon() {
        return JaggeryFileType.FILE_ICON;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new SyntaxHighlightHandler();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "ewewe request";  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return ATTRS;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return  ColorDescriptor.EMPTY_ARRAY;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Jaggery";  //To change body of implemented methods use File | Settings | File Templates.
    }
}
