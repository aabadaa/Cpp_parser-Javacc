package priority;

import NodePackage.AbstractTreeNode;
import utils.Context;

import java.util.*;
public abstract class PriorityNode extends AbstractTreeNode{
	
	protected ArrayList<String>operators = new ArrayList<>();
	
	public void addOperator(String op) {
		operators.add(op);
	}
}
