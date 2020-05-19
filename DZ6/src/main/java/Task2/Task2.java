package Task2;

import java.io.FileOutputStream;
import java.util.*;
import java.util.stream.Collectors;

public class Task2 {

    public static void main(String[] args) {
        String outFileDir = "src/main/resources/Task2/";
        getFiles(outFileDir, 25, 10000, generateWords(10), 2);
    }

    /**
     * Функция генерации файлов
     * @param path путь к директории, где будут храниться сгенерированные файлы
     * @param n количество файлов
     * @param size размер файлов в байтах(если файл больше по  размеру то обрезается до нужного размера)
     * @param words слова
     * @param probability вероятность для слов
     */
    public static void getFiles(String path, int n, int size, String[] words, int probability){
        Random rand = new Random();
        for(int i = 0; i < n; i++){
            int paragraphsCount = rand.nextInt(15) + 1;
            try(FileOutputStream fos=new FileOutputStream(path + i + ".txt"))
            {
                StringBuilder sb = new StringBuilder();
                byte[] buffer = {' '};
                Text text = new Text(words, probability);
                for(int j = 0; j < paragraphsCount; j++){
                    Paragraph paragraph = new Paragraph(text);
                    sb.append(paragraph.toString());

                    buffer = sb.toString().getBytes();
                    if(size < buffer.length)
                        break;
                }

                fos.write(sb.toString().getBytes(), 0, size > buffer.length ? buffer.length : size);

                System.out.println("Файл " + path + i + ".txt" + " записан");
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    public static String[] generateWords(int size){
       // return new String[]{"Andrew", "Jakson", "Jihad", "Bob", "Dylan", "Johny", "Cash", "Tom", "Taylor", "JoHny", "CAsh"};
        String[] strs = new String[size];
        System.out.println("Сгенерированные слова");
        for(int i = 0; i < size; i++){
            strs[i] = new Word(false, false).toString();
            System.out.println(strs[i]);
        }

        return strs;
    }




}
