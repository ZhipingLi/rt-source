package com.sun.org.apache.bcel.internal.generic;

public class LASTORE extends ArrayInstruction implements StackConsumer {
  public LASTORE() { super((short)80); }
  
  public void accept(Visitor paramVisitor) {
    paramVisitor.visitStackConsumer(this);
    paramVisitor.visitExceptionThrower(this);
    paramVisitor.visitTypedInstruction(this);
    paramVisitor.visitArrayInstruction(this);
    paramVisitor.visitLASTORE(this);
  }
}


/* Location:              D:\software\jd-gui\jd-gui-windows-1.6.3\rt.jar!\com\sun\org\apache\bcel\internal\generic\LASTORE.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */