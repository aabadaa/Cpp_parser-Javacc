package NodePackage;
import utils.*;
public class ConstantNode extends AbstractTreeNode {
	Value value;
	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}

	@Override
	public Object execute(Context context) {
		return value;
	}
}
