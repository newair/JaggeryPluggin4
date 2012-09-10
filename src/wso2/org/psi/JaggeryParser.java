package wso2.org.psi;

import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiParser;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

public class JaggeryParser implements PsiParser{


   public JaggeryParser(){

       System.out.println("JaggeryParser created");
/*

       return new PsiParser() {
           @NotNull
           public ASTNode parse(IElementType root, PsiBuilder builder) {
               return new PlainTextFileElement(builder.getOriginalText());
           }
       };
*/

   }

    @NotNull
    @Override
    public ASTNode parse(IElementType root, PsiBuilder builder) {

/*
        System.out.println("in parser");

        builder.enforceCommentTokens(TokenSet.EMPTY);
        final PsiBuilder.Marker file = builder.mark();
                                builder.advanceLexer();





        if(builder.getTokenType() == JaggeryTokenTypes.BAD_CHARACTER){
            final PsiBuilder.Marker badchar =    builder.mark();

            builder.advanceLexer();

            if(builder.getTokenType() == JaggeryTokenTypes.VARIABLE){
                final PsiBuilder.Marker var =    builder.mark();

                var.done(JaggeryTokenTypes.VARIABLE);


             }


              badchar.done(JaggeryTokenTypes.BAD_CHARACTER);
        }



        file.done(iElementType);
        return builder.getTreeBuilt();
*/

        final PsiBuilder.Marker rootMarker = builder.mark();

        while (!builder.eof()) {
            IElementType token = builder.getTokenType();

            System.out.println(token.toString());

            if (token != null) {
                builder.mark().done(token);

                /*if(token == JaggeryTokenTypes.OUTERBRACKETS){

                    final PsiBuilder.Marker outerBrackets = builder.mark();
                    builder.advanceLexer();

                    while(builder.getTokenType() != JaggeryTokenTypes.OUTERBRACKETS){

                        builder.advanceLexer();

                     }
                }*/



            }


            builder.advanceLexer();



        }

        rootMarker.done(root);
        return builder.getTreeBuilt();


    }
}
