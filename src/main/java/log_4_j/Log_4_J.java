package log_4_j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.LoggerNameAwareMessage;

public class Log_4_J {
	
	static Logger logger = LogManager.getLogger(Log_4_J.class);

	public static void main(String[] args) {

		System.out.println(" Hello World");
		
	    logger.info("information message");//info(String message):void.Logger
	    logger.error("error message");
	    logger.warn("warn");
	    logger.fatal("fatal");
	    
	    System.out.println("\n Completed");
	    
		
	}

}
