package leetcode.daily.challenge.may2021.day18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author : ssuddhapally
 * @since : 19/05/21, Wed
 **/
class FilePaths {
  public static List<List<String>> findDuplicate(String[] paths) {
    Map<String, List<String>> contentToFilePaths = new HashMap<>();
    for (String path : paths) {
      String[] arr = path.split(" ");
      String dir = arr[0];
      for (int i = 1; i < arr.length; i++) {
        String[] splits = arr[i].split("\\(");
        String file = splits[0];
        String[] secondSplits = splits[1].split("\\)");
        String content = secondSplits[0];
        contentToFilePaths.putIfAbsent(content, new ArrayList<>());
        contentToFilePaths.get(content).add(dir + "/" + file);

      }
    }
    Map<String, List<String>> duplicateMaps = contentToFilePaths.entrySet().stream().filter(e -> e.getValue().size() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    return new ArrayList(duplicateMaps.values());
  }

  public static void main(String[] args) {
    String[] input = {"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"};
    List<List<String>> duplicate = findDuplicate(input);
    System.out.println(duplicate);
  }
}