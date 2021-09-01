package org.omg.IOP;

import org.omg.CORBA.Any;
import org.omg.CORBA.BAD_PARAM;
import org.omg.CORBA.MARSHAL;
import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.CORBA.TypeCode;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;

public abstract class CodecFactoryHelper {
  private static String _id = "IDL:omg.org/IOP/CodecFactory:1.0";
  
  private static TypeCode __typeCode = null;
  
  public static void insert(Any paramAny, CodecFactory paramCodecFactory) {
    OutputStream outputStream = paramAny.create_output_stream();
    paramAny.type(type());
    write(outputStream, paramCodecFactory);
    paramAny.read_value(outputStream.create_input_stream(), type());
  }
  
  public static CodecFactory extract(Any paramAny) { return read(paramAny.create_input_stream()); }
  
  public static TypeCode type() {
    if (__typeCode == null)
      __typeCode = ORB.init().create_interface_tc(id(), "CodecFactory"); 
    return __typeCode;
  }
  
  public static String id() { return _id; }
  
  public static CodecFactory read(InputStream paramInputStream) { throw new MARSHAL(); }
  
  public static void write(OutputStream paramOutputStream, CodecFactory paramCodecFactory) { throw new MARSHAL(); }
  
  public static CodecFactory narrow(Object paramObject) {
    if (paramObject == null)
      return null; 
    if (paramObject instanceof CodecFactory)
      return (CodecFactory)paramObject; 
    throw new BAD_PARAM();
  }
  
  public static CodecFactory unchecked_narrow(Object paramObject) {
    if (paramObject == null)
      return null; 
    if (paramObject instanceof CodecFactory)
      return (CodecFactory)paramObject; 
    throw new BAD_PARAM();
  }
}


/* Location:              D:\software\jd-gui\jd-gui-windows-1.6.3\rt.jar!\org\omg\IOP\CodecFactoryHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */