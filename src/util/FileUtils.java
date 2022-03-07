package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lixiaochun
 */
public class FileUtils {

    public static List<String> readlines(String path) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(FileUtils.class.getResourceAsStream(path)))) {
            br.lines().forEach(lines::add);
        } catch (Exception e) {
            throw new RuntimeException(String.format("error reading file, path:%s", path));
        }

        return lines;
    }

}
