package NodePackage;
import java.util.Map;

import utils.*;
public class VariableNode extends AbstractTreeNode {
	String id;


	public void setValue(String id) {
		this.id = id;
	}

	@Override
	public Value execute(Context context) {
//		for (String key : context.getVars().keySet())
//			System.out.print(key+" ");
		Variable out =context.getVar(id);
		if(out == null)
			throw new RuntimeException("variable \'"+id+"\' is not declared");
		return out.getValue() ;
	}
}