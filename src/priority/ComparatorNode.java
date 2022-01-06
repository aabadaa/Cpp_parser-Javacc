package priority;

import NodePackage.AbstractTreeNode;
import utils.*;
//third priority
public class ComparatorNode extends AbstractTreeNode {
	String operator;

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Override
	public Value execute(Context context) {
		Value v1 = (Value) children.get(0).execute(context), 
				v2 = (Value) children.get(1).execute(context);
		v2 = v1.cast(v2);
		// todo we have to check type , may we cannot compare string with boolean
		Object d1 = v1.value;
		Object d2 = v2.value;
		switch (operator) {
		case ">":
			return new Value("bool", compare(d1, d2) > 0);
		case ">=":
			return new Value("bool", compare(d1, d2) >=0 );
		case "<":
			return new Value("bool", compare(d1, d2) <0);
		case "<=":
			return new Value("bool",compare(d1, d2) <=0);
		case "==":
			return new Value("bool", compare(d1, d2) ==0 || d1.equals(d2));
		case "!=":
			return new Value("bool", compare(d1, d2) !=0 || !d1.equals(d2));
		}
		return null;
	}

	int compare(Object o1, Object o2) {
		Comparable a1 = (Comparable) o1;
		Comparable a2 = (Comparable) o2;
		return a1.compareTo(a2);
	}
}
