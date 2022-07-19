package loggingexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingBasics {
	
	/*
	 * What is Logback: 
	 * 
	 * Logback is a logging library used for Java-based applications - it's one of the 
	 * most widely used logging frameworks. It is the replacement for another logging library
	 * called Log4j
	 * 
	 * Logback offers fast implementation, more options for configuration, and it offers more
	 * flexibility in archiving old log files
	 * 
	 * There are 3 classes in Logback: 
	 * Logger class: this is the context for log messages - essentially, this is the class that your program interacts
	 * with to create the log messages
	 * Appender class: this class places log files in their final destination - we can log to the console, 
	 * we can log to a file, you can even log to other destinations like an email; there can be
	 * more than one appender
	 * Layout class: this class prepares messages for outputting into a particular format;
	 * you can also format the logs to be in html, json, or other formats 
	 * 
	 * Logging levels: Error > Warn > Info > Debug > Trace
	 * 
	 * */
	private static final Logger logger = LoggerFactory.getLogger(LoggingBasics.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("This is a test!");
//		logger.trace("This is a trace log");
//		logger.debug("This is a debug log");
//		logger.info("info");
//		logger.warn("warn");
//		logger.error("error");
		
		String message = "This is a string";
		int zero = 0;
		
		try {
			logger.trace("Logging message: {} ", message);
			logger.info("Let's divide {} by {}. ", 42, zero);
			int result = 42/zero;
			System.out.println(result);
		} catch (Exception e) {
			//I can pass in the exception as the last argument to a logging method
			//when I do this, logback will print the stacktrace to my file
			logger.trace("Error dividing {} by {}. ", 42, zero, e);
		}
		
	}

}
