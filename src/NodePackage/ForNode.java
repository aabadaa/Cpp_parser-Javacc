package NodePackage;

import utils.*;

public class ForNode extends AbstractTreeNode
{
	@Override
	public Object execute(Context context) {
		context = new Context(context);
		children.get(0).execute(context);//move from for(here;...) to this line to execute before cond
		Value v = (Value)children.get(1).execute(context);
	
		for ( ; (Boolean)v.value ; children.get(2).execute(context)) {
			v = (Value)children.get(1).execute(context);	
		    Object x = children.get(3).execute(context);
		    if(JumpStmt.BREAK.equals(x))
		    	break;
		}
		return null;
	}
}
