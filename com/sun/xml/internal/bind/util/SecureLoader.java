package com.sun.xml.internal.bind.util;

import java.security.AccessController;
import java.security.PrivilegedAction;

class SecureLoader {
  static ClassLoader getContextClassLoader() { return (System.getSecurityManager() == null) ? Thread.currentThread().getContextClassLoader() : (ClassLoader)AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() {
          public ClassLoader run() { return Thread.currentThread().getContextClassLoader(); }
        }); }
  
  static ClassLoader getClassClassLoader(final Class c) { return (System.getSecurityManager() == null) ? paramClass.getClassLoader() : (ClassLoader)AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() {
          public ClassLoader run() { return c.getClassLoader(); }
        }); }
  
  static ClassLoader getSystemClassLoader() { return (System.getSecurityManager() == null) ? ClassLoader.getSystemClassLoader() : (ClassLoader)AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() {
          public ClassLoader run() { return ClassLoader.getSystemClassLoader(); }
        }); }
}


/* Location:              D:\software\jd-gui\jd-gui-windows-1.6.3\rt.jar!\com\sun\xml\internal\bin\\util\SecureLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */