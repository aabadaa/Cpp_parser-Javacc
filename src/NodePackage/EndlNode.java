package NodePackage;
import utils.Context;
import utils.Value;
public class EndlNode extends AbstractTreeNode{

	@Override
	public Object execute(Context context) {
		return new Value("string","\n");
	}

}
