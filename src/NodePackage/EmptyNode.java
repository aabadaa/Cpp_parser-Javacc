package NodePackage;

import utils.Context;
import utils.Value;

public class EmptyNode  extends AbstractTreeNode {
	
	@Override
	public Object execute(Context context) {
		return new Value("bool",true);
	}
}
