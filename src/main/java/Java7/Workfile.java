package Java7;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * 遍历目录及子目录下的文件
 */
public class Workfile {
    static int i = 0;
    public static void main(String[] args) throws IOException{
        Path dir = Paths.get("/home/amarsoft/neon_workspace");

        Files.walkFileTree(dir,new FindJavaVisitor());

        System.out.println("共计" + i + "个文件");
    }

    private static class FindJavaVisitor extends SimpleFileVisitor<Path>{
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs){
            if(file.toString().endsWith(".jsp")){
                System.out.println(file.getFileName());
                i++;
            }
            return  FileVisitResult.CONTINUE;
        }
    }

}
