package edu.LoggerAnalyzer;

import edu.LoggerAnalyzer.Analyzers.StandartAnalyzer;
import edu.LoggerAnalyzer.Parsers.FileParser;
import edu.LoggerAnalyzer.Parsers.Parser;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Path nameFile = Path.of(
            System.getProperty("user.home"),
            "LogTinkoff",
            "miniLog.txt"
        );
        Pattern urlPattern =
            Pattern.compile("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");

        try(Parser parser = new FileParser(nameFile)) {

            StandartAnalyzer standartAnalyzer = new StandartAnalyzer();
            System.out.println();
            System.out.println(standartAnalyzer.analizing(parser.parse()));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
