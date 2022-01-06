package NodePackage;
import utils.*;
public class WhileNode extends AbstractTreeNode
{
	@Override
	public Object execute(Context context) {
		context = new Context(context);
		Value v = (Value)children.get(0).execute(context);
		while ((Boolean)(v.value) ) {
			v = (Value)children.get(0).execute(context);
			JumpStmt statement =(JumpStmt) children.get(1).execute(context);
			if(statement == JumpStmt.BREAK)
				break;
		}
		return null;
	}
}
