package instrument;

import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

public class Instrumentor {

    public static String EVENT_RECIEVER = "scheduler/Scheduler";

    public static void premain(String agentArgs, Instrumentation inst) {
        inst.addTransformer((loader, className, classBeingRedefined, protectionDomain, classfileBuffer) -> {
           if (className.contains("test/Simple")){
               ClassReader classReader = new ClassReader(classfileBuffer);
               ClassWriter classWriter = new ClassWriter(classReader, ClassWriter.COMPUTE_FRAMES);
               MyClassTransformer myClassTransformer = new MyClassTransformer(classWriter);
               classReader.accept(myClassTransformer,ClassReader.EXPAND_FRAMES);
               classfileBuffer = classWriter.toByteArray();
               File dir = new File("out");
               if (!dir.exists()) {
                   dir.mkdir();
               }

               File classFile = new File(dir, className.replace("/", ".") + ".class");

               try {
                   classFile.createNewFile();
               } catch (IOException e) {
                   e.printStackTrace();
               }
               try {
                   FileOutputStream fos = new FileOutputStream(classFile);
                   fos.write(classfileBuffer);
                   fos.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
            } else {

            }

           //----- 输出 ------//

            return classfileBuffer;

        });
    }
}
