import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileControl {
    public static void main(String[] args) throws IOException{
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
