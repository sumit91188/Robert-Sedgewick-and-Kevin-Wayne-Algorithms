package fundamentals.bagsQueuesStacks;

import fundamentals.bagsQueuesStacks.util.ArrayQueue;
import java.io.File;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.bagsQueuesStacks
 * @date 1/7/21
 * @comment: Listing files. A folder is a list of files and folders. Write a program that takes the
 * name of a folder as a command-line argument and prints out all of the files contained in that
 * folder, with the contents of each folder recursively listed (indented) under that folder’s name.
 * Hint : Use a queue, and see java.io.File.
 */
public class Exercise43 {

  static ArrayQueue<String> queue = new ArrayQueue<>();

  public static void main(String[] args) {
    String folderName =
        "/Users/sumitdeo/Documents/personal/Study/Robert-Sedgewick-and-Kevin-Wayne-Algorithms/src";
    File folder = new File(folderName);
    queue.offer(folder.getName());
    showFiles(folder, 1);

    for (String str : queue) {
      System.out.println(str);
    }
  }

  private static void showFiles(File folder, int depth) {

    File[] files = folder.listFiles();
    String indentation = "";

    for (int i = 0; i < depth; i++) {
      indentation += "\t";
    }

    for (File file : files) {
      if (file.isFile()) {
        queue.offer(indentation + file.getName());
      }
    }
    for (File file : files) {
      if (file.isDirectory()) {
        queue.offer(indentation + file.getName());
        showFiles(file, depth + 1);
      }
    }
  }
}
