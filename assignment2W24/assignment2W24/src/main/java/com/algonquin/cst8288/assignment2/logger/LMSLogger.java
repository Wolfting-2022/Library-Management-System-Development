package com.algonquin.cst8288.assignment2.logger;

import java.io.IOException;
import java.util.logging.*;

/**
 * Singleton class for application-wide logging.
 * This class initializes a Java Logger with both file and console handlers to log messages across different levels.
 * It ensures that only one instance of the logger is created in the application lifecycle.
 */
public class LMSLogger {
	private static LMSLogger instance;
	private Logger logger;

	private LMSLogger() {
		/**
		 * initializes the logger object with a logger named after the LMSLogger class.
		 * Logger.getLogger(String name) is a method that retrieves or creates a logger
		 * with the specified name. Here, LMSLogger.class.getName() returns the fully
		 * qualified class name of LMSLogger, ensuring the logger is uniquely identified
		 * by this class's name.
		 */
		logger = Logger.getLogger(LMSLogger.class.getName());

		try {
			// Specify the log file name and set the append flag to true
			FileHandler fileHandler = new FileHandler("application.log", true);
            fileHandler.setLevel(Level.ALL); // Log all levels to the file.
            fileHandler.setFormatter(new SimpleFormatter()); // Use simple text format
            
            // Add the FileHandler to the logger
            logger.addHandler(fileHandler);
           
			ConsoleHandler handler = new ConsoleHandler();
			handler.setLevel(Level.ALL); // Capture all levels in the console handler.
	        // Add the ConsoleHandler to the logger
	        logger.addHandler(handler);

			logger.setUseParentHandlers(false); // Prevent logging output to the parent handler.
		} catch (IOException e) {
			System.err.println("Failed to initialize log file handler: " + e.getMessage());
		}
	}

    /**
     * Provides access to the singleton instance of LMSLogger.
     * @return The singleton instance of LMSLogger.
     */
	public static synchronized LMSLogger getInstance() {
		if (instance == null) {
			instance = new LMSLogger();
		}
		return instance;
	}

    /**
     * Logs a message at the specified log level.
     * @param logLevel The custom log level for the message.
     * @param message The message to be logged.
     */
	public void log(LogLevel logLevel, String message) {
		logger.log(convertLogLevel(logLevel), message);
	}

    /**
     * Logs a message with an exception at the specified log level.
     * @param logLevel The custom log level for the message.
     * @param message The message to be logged.
     * @param throwable The exception to be logged with the message.
     */
	public void log(LogLevel logLevel, String message, Throwable throwable) {
		logger.log(convertLogLevel(logLevel), message, throwable);
	}

    /**
     * Converts a custom LogLevel to a java.util.logging.Level.
     * @param logLevel The custom log level to convert.
     * @return The corresponding java.util.logging.Level.
     */
	private Level convertLogLevel(LogLevel logLevel) {
		switch (logLevel) {
		case TRACE:
			return Level.FINEST;
		case DEBUG:
			return Level.FINE;
		case INFO:
			return Level.INFO;
		case WARN:
			return Level.WARNING;
		case ERROR:
			return Level.SEVERE;
		default:
			return Level.INFO;
		}
	}
}
