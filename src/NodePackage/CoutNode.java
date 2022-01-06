package NodePackage;

import utils.*;

public class CoutNode extends AbstractTreeNode{

	@Override
	public Object execute(Context context) {
		children.forEach(out -> {
			Value v = (Value)out.execute(context);
			if(v.type.equals("bool"))
			      System.out.print((Boolean)v.value?1:0);
			else
			        System.out.print(v.value);
		});
		return null;
	}
}
