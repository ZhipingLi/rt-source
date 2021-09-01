package com.sun.xml.internal.stream.dtd.nonvalidating;

import com.sun.org.apache.xerces.internal.xni.QName;

public class XMLElementDecl {
  public static final short TYPE_ANY = 0;
  
  public static final short TYPE_EMPTY = 1;
  
  public static final short TYPE_MIXED = 2;
  
  public static final short TYPE_CHILDREN = 3;
  
  public static final short TYPE_SIMPLE = 4;
  
  public final QName name = new QName();
  
  public int scope = -1;
  
  public short type = -1;
  
  public final XMLSimpleType simpleType = new XMLSimpleType();
  
  public void setValues(QName paramQName, int paramInt, short paramShort, XMLSimpleType paramXMLSimpleType) {
    this.name.setValues(paramQName);
    this.scope = paramInt;
    this.type = paramShort;
    this.simpleType.setValues(paramXMLSimpleType);
  }
  
  public void clear() {
    this.name.clear();
    this.type = -1;
    this.scope = -1;
    this.simpleType.clear();
  }
}


/* Location:              D:\software\jd-gui\jd-gui-windows-1.6.3\rt.jar!\com\sun\xml\internal\stream\dtd\nonvalidating\XMLElementDecl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */