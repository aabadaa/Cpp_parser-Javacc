package NodePackage;

import utils.*;

public class DoWhileNode extends AbstractTreeNode {
	@Override
	public Object execute(Context context) {
		context = new Context(context);
		Value v=null;
		do {
			Object o = children.get(0).execute(context);
			if (JumpStmt.BREAK.equals(o))
				break;
			v = (Value) children.get(1).execute(context);
		} while ((Boolean) v.value);
		return null;
	}
}
