package com.sun.xml.internal.bind.v2.runtime.reflect.opt;

import com.sun.xml.internal.bind.v2.runtime.reflect.Accessor;

public class MethodAccessor_Float extends Accessor {
  public MethodAccessor_Float() { super(Float.class); }
  
  public Object get(Object paramObject) { return Float.valueOf(((Bean)paramObject).get_float()); }
  
  public void set(Object paramObject1, Object paramObject2) { ((Bean)paramObject1).set_float((paramObject2 == null) ? Const.default_value_float : ((Float)paramObject2).floatValue()); }
}


/* Location:              D:\software\jd-gui\jd-gui-windows-1.6.3\rt.jar!\com\sun\xml\internal\bind\v2\runtime\reflect\opt\MethodAccessor_Float.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */