import java.io.*;
import java.util.Scanner;

public class CopyFileText {
    public static void readFileText(String filePath) throws Exception{
        try{
            File file = new File(filePath);
            if (!file.exists()){
                throw new FileNotFoundException();
            }

            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            int character = 0;
            int count = 0;
            while ((character = bufferedReader.read()) != -1){
                System.out.print((char)character + " ");
                count++;
            }
            System.out.println();
            System.out.println(count);
            bufferedReader.close();
        }catch (Exception e){
            System.out.println("File không tồn tại");
        }
    }

    public static void writeFileText(String SourceFile,String TargetFile) throws Exception{
        try{
            File file1 = new File(SourceFile);
            File file2 = new File(TargetFile);
            if (!file1.exists()){
                throw new FileNotFoundException();
            }

            FileReader fileInputStream = new FileReader(file1);
            FileWriter fileOutputStream = new FileWriter(file2);
            BufferedReader bufferedReader = new BufferedReader(fileInputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(fileOutputStream);

            int character = 0;
            Integer count = 0;
            while ((character = bufferedReader.read()) != -1){
                bufferedWriter.write(character);
                count++;
            }
            bufferedWriter.newLine();
            bufferedWriter.write(count.toString());
            bufferedReader.close();
            bufferedWriter.close();
        }catch (Exception e){
            throw new FileNotFoundException();
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Nhập tên file");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String output = scanner.nextLine();
//        readFileText(input);
        writeFileText(input,output);
    }
}
