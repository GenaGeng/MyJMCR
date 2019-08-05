import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassWriter;

import java.lang.instrument.Instrumentation;

public class Instrumentor {

    public static void premain(String agentArgs, Instrumentation inst) {
        inst.addTransformer((loader, className, classBeingRedefined, protectionDomain, classfileBuffer) -> {
            ClassReader classReader = new ClassReader(classfileBuffer);
            ClassWriter classWriter = new ClassWriter(classReader, ClassWriter.COMPUTE_FRAMES);
            MyClassTransformer myClassTransformer = new MyClassTransformer(classWriter);
            classReader.accept(myClassTransformer,ClassReader.EXPAND_FRAMES);

            return classWriter.toByteArray();
        });
    }

    public static void hello(){
        System.out.println("Hello");
    }

}
