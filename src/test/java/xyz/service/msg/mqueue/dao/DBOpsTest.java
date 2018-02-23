package xyz.service.msg.mqueue.dao;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static xyz.service.msg.mqueue.constant.Constant.LINE_SEPARATOR;

/**
 * PROJECT   : mqueue
 * PACKAGE   : xyz.service.msg.mqueue.component
 * USER      : sean
 * DATE      : 19-February-2018
 * TIME      : 23:44
 */
@RunWith(SpringRunner.class)
@DirtiesContext
@SpringBootTest
public class DBOpsTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(DBOpsTest.class);

    @Autowired
    DBOpsService opsService;

    @BeforeClass
    public static void setUp() {
        LOGGER.info(LINE_SEPARATOR, "Initiating...");
    }

    @AfterClass
    public static void tearDown() {
        LOGGER.info(LINE_SEPARATOR, "Terminating...");
    }

    //    @Ignore("DB configuration not done.")
    @Test
    public void saveToDb() {
//        DBOps opsService = new DBOps();
        opsService.saveToDb("Test", "Delta-Tango", "queued");
    }
}