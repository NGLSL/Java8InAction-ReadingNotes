package xin.codedream.java8.chap1;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

/**
 * 查找隐藏文件
 *
 * @author NGLSL
 * @date 2018/7/20
 */
public class FindHiddenFiles {

    public static void main (String[] args) {
        findFilesOld();
        findFilesNew();
    }

    private static void findFilesOld() {
        File[] files = new File("D:\\.").listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });
        System.out.println("findFilesOld>>>" + Arrays.toString(files));
    }

    private static void findFilesNew() {
        File[] files = new File("D:\\.").listFiles(File::isHidden);
        System.out.println("findFilesNew>>>" + Arrays.toString(files));
    }
}
