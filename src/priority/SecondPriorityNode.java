package priority;

import NodePackage.AbstractTreeNode;
import utils.Context;
import utils.Value;

public class SecondPriorityNode extends PriorityNode {

	@Override
	public Value execute(Context context) {
		Value v = (Value) children.get(0).execute(context);
		for (int i = 0; i < operators.size(); i++) {
			String operator = operators.get(i);
			Value v1 = (Value) children.get(i + 1).execute(context);
			switch (operator) {
			case "+":
				if (v.type.equals("string") || v1.type.equals("string")) {
					v = new Value("string",  v.value.toString() + v1.value.toString());
				}
				else if (v.type.equals("double")) {
					v1 = v.cast(v1);
					v = new Value("double", (double) v.value + (double) v1.value);
				}
				else if (v.type.equals("int")) {
					v1 = v.cast(v1);
					v = new Value("int", (int) v.value + (int) v1.value);
				}
				else
					throw new RuntimeException("typeError " + v1.value);
				break;
			case "-":
				if (v.type.equals("double")) {
					v1 = v.cast(v1);
					v = new Value("double", (double) v.value -(double) v1.value);
				}
				else if (v.type.equals("int")) {
					v1 = v.cast(v1);
					v = new Value("int", (int) v.value -(int) v1.value);
				}
				else
					throw new RuntimeException("typeError " + v.type);
				break;
			}
		}
		return v;
	}
}
