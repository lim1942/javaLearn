package learnIO;

import java.io.File;

public class file {
    public static void main(String[] args){
        System.out.println(System.getProperty("user.dir"));
        File dummyFile = new File("test.txt");
        System.out.println(dummyFile.isFile());
        System.out.println("Absolute Path: " + dummyFile.getAbsolutePath());
        try {
            System.out.println("Canonical Path: " + dummyFile.getCanonicalPath());
        }catch (Exception e){
            e.printStackTrace();
        }


        try {
            // 创建文件
            File dummyFile2 = new File("test2.txt");
            boolean fileCreated  = dummyFile2.createNewFile();
            System.out.println(fileCreated);

            // 创建文件夹
            File newDir  = new File("test/test2");
            newDir.mkdirs();

            // 删除文件
            File dummyFile3 = new File("test2.txt");
            dummyFile3.delete();
        }catch (Exception e){
            e.printStackTrace();
        }

        // 列出根目录
        File[] roots = File.listRoots();
        System.out.println("List  of  root directories:");
        for (File f : roots) {
            System.out.println(f.getPath());
        }

        int b;
        b = 'A';
        System.out.write(b);
        System.out.write('\n');

    }
}
