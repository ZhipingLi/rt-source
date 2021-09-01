package com.sun.corba.se.spi.monitoring;

public abstract class StringMonitoredAttributeBase extends MonitoredAttributeBase {
  public StringMonitoredAttributeBase(String paramString1, String paramString2) {
    super(paramString1);
    MonitoredAttributeInfoFactory monitoredAttributeInfoFactory = MonitoringFactories.getMonitoredAttributeInfoFactory();
    MonitoredAttributeInfo monitoredAttributeInfo = monitoredAttributeInfoFactory.createMonitoredAttributeInfo(paramString2, String.class, false, false);
    setMonitoredAttributeInfo(monitoredAttributeInfo);
  }
}


/* Location:              D:\software\jd-gui\jd-gui-windows-1.6.3\rt.jar!\com\sun\corba\se\spi\monitoring\StringMonitoredAttributeBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */