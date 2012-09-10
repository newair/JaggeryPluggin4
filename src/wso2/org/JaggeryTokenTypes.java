package wso2.org;

import com.intellij.psi.TokenType;
import com.intellij.psi.templateLanguages.TemplateDataElementType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import wso2.org.fileType.JaggeryLanguage;


public interface JaggeryTokenTypes {





    /**
     * predefined token types
     */


    public static final IElementType TEMPLATE_JAVASCRIPT_TEXT = new JaggeryElementType("TEMPLATE_JAVASCRIPT_TEXT"); // produced by lexer for all Javascript code

    public static final IElementType OUTER_ELEMENT_TYPE = new JaggeryElementType("OUTER_ELEMENT_TYPE");

    public static  TemplateDataElementType TEMPLATE_DATA =

    new TemplateDataElementType("JAGGERY_TEMPLATE_DATA", JaggeryLanguage.INSTANCE, TEMPLATE_JAVASCRIPT_TEXT, OUTER_ELEMENT_TYPE);




    public static final IElementType WHITE_SPACE = TokenType.WHITE_SPACE;

    public static final IElementType JAVASCRIPT_TEXT = TEMPLATE_JAVASCRIPT_TEXT;

    TokenSet WHITE_SPACES = TokenSet.create(WHITE_SPACE)  ;

    public static final  IElementType BAD_CHARACTER = TokenType.BAD_CHARACTER;





    /**
     *  jaggery specific token types
     */


    public static final IElementType VARIABLE = new JaggeryElementType("VARIABLE");
    public static final IElementType DATAFORMAT = new JaggeryElementType("DATAFORMAT");
    public static final IElementType FEED = new JaggeryElementType("FEED");
    public static final IElementType FILESYS = new JaggeryElementType("FILESYS");
    public static final IElementType STORAGE = new JaggeryElementType("STORAGE");
    public static final IElementType CLIENT = new JaggeryElementType("CLIENT");
    public static final IElementType ADDONS = new JaggeryElementType("ADDONS");
    public static final IElementType UTILS = new JaggeryElementType("UTILS");
    public static final IElementType OUTPUT = new JaggeryElementType("OUTPUT");
    public static final IElementType OUTERBRACKETS = new JaggeryElementType("OUTERBRACKETS");
    public static final IElementType SEMICOLON = new JaggeryElementType("SEMICOLON");
    public static final IElementType PERIOD = new JaggeryElementType("PERIOD");
    public static final IElementType CLOSSINGBRACKETS = new JaggeryElementType("CLOSSINGBRACKETS");
    public static final IElementType OPENINGBRACKETS = new JaggeryElementType("OPENINGBRACKETS");
    public static final IElementType VARIABLEMETHOD = new JaggeryElementType("VARIABLEMETHOD");

    public static final IElementType STRING =      new JaggeryElementType("STRING");
    public static final IElementType BLOCKCOMMENT = new JaggeryElementType("BLOCKCOMMENT");
    public static final IElementType LINECOMMENT = new JaggeryElementType("LINECOMMENT");

    public static final IElementType LINE_TERMINATOR = new JaggeryElementType("LINE_TERMINATOR");

    public static TokenSet STRINGS = TokenSet.create(STRING);

    public static TokenSet COMMENTS = TokenSet.create(

            LINECOMMENT

    );

public static final IElementType INTEGER= new JaggeryElementType("INTEGER");



}
