package com.sun.jmx.snmp.IPAcl;

class JDMCommunity extends SimpleNode {
  protected String communityString = "";
  
  JDMCommunity(int paramInt) { super(paramInt); }
  
  JDMCommunity(Parser paramParser, int paramInt) { super(paramParser, paramInt); }
  
  public static Node jjtCreate(int paramInt) { return new JDMCommunity(paramInt); }
  
  public static Node jjtCreate(Parser paramParser, int paramInt) { return new JDMCommunity(paramParser, paramInt); }
  
  public String getCommunity() { return this.communityString; }
}


/* Location:              D:\software\jd-gui\jd-gui-windows-1.6.3\rt.jar!\com\sun\jmx\snmp\IPAcl\JDMCommunity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */