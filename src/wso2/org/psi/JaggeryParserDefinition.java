package wso2.org.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import wso2.org.JaggeryTokenTypes;
import wso2.org.fileType.JaggeryFileType;
import wso2.org.fileType.JaggeryLanguage;
import wso2.org.jaggeryFlexAdapter;

import java.io.FileNotFoundException;


public class JaggeryParserDefinition implements ParserDefinition {

    private static final IFileElementType LANGUAGE_FILE_TYPE = new IFileElementType(JaggeryLanguage.INSTANCE);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {

        System.out.println("lexer created");


        try {
            return new  jaggeryFlexAdapter();  //To change body of implemented methods use File | Settings | File Templates.
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.

            return null;
        }

    }

    @Override
    public PsiParser createParser(Project project) {

        System.out.println("in create parser");
        return new JaggeryParser();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IFileElementType getFileNodeType() {

        System.out.println("file node");

        return LANGUAGE_FILE_TYPE;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @NotNull
    @Override
    public TokenSet getWhitespaceTokens() {

        System.out.println("white space tokens");
        return JaggeryTokenTypes.WHITE_SPACES;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {

        System.out.println("comment tokens"+Thread.currentThread().getName());

        return JaggeryTokenTypes.COMMENTS;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {

        System.out.println("string literal");
        return JaggeryTokenTypes.STRINGS;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode astNode) {

        System.out.println("in create element");
       return new JaggeryElementImpl(astNode);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public PsiFile createFile(FileViewProvider fileViewProvider) {

        System.out.println("create file");
        return new PsiFileBase(fileViewProvider, JaggeryLanguage.INSTANCE) {
            @NotNull
            public com.intellij.openapi.fileTypes.FileType getFileType() {
                return JaggeryFileType.Jaggery_FILE_TYPE;
            }
        };    }

    @Override
    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode astNode, ASTNode astNode1) {

        System.out.println("in space requirements");
        return SpaceRequirements.MAY;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
