import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;

public class MyClassTransformer extends ClassVisitor {
    public MyClassTransformer( ClassVisitor classVisitor) {
        super(Opcodes.ASM5, classVisitor);
    }

    @Override
    public MethodVisitor visitMethod(int i, String s, String s1, String s2, String[] strings) {
        MethodVisitor m =  super.visitMethod(i, s, s1, s2, strings);
        return new MyMethodTransformer(m);
    }
}
