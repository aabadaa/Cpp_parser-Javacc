package priority;
import java.util.*;
//forth priority

import NodePackage.AbstractTreeNode;
import utils.Context;
import utils.Value;
public class LogicalNode extends AbstractTreeNode {
	private final ArrayList<String>operators = new ArrayList<String>();
	public void addOperator(String operator) {
		operators.add(operator);
	}
	@Override
	public Value execute(Context context) {
		Value v = (Value)children.get(0).execute(context);
		boolean out = (boolean)v.value;
		for(int i = 0 ; i < operators.size(); i++) {
			boolean breaker = false;// if there is true|| , breaker becomes true and end this loop
			String operator = operators.get(i);
			switch(operator) {
			case "&&":
				if(out) {
					Value operand = (Value)children.get(i+1).execute(context);
					out = out && (Boolean)operand.value;
				}
				break;
			case "||":
				if(out)
					breaker = true;
				else {
					Value operand = (Value)children.get(i+1).execute(context);
					out =(Boolean)operand.value;
					//if execution reaches  here ==> out = false , false||x = x that's why out = ... instead of out = out || ...
				}
				break;
			case "!":
				// this should be executed only when this object has one operator which is (!) 
				out = ! out;
				break;
			}
		}
		return new Value("bool",out);
	}

}
