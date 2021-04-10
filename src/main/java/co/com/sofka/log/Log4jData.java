package co.com.sofka.log;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.log4j.Logger;

public class Log4jData {

    private final Logger logger;

    public Log4jData(String className) {
        this.logger = Logger.getLogger(className);
        DOMConfigurator.configure("log4j.xml");
    }

    public Logger getLogger() {
        return logger;
    }
}

