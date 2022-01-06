package priority;

import NodePackage.AbstractTreeNode;
import utils.Context;
import utils.Value;
//this do multiplication and division
public class FirstPriorityNode extends PriorityNode{

	@Override
	public Value execute(Context context) {
		Value v = (Value)children.get(0).execute(context);
		for (int i = 0; i < operators.size(); i++) {
			String operator = operators.get(i);
			Value v1 =(Value) children.get(i + 1).execute(context);
			switch (operator) {
			case "*":
				v1 = v.cast(v1);
				if (v.type.equals("double")) {
					v = new Value("double", (double) v.value * (double) v1.value);
				}
				else if (v.type.equals("int")) {
					v = new Value("int", (int) v.value * (int) v1.value);
				}
				break;
			case "/":
				v1 = v.cast(v1);
				if (v.type.equals("double")) {
					v = new Value("double", (double) v.value / (double) v1.value);
				}
				else if (v.type.equals("int")) {
					v = new Value("int", (int) v.value / (int) v1.value);
				}				break;
			case "%":
				v1 = v.cast(v1);
				if (v.type.equals("double")) {
					v = new Value("double", (double) v.value % (double) v1.value);
				}
				else if (v.type.equals("int")) {
					v = new Value("int", (int) v.value % (int) v1.value);
				}
				break;
			}
		}
		return  v;
	}
	

}
