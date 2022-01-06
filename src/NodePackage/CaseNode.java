package NodePackage;

import utils.Context;
import utils.JumpStmt;

public class CaseNode extends AbstractTreeNode{
    private Object val = -1;
    
    @Override
    public Object execute(Context context) {
            System.out.println("case "+val+ " executed");
            
       if(children.get(1) == null)
    	   return null;
       return children.get(1).execute(context);
    }

    public Object getFirstChild(Context context){
       return val = (Object) children.get(0).execute(context);
    }
}
