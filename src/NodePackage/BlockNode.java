package NodePackage;
import utils.Context;
import utils.JumpStmt;
public class BlockNode extends AbstractTreeNode {

	@Override
	public Object execute(Context context) {
		context = new Context(context);
		for (AbstractTreeNode n : children) {
			Object value = n.execute(context);
			if(value instanceof  JumpStmt)
				return value ;
		}
		return null;
	}
}
