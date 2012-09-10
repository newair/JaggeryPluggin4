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


/*line terminators */


  LineTerminator = \r|\n|\r\n
  InputCharacter = [^\r\n]

      WhiteSpace = {LineTerminator} | [ \t\f]+

    /* comments */


    TraditionalComment = "/*" [^*] ~"*/" | "/*" "*"+ "/"
    LineComment = "//" {InputCharacter}* {LineTerminator}

    /* identifiers */


    DecIntegerLiteral = 0 | [1-9][0-9]*




%state STRING



%%

     /*variables*/


     <YYINITIAL> {

     "request"  |
     "response" |
     "session"  |
     "application"  {return JaggeryTokenTypes.VARIABLE;}

     }



     <YYINITIAL> {

     "<%" |
     "%>"           {return JaggeryTokenTypes.OUTERBRACKETS;}
     
     }



    /*output*/


     <YYINITIAL> {

     "print"  |
     "Log"   {return JaggeryTokenTypes.OUTPUT;}

     }

      /*Http Client*/


          <YYINITIAL> {

         "get"  |
         "post" |
         "put"  |
         "del"  |
         "XMLHttpRequest" {return JaggeryTokenTypes.CLIENT;}


          }


       /*utils*/


       <YYINITIAL> {

         "URIMatcher"  |
         "include"       {return JaggeryTokenTypes.UTILS;}


        }



        /*Feed*/


        <YYINITIAL> {

         "Feed"  |
         "Entry"       {return JaggeryTokenTypes.FEED;}


         }



          /*File System*/


        <YYINITIAL> {


         "File"       {return JaggeryTokenTypes.FILESYS;}

        }






         /*Data Storage*/


         <YYINITIAL> {

         "Database"  |
         "MetadataStore"       {return JaggeryTokenTypes.STORAGE;}


         }



           /*Dataformats*/


           <YYINITIAL> {

            "parse"  |
            "stringify"|
            "XML"        {return JaggeryTokenTypes.DATAFORMAT;}


         }



          /*Add-ons*/


           <YYINITIAL> {


             "Sender"     |
             "WSRequest"  |
             "WSStub"     {return JaggeryTokenTypes.ADDONS;}



         }















<YYINITIAL>{
      {LineTerminator}     {return JaggeryTokenTypes.LINE_TERMINATOR;}
    {WhiteSpace} {return JaggeryTokenTypes.WHITE_SPACE;}
    {TraditionalComment}     {return JaggeryTokenTypes.BLOCKCOMMENT;}
    {LineComment}            {return JaggeryTokenTypes.LINECOMMENT;}


    {DecIntegerLiteral} {return JaggeryTokenTypes.INTEGER;}

    \"                   { yybegin(STRING); }

}




  <STRING> {
  \"      { yybegin(YYINITIAL);

            return JaggeryTokenTypes.STRING;


          }
   }



.    {
        yybegin(YYINITIAL);
        return JaggeryTokenTypes.BAD_CHARACTER; }





















