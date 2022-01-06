package utils;

import java.util.*;

public class Context {
	
	private Context parent = null;
	private Map<String,Variable> vars = new TreeMap<>();
	public static Set<String> types = new HashSet<String>();
	static{
		types.addAll(Arrays.asList("string", "int", "double", "bool", "char"));
	}
	public Context() {}
	public Context(Context parent) {
		this.parent = parent;
	}
	
	public Variable getVar(String name) {
		Variable out = vars.get(name);
		if(out == null)
			out = parent!=null?parent.getVar(name):null;
		return out ;
	}
	
	public boolean isDeclared(String name) {
		return getVar(name)!=null;
	}
	public Set<String> getTypes() {
		return types;
	}

	public void addVar(Variable v) {
		assert(v != null);
		if(vars.containsKey(v.name))
			throw new RuntimeException("Variable \'"+v.name+"\' is already declared");
		vars.put(v.name,v);
	}

}
