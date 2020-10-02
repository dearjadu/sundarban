package app.kartik.sundarban;

import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import app.kartik.sundarban.tigers.Tiger;
import app.kartik.sundarban.tigers.Tigers;

@SpringBootTest
class SundarbanApplicationTests
{
	private static final Logger logger = Logger.getLogger(SundarbanApplicationTests.class.getName());

	@Autowired Tigers tigers;

	@Test
	void test_get_tiger()
	{
		Tiger tiger = tigers.select("bengal");

		logger.info("Got Tiger: " + tiger);

		Assert.assertEquals("Bengal", tiger.getName());
		Assert.assertEquals("https://en.wikipedia.org/wiki/Bengal_tiger", tiger.getWikiLink());
		Assert.assertNotNull(tiger.getImageLink());

		logger.info("Test Ran!");
	}
}
