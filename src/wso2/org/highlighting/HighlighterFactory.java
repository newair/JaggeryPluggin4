package wso2.org.highlighting;

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import org.jetbrains.annotations.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: amila
 * Date: 6/19/12
 * Time: 10:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class HighlighterFactory extends SingleLazyInstanceSyntaxHighlighterFactory {


    @NotNull
    @Override
    protected SyntaxHighlighter createHighlighter() {

        System.out.println("syntaxhighlighter factory");

     try{


         return new SyntaxHighlightHandler();


    }catch(Exception e){

         System.out.println("message is "+ e.getMessage());
         return null;

    }


    }
}
