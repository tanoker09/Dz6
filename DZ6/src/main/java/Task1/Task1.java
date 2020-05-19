package Task1;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Task1 {

    public static void main(String[] args) {
        String filePath = "src/main/resources/Task1/data.txt";
        String outFilePath = "src/main/resources/Task1/result.txt";

        try {
            String fileData = readToString(filePath);

            Map<String, String> sortedStrings = new TreeMap<>(
                    Arrays.stream(
                            fileData.split("\\s+"))
                            .collect(
                                    Collectors.toMap(k -> k.toUpperCase(), v -> v, (existing, replacement) -> existing)
                            )
            );

            writeStringsToFile(outFilePath, sortedStrings.values());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Read file content into string with - Files.readAllBytes(Path path)

    private static String readToString(String filePath) throws Exception {
        String content = "";

        try {
            content = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (Exception e) {
            Exception newException = new Exception("Не удалось зачитать файл");
            newException.addSuppressed(e);
            throw newException;
        }

        return content;
    }

    private static void writeStringsToFile(String outFilePath, Collection<String> strs) throws Exception {
        try {
            Files.write(Paths.get(outFilePath), strs, Charset.defaultCharset());
        } catch (Exception e) {
            Exception newException = new Exception("Не удалось записать файл");
            newException.addSuppressed(e);
            throw newException;
        }

    }
}

