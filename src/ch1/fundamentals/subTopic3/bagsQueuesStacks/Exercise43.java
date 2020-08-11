package ch1.fundamentals.subTopic3.bagsQueuesStacks;

import ch1.fundamentals.subTopic3.bagsQueuesStacks.util.PushDownQueue;

import java.io.File;

/**
 * @author Sumit Deo
 * @Date 8/9/20
 * @Project Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @Comments Listing files. A folder is a list of files and folders. Write a program that takes the
 * name of a folder as a command-line argument and prints out all of the files contained
 * in that folder, with the contents of each folder recursively listed (indented) under that
 * folder’s name. Hint : Use a queue, and see java.io.File.
 */
public class Exercise43 {
    public static void main(String[] args) {
        String folderPath = args[0];
        File folder = new File(folderPath);

        ListingFiles listingFiles = new ListingFiles();
        listingFiles.listFiles(folder, 0);

        for (String fileName : listingFiles.queue) {
            System.out.println(fileName);
        }
    }

    private static class ListingFiles {

        PushDownQueue<String> queue;

        public ListingFiles() {
            queue = new PushDownQueue<>();
        }

        public void listFiles(File folder, int depth) {
            if (!folder.exists()) {
                throw new RuntimeException(folder.getPath() + " does not exists.");
            }

            addFilesToQueue(folder, depth);

            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        addFilesToQueue(file, depth);
                    } else {
                        listFiles(file, ++depth);
                    }
                }
            }
        }

        private void addFilesToQueue(File folder, int depth) {

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < depth; i++) {
                stringBuilder.append("\t");
            }
            stringBuilder.append(folder.getName());
            queue.enqueue(stringBuilder.toString());
        }
    }
}
