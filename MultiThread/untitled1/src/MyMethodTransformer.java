import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;

public class MyMethodTransformer extends MethodVisitor {
    public MyMethodTransformer(MethodVisitor methodVisitor) {
        super(Opcodes.ASM5, methodVisitor);
    }

    @Override
    public void visitFieldInsn(int i, String s, String s1, String s2) {
        super.visitFieldInsn(i, s, s1, s2);
        boolean isRead = false;
        if (i == Opcodes.GETFIELD || i == Opcodes.GETSTATIC) {
            isRead = true;
        }
        super.mv.visitMethodInsn(Opcodes.INVOKESTATIC,"");
    }

    @Override
    public void visitMethodInsn(int i, String s, String s1, String s2, boolean b) {
        super.visitMethodInsn(i, s, s1, s2, b);
        super.mv.visitMethodInsn(Opcodes.INVOKESTATIC,"Instrumentor","hello","()V");
    }
}
