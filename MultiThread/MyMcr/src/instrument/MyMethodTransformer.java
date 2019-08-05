package instrument;

import com.sun.org.apache.xpath.internal.compiler.OpCodes;
import jdk.internal.org.objectweb.asm.Label;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;
import jdk.internal.org.objectweb.asm.commons.AdviceAdapter;
import scheduler.Scheduler;

public class MyMethodTransformer extends AdviceAdapter implements Opcodes {

    private static final String NO_ARG_VOID = "()V";
    private static final String BOOL_3STRINGS_INT_VOID = "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V";
    private String methodnName;
    private boolean isInit;
    private int lineNumber;

    protected MyMethodTransformer(MethodVisitor mv, int access, String name, String desc) {
        super(Opcodes.ASM5, mv, access, name, desc);
        methodnName = name;
        isInit = (methodnName.equals("<init>")||methodnName.equals("<clinit>"));
    }


    @Override
    public void visitLineNumber(int line, Label start) {
        lineNumber=line;
        mv.visitLineNumber(line, start);
    }

    @Override
    public void visitFieldInsn(int opcode, String owner, String name, String desc) {

        if (isInit){
            super.visitFieldInsn(opcode, owner, name, desc);
            return;
        }
        boolean isRead = false;
        if (opcode == Opcodes.GETFIELD || opcode == Opcodes.GETSTATIC) {
            isRead = true;
        }
        instrumentField(true,isRead,owner,name,desc);
        super.visitFieldInsn(opcode, owner, name, desc);
//        instrumentField(false,isRead,owner,name,desc);
    }

    private void instrumentField(boolean isBefore, boolean isRead, String fieldOwner, String fieldName, String fieldDesc){
        mv.visitInsn(isRead ? Opcodes.ICONST_1 : Opcodes.ICONST_0);
        mv.visitLdcInsn(methodnName);
        mv.visitLdcInsn(fieldName);
        mv.visitLdcInsn(fieldDesc);
        mv.visitLdcInsn(new Integer(lineNumber));
        if (isBefore) {
            mv.visitMethodInsn(Opcodes.INVOKESTATIC,
                    Instrumentor.EVENT_RECIEVER,
                    "beforeFieldAccess",
                    BOOL_3STRINGS_INT_VOID);
        } else {
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, Instrumentor.EVENT_RECIEVER, "afterFieldAccess", BOOL_3STRINGS_INT_VOID,false);
        }
    }

}
