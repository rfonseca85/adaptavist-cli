package dev.rfonseca85.testcli.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.table.TableBuilder;
import org.springframework.shell.table.ArrayTableModel;
import org.springframework.shell.table.BorderStyle;
import dev.rfonseca85.testcli.service.WordCountService;
import dev.rfonseca85.testcli.utils.FileManipulation;
import java.util.LinkedHashMap;

/**
 * This class handles the 'wordcount' command in the shell. It uses the
 * WordCountService to count the occurrences
 * of each word in a text file and prints a word count table.
 * 
 * @author Rafael Fonseca
 * @since 2024-04-24
 */
@ShellComponent
public class WordCountCommands {

    @Autowired
    private WordCountService wordCountService;

    @ShellMethod(key = "wordcount", value = "Takes a path to a file as an argument and prints a word count of its contents")
    public void wordcount(String filePath) throws Exception {

        StringBuilder text = FileManipulation.readFile(filePath);

        LinkedHashMap<String, Integer> wordCountList = wordCountService.countWords(text.toString());

        // Format the output as a table
        ArrayTableModel model = new ArrayTableModel(wordCountList.entrySet().stream()
                .map(wc -> new String[] { wc.getKey(), wc.getValue().toString() })
                .toArray(String[][]::new));
        TableBuilder tableBuilder = new TableBuilder(model);
        tableBuilder.addInnerBorder(BorderStyle.fancy_light);
        tableBuilder.addHeaderBorder(BorderStyle.fancy_light);

        System.out.println(tableBuilder.build().render(12));

    }

}
