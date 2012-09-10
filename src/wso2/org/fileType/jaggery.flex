package wso2.org;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;


%%



%public
%class _jaggery2
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{ return;
%eof}


%{
    private Stack<Integer> stack = new Stack<Integer>();

    public void yypushState(int newState) {
      stack.push(yystate());
      yybegin(newState);
    }

    public void yypopState() {
      yybegin(stack.pop());
    }
%}





/*line terminators */


  LineTerminator = \r|\n|\r\n
  InputCharacter = [^\r\n]

      WhiteSpace = {LineTerminator} | [ \t\f]+

    /* comments */


    TraditionalComment = "/*" [^*] ~"*/" | "/*" "*"+ "/"
    LineComment = "//" {InputCharacter}* {LineTerminator}

    /* identifiers */


    DecIntegerLiteral = 0 | [1-9][0-9]*

     SymbolOtherThanJaggery = .*



%state TAG_STARTED
%state VARIABLE
%state OUTPUTS
%state CLIENT
%state UTILS
%state FEED
%state FILE
%state DATASTORE
%state DATAFORMAT
%state ADDONS

%%

 /*
 	<YYINITIAL> {
        
       "<%"  {yypushState(TAG_STARTED); return JaggeryTokenTypes.OUTERBRACKETS;}


	}
   */
/*	<TAG_STARTED> {

           "%>"  {yypopState(); return JaggeryTokenTypes.OUTERBRACKETS;}

           {SymbolOtherThanJaggery}    { return JaggeryTokenTypes.JAVASCRIPT_TEXT; }

	}

  */

     /*variables*/







    /*output*/

   /*
     <TAG_STARTED,OUTPUTS> {

     "print"  |
     "Log"   {return JaggeryTokenTypes.OUTPUT;}

     }
          */
      /*Http Client*/

     /*
          <TAG_STARTED,CLIENT> {

         "get"  |
         "post" |
         "put"  |
         "del"  |
         "XMLHttpRequest" {return JaggeryTokenTypes.CLIENT;}


          }
                */

       /*utils*/


   /*    <TAG_STARTED,UTILS> {

         "URIMatcher"  |
         "include"       {return JaggeryTokenTypes.UTILS;}


        }


     */
        /*Feed*/

    /*
        <TAG_STARTED,FEED> {

         "Feed"  |
         "Entry"       {return JaggeryTokenTypes.FEED;}


         }

          */

          /*File System*/

    /*
        <TAG_STARTED,FILE> {


         "File"       {return JaggeryTokenTypes.FILESYS;}

        }

         */




         /*Data Storage*/

      /*
         <TAG_STARTED,DATASTORE> {

         "Database"  |
         "MetadataStore"       {return JaggeryTokenTypes.STORAGE;}


         }

         */

           /*Dataformats*/

       /*
           <TAG_STARTED,DATAFORMAT> {

            "parse"  |
            "stringify"|
            "XML"        {return JaggeryTokenTypes.DATAFORMAT;}


         }

        */

          /*Add-ons*/

     /*
           <TAG_STARTED,ADDONS> {


             "Sender"     |
             "WSRequest"  |
             "WSStub"     {return JaggeryTokenTypes.ADDONS;}



         }



          */











<YYINITIAL>{
      {LineTerminator}     {return JaggeryTokenTypes.LINE_TERMINATOR;}
    {WhiteSpace} {return JaggeryTokenTypes.WHITE_SPACE;}
    {TraditionalComment}     {return JaggeryTokenTypes.BLOCKCOMMENT;}
    {LineComment}            {return JaggeryTokenTypes.LINECOMMENT;}


    {DecIntegerLiteral} {return JaggeryTokenTypes.INTEGER;}

    \"                   { yybegin(STRING); }
    "<%"  {yypushState(TAG_STARTED); return JaggeryTokenTypes.OUTERBRACKETS;}

}



 <TAG_STARTED> {


           "%>"  {yypopState(); return JaggeryTokenTypes.OUTERBRACKETS;}

           {SymbolOtherThanJaggery}    { return JaggeryTokenTypes.JAVASCRIPT_TEXT; }




     "request"  |
     "response" |
     "session"  |
     "application"  {return JaggeryTokenTypes.VARIABLE;}


     "print"  |
     "Log"   {return JaggeryTokenTypes.OUTPUT;}


         "get"  |
         "post" |
         "put"  |
         "del"  |
         "XMLHttpRequest" {return JaggeryTokenTypes.CLIENT;}


     "URIMatcher"  |
     "include"            {return JaggeryTokenTypes.UTILS;}

      "Feed"  |
      "Entry"             {return JaggeryTokenTypes.FEED;}


      "File"              {return JaggeryTokenTypes.FILESYS;}

      "Database"  |
      "MetadataStore"     {return JaggeryTokenTypes.STORAGE;}


       "parse"  |
       "stringify"|
       "XML"              {return JaggeryTokenTypes.DATAFORMAT;}


       "Sender"     |
       "WSRequest"  |
       "WSStub"           {return JaggeryTokenTypes.ADDONS;}


     }
















 /* <STRING> {
  \"      { yybegin(YYINITIAL);

            return JaggeryTokenTypes.STRING;


          }
   }

*/


.    {
        yybegin(YYINITIAL);
        return JaggeryTokenTypes.BAD_CHARACTER; }






















