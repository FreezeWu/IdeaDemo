package com.wkc.rookie;

import java.io.*;

public class IOStream {
    public static void main(String[] args) throws IOException {
        //BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //String str = bf.readLine();

        System.out.println("------------------------------------------");

        //字节流读取png文件内容并写入到一个拷贝文件里
        File file1 = new File("F:\\heima\\getQRCode.png");
        File file2 = new File("F:\\heima\\getQRCode_Copy.png");

        //如果文件存在则删除，并重新创建对象
        if(file2.exists()){
            file2.delete();
            file2 = new File("F:\\heima\\getQRCode_Copy.png");
        }

        //重新创建新文件，此时大小为0K
        if(!file2.exists()){
            file2.createNewFile();
        }

        FileInputStream fi = new FileInputStream(file1);
        FileOutputStream fo = new FileOutputStream(file2);

        int byteRead = 0;   //每次读取的字节长度
        byte[] bytes = new byte[1024];  //存储每次读取和写入的字节长度

        //fi读取file1数据，直到读取结束（= -1）
        while((byteRead = fi.read(bytes)) != -1){
            fo.write(bytes, 0, byteRead);   //将读取内容写入到输出流中
        }

        fo.close();
        fi.close();

        System.out.println("文件写入成功！路径为：" + file2.getPath());

        System.out.println("------------------------------------------");

        //字符流读取文件
        String filePath = "F:\\test.txt";
        long fileRead = 0;

        File file = new File(filePath);

        //字符流读取文件内容
        FileReader fileReader = new FileReader(file);

        char[] charArray = new char[(int)file.length()];

        if(file.canRead()){
            fileRead = fileReader.read(charArray, 0 ,(int)file.length());
        }

        String fileContent = new String(charArray);

        System.out.println(fileContent);
    }
}
