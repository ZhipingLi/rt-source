package com.sun.xml.internal.bind.v2.runtime.reflect.opt;

import com.sun.xml.internal.bind.DatatypeConverterImpl;
import com.sun.xml.internal.bind.api.AccessorException;
import com.sun.xml.internal.bind.v2.runtime.reflect.DefaultTransducedAccessor;
import org.xml.sax.SAXException;

public final class TransducedAccessor_method_Boolean extends DefaultTransducedAccessor {
  public String print(Object paramObject) { return DatatypeConverterImpl._printBoolean(((Bean)paramObject).get_boolean()); }
  
  public void parse(Object paramObject, CharSequence paramCharSequence) { ((Bean)paramObject).set_boolean(DatatypeConverterImpl._parseBoolean(paramCharSequence).booleanValue()); }
  
  public boolean hasValue(Object paramObject) { return true; }
}


/* Location:              D:\software\jd-gui\jd-gui-windows-1.6.3\rt.jar!\com\sun\xml\internal\bind\v2\runtime\reflect\opt\TransducedAccessor_method_Boolean.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */