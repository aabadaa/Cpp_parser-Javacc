package NodePackage;

import utils.Context;
import utils.JumpStmt;

public class DefaultNode extends AbstractTreeNode {
	@Override
	public Object execute(Context context) {
		System.out.println("default executed");
		if (children.get(0) == null)
			return null;
		return children.get(0).execute(context);
	}
}
