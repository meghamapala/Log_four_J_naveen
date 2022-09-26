package vfxv;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class BaseTest {
	
	Logger log=Logger.getLogger(BaseTest.class);
	@BeforeClass
	public void start() {
		DOMConfigurator.configure("log4j.xml");
	}
	@Test
	public void test1() {
		log.fatal("this is fatal");
		log.error("this is error");
		log.warn("this is warn");
		log.info("this is info");
		log.debug("this is debug");
		log.trace("this is trace");
		
	}

}
