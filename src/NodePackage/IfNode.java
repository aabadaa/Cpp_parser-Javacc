package NodePackage;

import utils.Context;
import utils.Value;

public class IfNode extends AbstractTreeNode {
	@Override
	public Object execute(Context context) {
		context = new Context(context);
		Value v = (Value) children.get(0).execute(context);

		if ((Boolean) v.value) {
			return children.get(1).execute(context);
		} else if (children.size() == 3) {
			return children.get(2).execute(context);
		}
		return null;
	}
}