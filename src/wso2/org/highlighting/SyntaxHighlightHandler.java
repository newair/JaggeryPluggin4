package wso2.org.highlighting;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.SyntaxHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import gnu.trove.THashMap;
import org.jetbrains.annotations.NotNull;
import wso2.org.JaggeryTokenTypes;
import wso2.org.jaggeryFlexAdapter;

import java.awt.*;
import java.io.FileNotFoundException;

/**
 * Created with IntelliJ IDEA.
 * User: amila
 * Date: 6/8/12
 * Time: 1:00 PM
 * To change this template use File | Settings | File Templates.
 */

public class SyntaxHighlightHandler extends SyntaxHighlighterBase {


           //set syntax highlighter colors
    static {

      //  SyntaxHighlighterColors.NUMBER.getDefaultAttributes().setEffectColor(new Color(29, 100, 15));

               SyntaxHighlighterColors.NUMBER.getDefaultAttributes().setEffectColor(new Color(29, 100, 15));

    }





    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        try {

            System.out.println("in method gethighlighting lexer");
            return new jaggeryFlexAdapter();  //To change body of implemented methods use File | Settings | File Templates.
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.

            return null;

        }
    }

    public static final TextAttributesKey VARIABLE = TextAttributesKey.createTextAttributesKey(
            "JAGGERY.VARIABLE",
            SyntaxHighlighterColors.KEYWORD.getDefaultAttributes()
    );


    public static final TextAttributesKey INTEGER = TextAttributesKey.createTextAttributesKey(
            "JAGGERY.INTEGER",
            SyntaxHighlighterColors.NUMBER.getDefaultAttributes()


    );
    public static final TextAttributesKey LINECOMMENT = TextAttributesKey.createTextAttributesKey(
            "JAGGERY.LINECOMMENT",
            SyntaxHighlighterColors.LINE_COMMENT.getDefaultAttributes()


    );
    public static final TextAttributesKey BLOCKCOMMENT = TextAttributesKey.createTextAttributesKey(
            "JAGGERY.BLOCKCOMMENT",
            SyntaxHighlighterColors.JAVA_BLOCK_COMMENT.getDefaultAttributes()


    );

    public static final TextAttributesKey OUTERBRACKETS = TextAttributesKey.createTextAttributesKey(
            "JAGGERY.OUTERBRACKETS",
            SyntaxHighlighterColors.BRACKETS.getDefaultAttributes()
    );

    public static final TextAttributesKey STRING = TextAttributesKey.createTextAttributesKey(
            "",
            SyntaxHighlighterColors.BRACKETS.getDefaultAttributes()
    );





    /*public static final TextAttributesKey DATAFORMAT = TextAttributesKey.createTextAttributesKey(
            "JAGGERY.DATAFORMAT",
            SyntaxHighlighterColors.DATAFORMAT.getDefaultAttributes()


    );

    public static final TextAttributesKey VARIABLE = TextAttributesKey.createTextAttributesKey(
            "JAGGERY.VARIABLE",
            SyntaxHighlighterColors.KEYWORD.getDefaultAttributes()
    );*/





   /* public static final TextAttributesKey JAGGERY_VALUE = TextAttributesKey.createTextAttributesKey(
            "JAGGERY.VALUE",
            SyntaxHighlighterColors.STRING.getDefaultAttributes()



    );


    public static final TextAttributesKey JAGGERY_DOCCOMMENT = TextAttributesKey.createTextAttributesKey(
            "JAGGERY.DOCCOMMENT",
            SyntaxHighlighterColors.DOC_COMMENT.getDefaultAttributes()



    );*/

 private static THashMap<IElementType,TextAttributesKey> keys1;

    static {

         keys1 = new THashMap<IElementType,TextAttributesKey>();



        keys1.put(JaggeryTokenTypes.VARIABLE, VARIABLE);
        keys1.put(JaggeryTokenTypes.INTEGER, INTEGER);
        keys1.put(JaggeryTokenTypes.BLOCKCOMMENT, BLOCKCOMMENT);
        keys1.put(JaggeryTokenTypes.LINECOMMENT, LINECOMMENT);
        keys1.put(JaggeryTokenTypes.OUTERBRACKETS,OUTERBRACKETS);
      //  keys1.put(JaggeryTokenTypes.VALUE_CHARACTERS, JAGGERY_VALUE);
    }


    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType iElementType) {

        System.out.println("in test Attributes");

        return pack(keys1.get(iElementType));


    }






















}
