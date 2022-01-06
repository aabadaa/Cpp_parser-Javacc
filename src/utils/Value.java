package utils;

public class Value {
	public final String type;
	public final Object value;

	public Value(String type, Object value) {
		this.type = type;
		this.value = value;
	}

	@Override
	public String toString() {
		return "(" + type + " " + value + ")";
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Value == false)
			return false;
		Value v = (Value)o;
		return type.equals(v.type) && value.equals(v.value);
		
	}
	public Value cast(Value v) {
		if(type.equals(v.type))
			return v;
		switch (type) {
		case "string":
			return new Value(type, String.valueOf(v.value));
		case "double":
			if(v.value instanceof Number)
			return new Value(type, Double.parseDouble(String.valueOf(v.value)));
			else if(v.value instanceof Character)
				return new Value(type,Character.getNumericValue((Character)v.value));
			else
				return new Value(type,Double.parseDouble((String)v.value));
		case "int":
			if(v.value instanceof Number)
				return new Value(type, ((Number)v.value).intValue());
				else if(v.value instanceof Character)
					return new Value(type,Character.getNumericValue((Character)v.value));
				else
					return new Value(type,Integer.parseInt((String)v.value));
		case "char":
			return new Value(type, (char) v.value);
		case "bool":
			return new Value(type,!v.value.equals(0)&&v.value != null);
		default:
			throw new RuntimeException("cannot cast " + v.type + " to " + type);
		}
	}
	
	public static Object defaultValue(String type) {
		switch(type) {
		case "char":
			return (char)0;
		case "int":
			return 0;
		case"double":
			return 0.0;
		case "string":
			return "";
		case "bool":
			return false;
		}
		return "";
	}
}
