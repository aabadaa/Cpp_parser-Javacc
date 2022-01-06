package NodePackage;
import java.util.*;

import utils.Context;
public abstract class AbstractTreeNode {
	protected String name = getClass().getSimpleName();

	public String getName() {
		return name;
	}

	protected ArrayList<AbstractTreeNode> children = new ArrayList<AbstractTreeNode>();

	public ArrayList<AbstractTreeNode> getChildren() {
		return children;
	}

	public void addChild(AbstractTreeNode child) {
		children.add(child);
	}

	public abstract Object execute(Context context);
	
	@Override
	public String toString() {
		return name;
	}
	
}
