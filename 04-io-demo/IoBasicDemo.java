import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * IO流练习：字节流、字符流、文件读写、try‑with‑resources自动关闭流
 * Java8兼容版本
 */
public class IoBasicDemo {
    public static void main(String[] args) throws IOException {
        String filePath = "test.txt";
        writeFile(filePath);
        readFile(filePath);
        copyFile("test.txt","test_copy.txt");
    }

    // 字符流写文件，指定UTF‑8（Java8兼容）
    public static void writeFile(String path) throws IOException {
        try(Writer writer = new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8)){
            writer.write("Java IO练习\n");
            writer.write("字节流处理二进制，字符流处理文本");
        }
    }

    // 字符流读文件，指定UTF‑8（Java8兼容）
    public static void readFile(String path) throws IOException {
        System.out.println("====读取文件====");
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path),StandardCharsets.UTF_8))){
            String line;
            while((line = br.readLine())!=null){
                System.out.println(line);
            }
        }
    }

    // 字节流文件复制
    public static void copyFile(String src,String dest) throws IOException {
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))){
            byte[] buf = new byte[1024];
            int len;
            while((len = bis.read(buf))!=-1){
                bos.write(buf,0,len);
            }
        }
        System.out.println("文件复制完成");
    }
}