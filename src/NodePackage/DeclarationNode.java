package NodePackage;
import java.util.*;
import utils.*;
public class DeclarationNode extends AbstractTreeNode {
	private String type;
	private ArrayList<Pair<String,AbstractTreeNode>>vars =new ArrayList<>();
	public void addVar(String name,AbstractTreeNode value) {
		vars.add(new Pair<String, AbstractTreeNode>(name,value));
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public Object execute(Context context) {
        for (Pair<String,AbstractTreeNode> var : vars) {
        	AbstractTreeNode child = var.second;
        	Value value = (Value)(child!=null?child.execute(context):new Value(type,Value.defaultValue(type)));
        	context.addVar(new Variable(type,var.first,value));
        }
        	return null;
	}
	
	
	
}
