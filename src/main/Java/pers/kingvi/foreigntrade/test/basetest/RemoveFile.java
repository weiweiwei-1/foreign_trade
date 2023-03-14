package pers.kingvi.foreigntrade.test.basetest;

import org.junit.Test;

import java.io.File;

public class RemoveFile {

    @Test
    public void moveFile(){
        String fromPath="E:\\IDEA-workspace\\file_test\\file_from\\from.jpg";
        String toPath="E:\\IDEA-workspace\\file_test\\file_to";
        System.out.println("移动文件：从路径 " + fromPath + " 移动到路径 " + toPath);
        File file = new File(fromPath);
        if (file.isFile()){
            File toFile=new File(toPath+"\\"+file.getName());
            if (toFile.exists()){
                System.out.println("文件已存在");
            }
            else{
                file.renameTo(toFile);
                System.out.println("移动文件成功");
            }
        }
    }


}

