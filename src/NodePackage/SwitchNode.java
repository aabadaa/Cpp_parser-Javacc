package NodePackage;

import utils.JumpStmt;
import utils.*;

import java.util.*;

import priority.ComparatorNode;

public class SwitchNode extends AbstractTreeNode {
	@Override
	public Object execute(Context context) {

		System.out.println("switch executed");
		boolean found = false;
		Value value1 = (Value) children.get(0).execute(context);
		// check for string switch

		if (value1.type == "string") {
			throw new RuntimeException("switch quantity not an integer\n");
		}

		int dIndex = -1;

		ArrayList<Value> values = new ArrayList<Value>();
		values.add(null);
		for (int i = 1; i < children.size(); i++) {
			// get cases values
			//if (children.get(i).children.size() == 2) {
			if(children.get(i) instanceof CaseNode) {
				CaseNode node = (CaseNode) children.get(i);
				Value value = (Value) node.getFirstChild(context);

				// check for string case
				if (value.type == "string") {
					throw new RuntimeException("case quantity not an integer\n");
				}
				if(values.contains(value))
					throw new RuntimeException("duplicate case value " + value.value);
				values.add(value);
			}
			// get default value
			//else if (children.get(i).children.size() == 1) {
			else if (children.get(i) instanceof DefaultNode) {
				values.add(null);
				dIndex = i;
			}
		}

		for (int i = 1; i < children.size(); i++) {
			// check for matching cases

			if (values.get(i) != null && !found && values.get(i).equals(value1)) {

				found = true;
				Object statement = children.get(i).execute(context);
				if (JumpStmt.BREAK.equals(statement))
					break;
				else if(JumpStmt.CONTINUE.equals(statement))
					return statement;
			}

			// execute cases + default if there wasn't any break keyword yet after a match
			else if (found) {
				Object statement = children.get(i).execute(context);
				if (JumpStmt.BREAK.equals(statement))
					break;
				else if(JumpStmt.CONTINUE.equals(statement))
					return statement;
			}
		}

		// execute default + later cases if there wasn't any match
		if (dIndex != -1 && !found) {
			for (int i = dIndex; i < children.size(); i++) {
				Object statement = children.get(i).execute(context);
				if (JumpStmt.BREAK.equals(statement))
					break;
				else if(JumpStmt.CONTINUE.equals(statement))
					return statement;
			}
		}
		return null;
	}
	
}