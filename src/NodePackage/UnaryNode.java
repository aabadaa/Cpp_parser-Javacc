package NodePackage;

import utils.*;

public class UnaryNode extends AbstractTreeNode {

	private String operator;

	public void setOperator(String op) {
		this.operator = op;
	}

	@Override
	public Object execute(Context context) {
		Value v = (Value) children.get(0).execute(context);
		switch (operator) {
		case "-":
			if (v.type.equals("int"))
				v = new Value(v.type, -(Integer) v.value);
			else if (v.type.equals("double"))
				v = new Value(v.type, -(Double) v.value);
			else
				throw new RuntimeException("type error with unary -" + v.type);
			break;
		case "+":
			if (!(v.type.equals("int") || v.type.equals("double")))
				throw new RuntimeException("type error with unary -" + v.type);
			break;
		case "!":
			v = new Value("bool",null).cast(v);
			v = new Value("bool",!(Boolean)v.value);
		}
		return v;
	}

}
