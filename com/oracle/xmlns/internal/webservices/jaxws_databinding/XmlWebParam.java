package com.oracle.xmlns.internal.webservices.jaxws_databinding;

import java.lang.annotation.Annotation;
import javax.jws.WebParam;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "web-param")
public class XmlWebParam implements WebParam {
  @XmlAttribute(name = "header")
  protected Boolean header;
  
  @XmlAttribute(name = "mode")
  protected WebParamMode mode;
  
  @XmlAttribute(name = "name")
  protected String name;
  
  @XmlAttribute(name = "part-name")
  protected String partName;
  
  @XmlAttribute(name = "target-namespace")
  protected String targetNamespace;
  
  public boolean isHeader() { return (this.header == null) ? false : this.header.booleanValue(); }
  
  public void setHeader(Boolean paramBoolean) { this.header = paramBoolean; }
  
  public WebParamMode getMode() { return (this.mode == null) ? WebParamMode.IN : this.mode; }
  
  public void setMode(WebParamMode paramWebParamMode) { this.mode = paramWebParamMode; }
  
  public String getName() { return (this.name == null) ? "" : this.name; }
  
  public void setName(String paramString) { this.name = paramString; }
  
  public String getPartName() { return (this.partName == null) ? "" : this.partName; }
  
  public void setPartName(String paramString) { this.partName = paramString; }
  
  public String getTargetNamespace() { return (this.targetNamespace == null) ? "" : this.targetNamespace; }
  
  public void setTargetNamespace(String paramString) { this.targetNamespace = paramString; }
  
  public String name() { return Util.nullSafe(this.name); }
  
  public String partName() { return Util.nullSafe(this.partName); }
  
  public String targetNamespace() { return Util.nullSafe(this.targetNamespace); }
  
  public WebParam.Mode mode() { return (WebParam.Mode)Util.nullSafe(this.mode, WebParam.Mode.IN); }
  
  public boolean header() { return ((Boolean)Util.nullSafe(this.header, Boolean.valueOf(false))).booleanValue(); }
  
  public Class<? extends Annotation> annotationType() { return WebParam.class; }
}


/* Location:              D:\software\jd-gui\jd-gui-windows-1.6.3\rt.jar!\com\oracle\xmlns\internal\webservices\jaxws_databinding\XmlWebParam.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */