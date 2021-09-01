package javax.security.auth.kerberos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.security.Permission;
import java.security.PermissionCollection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

final class KrbServicePermissionCollection extends PermissionCollection implements Serializable {
  private List<Permission> perms = new ArrayList();
  
  private static final long serialVersionUID = -4118834211490102011L;
  
  private static final ObjectStreamField[] serialPersistentFields = { new ObjectStreamField("permissions", Vector.class) };
  
  public boolean implies(Permission paramPermission) {
    if (!(paramPermission instanceof ServicePermission))
      return false; 
    ServicePermission servicePermission = (ServicePermission)paramPermission;
    int i = servicePermission.getMask();
    if (i == 0) {
      for (Permission permission : this.perms) {
        ServicePermission servicePermission1 = (ServicePermission)permission;
        if (servicePermission1.impliesIgnoreMask(servicePermission))
          return true; 
      } 
      return false;
    } 
    int j = 0;
    int k = i;
    synchronized (this) {
      int m = this.perms.size();
      for (byte b = 0; b < m; b++) {
        ServicePermission servicePermission1 = (ServicePermission)this.perms.get(b);
        if ((k & servicePermission1.getMask()) != 0 && servicePermission1.impliesIgnoreMask(servicePermission)) {
          j |= servicePermission1.getMask();
          if ((j & i) == i)
            return true; 
          k = i ^ j;
        } 
      } 
    } 
    return false;
  }
  
  public void add(Permission paramPermission) {
    if (!(paramPermission instanceof ServicePermission))
      throw new IllegalArgumentException("invalid permission: " + paramPermission); 
    if (isReadOnly())
      throw new SecurityException("attempt to add a Permission to a readonly PermissionCollection"); 
    synchronized (this) {
      this.perms.add(0, paramPermission);
    } 
  }
  
  public Enumeration<Permission> elements() {
    synchronized (this) {
      return Collections.enumeration(this.perms);
    } 
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
    Vector vector = new Vector(this.perms.size());
    synchronized (this) {
      vector.addAll(this.perms);
    } 
    ObjectOutputStream.PutField putField = paramObjectOutputStream.putFields();
    putField.put("permissions", vector);
    paramObjectOutputStream.writeFields();
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
    ObjectInputStream.GetField getField = paramObjectInputStream.readFields();
    Vector vector = (Vector)getField.get("permissions", null);
    this.perms = new ArrayList(vector.size());
    this.perms.addAll(vector);
  }
}


/* Location:              D:\software\jd-gui\jd-gui-windows-1.6.3\rt.jar!\javax\security\auth\kerberos\KrbServicePermissionCollection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */