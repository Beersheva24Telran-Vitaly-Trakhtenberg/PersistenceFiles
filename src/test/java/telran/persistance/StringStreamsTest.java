package telran.persistance;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class StringStreamsTest
{
    private static final String PRINT_STREAM_FILE = "printStreamFile.txt";
    private static final String PRINT_WRITER_FILE = "printWriterFile.txt";

    @Test
    @Disabled
    void printStreamTest() throws Exception
    {
        PrintStream printStream = new PrintStream(PRINT_STREAM_FILE);
        printStream.println("HELLO");
        printStream.close();
    }

    @Test
    //@Disabled
    void printWriterTest() throws Exception
    {
        PrintWriter printWriter = new PrintWriter(PRINT_WRITER_FILE);
        printWriter.println("HELLO");
        printWriter.close();
    }

    @Test
    void bufferedReaderTest() throws Exception
    {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(PRINT_WRITER_FILE));
        assertEquals("HELLO", bufferedReader.readLine());
        bufferedReader.close();
    }

    @Test
    void printingDirectoryTest() throws Exception {
        printDirectoryContent("/home", 3, false, " ");
    }

    private void printDirectoryContent(String path, int depth, boolean show_files, String marker) throws Exception
    {
        if (depth > 0 ) {
            File dir = new File(path);
            if (dir.isDirectory()) {
                File[] arrFiles = dir.listFiles();
                if (arrFiles != null) {
                    List<File> lst = Arrays.asList(arrFiles);
                    Iterator itr = lst.iterator();
                    while (itr.hasNext()) {
                        Object current_path = itr.next();
                        if (((File)current_path).isFile() && show_files) {
                            System.out.println(marker + current_path);
                        } else if (((File)current_path).isDirectory()) {
                            System.out.println(marker + current_path);
                            printDirectoryContent(current_path.toString(), depth - 1, show_files, marker + marker);
                        }
                    }
                }
            } else {
                if (show_files) {
                    System.out.println(marker + dir.toString());
                }
            }

        }
        // class Path
        // class Files
            // files.walk
            // files.
    }
}
