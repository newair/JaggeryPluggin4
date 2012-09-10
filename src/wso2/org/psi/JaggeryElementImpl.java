package wso2.org.psi;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: amila
 * Date: 7/2/12
 * Time: 2:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class JaggeryElementImpl extends ASTWrapperPsiElement implements JaggeryElement {

    private final ASTNode astNode;


    public JaggeryElementImpl(@NotNull ASTNode node) {
        super(node);

        this.astNode = node;
    }

    @NotNull
    @Override
    public ASTNode parse(IElementType iElementType, PsiBuilder psiBuilder) {




        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public String toString(){
        return "Element type is "+ astNode.getElementType().toString();

    }


}
