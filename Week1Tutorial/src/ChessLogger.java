import java.io.IOException;
import java.util.logging.*;

public class ChessLogger {
  static private FileHandler fileTxt;
  static private LoggerFormat formatterTxt;

  static public void setup() throws IOException {

    // get the global logger to configure it
    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    // suppress the logging output to the console
    //Logger rootLogger = Logger.*getLogger*("");
    //Handler[] handlers = rootLogger.getHandlers();
    //if (handlers[0] instanceof ConsoleHandler) {
      //rootLogger.removeHandler(handlers[0]);
    //}

    //logger.setLevel(Level.INFO);
    fileTxt = new FileHandler("Logging.txt");

    // create a TXT formatter
    formatterTxt = new LoggerFormat();
    fileTxt.setFormatter(formatterTxt);
    logger.addHandler(fileTxt);
    
  }
}