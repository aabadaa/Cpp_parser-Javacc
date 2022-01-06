package utils;

public class Variable implements Comparable<Variable>{
	public final String name;
	public final String type;
	private Value value;
	
	public Variable(String type,String name) {
		this.type = type;
		this.name = name;
		value =  new Value(type,Value.defaultValue(type));
	}
	public Variable(String type,String name,Value value) {
		this(type,name);
		setValue(value);
	}
	public Value getValue() {
		return value;
	}
	
	public Variable setValue(Value v) {
		v = value.cast(v);
		value = v;
		return this;
	}
	@Override
	public int compareTo(Variable o) {
		return name.compareTo(o.name);
	}
	
	@Override
	public String toString() {
		return type+" "+name+" "+value;
	}
	
}
