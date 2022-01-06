package NodePackage;

import java.util.ArrayList;

import utils.*;

public class AssignNode extends AbstractTreeNode {

	private String id;
	private String operator;

	public void setVar(String id) {
		this.id = id;
	}

	public void setOperator(String op) {
		this.operator = op;
	}

	@Override
	public Value execute(Context context) {
		Value v = null;

		if (!context.isDeclared(id))
			throw new RuntimeException("variable \'" + id + "\' is not declared");
		if (children.get(0) != null) {
			Variable var = context.getVar(id);
			 v = var.getValue();
			Value v1 = (Value) children.get(0).execute(context);
			
			switch(operator) {
			case "*=":
				v1 = v.cast(v1);
				if (v.type.equals("double")) {
					v = new Value("double", (double) v.value * (double) v1.value);
				}
				else if (v.type.equals("int")) {
					v = new Value("int", (int) v.value * (int) v1.value);
				}
				break;
			case "/=":
				v1 = v.cast(v1);
				if (v.type.equals("double")) {
					v = new Value("double", (double) v.value / (double) v1.value);
				}
				else if (v.type.equals("int")) {
					v = new Value("int", (int) v.value / (int) v1.value);
				}				break;
			case "%=":
				v1 = v.cast(v1);
				if (v.type.equals("double")) {
					v = new Value("double", (double) v.value % (double) v1.value);
				}
				else if (v.type.equals("int")) {
					v = new Value("int", (int) v.value % (int) v1.value);
				}
				break;
			case "+=":
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
			case "-=":
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
			case "=":
				v =v1;
			}	
			
			
			var.setValue(v);
			
		}
		return v;
}
	}
