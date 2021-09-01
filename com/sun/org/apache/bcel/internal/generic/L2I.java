package com.sun.org.apache.bcel.internal.generic;

public class L2I extends ConversionInstruction {
  public L2I() { super((short)136); }
  
  public void accept(Visitor paramVisitor) {
    paramVisitor.visitTypedInstruction(this);
    paramVisitor.visitStackProducer(this);
    paramVisitor.visitStackConsumer(this);
    paramVisitor.visitConversionInstruction(this);
    paramVisitor.visitL2I(this);
  }
}


/* Location:              D:\software\jd-gui\jd-gui-windows-1.6.3\rt.jar!\com\sun\org\apache\bcel\internal\generic\L2I.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */