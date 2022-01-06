package NodePackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import utils.Context;
import utils.Value;
import utils.Variable;

public class CinNode extends AbstractTreeNode{
	
	public List<String>vars = new ArrayList<String>();
	
	@Override
	public Object execute(Context context) {
		Scanner s = new Scanner(System.in);
		vars.forEach(var -> {
			if(!context.isDeclared(var)) {
				throw new RuntimeException("variable \'" + var + "\' is not declared");
			}
		Variable variable = context.getVar(var);
			switch(variable.type) {
				case "string": {
					Value value = new Value("string", s.next());
					context.getVar(var).setValue(value);
					break;
				}
				case "int": {
					Value value = new Value("int", s.nextInt());
					context.getVar(var).setValue(value);
					break;		
				}
				case "double": {
					Value value = new Value("double", s.nextDouble());
					context.getVar(var).setValue(value);
					break;
				}
				case "bool": {
					Value value = new Value("bool", s.nextBoolean());
					context.getVar(var).setValue(value);
					break;
				}
				case "char": {
					Value value = new Value("char", s.nextLine().charAt(0));
					context.getVar(var).setValue(value);
					break;
				}
				case "float": {
					Value value = new Value("float", s.nextFloat());
					context.getVar(var).setValue(value);
					break;
				}
				case "long": {
					Value value = new Value("long", s.nextLong());
					context.getVar(var).setValue(value);
					break;		
				}
				
			}
		});
		
		return null;
	}
	
	

}
