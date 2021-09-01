package com.oracle.xmlns.internal.webservices.jaxws_databinding;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "web-param-mode")
@XmlEnum
public static enum WebParamMode {
  IN, OUT, INOUT;
  
  public String value() { return name(); }
  
  public static WebParamMode fromValue(String paramString) { return valueOf(paramString); }
}


/* Location:              D:\software\jd-gui\jd-gui-windows-1.6.3\rt.jar!\com\oracle\xmlns\internal\webservices\jaxws_databinding\WebParamMode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */