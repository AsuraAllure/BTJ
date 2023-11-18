package edu.project1.Representers.Writers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConsoleWriter implements Writer {
    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public void print(String outputString) {
        LOGGER.info(outputString);
    }
}
