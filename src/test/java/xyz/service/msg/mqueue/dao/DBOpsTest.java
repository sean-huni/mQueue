package xyz.service.msg.mqueue.dao;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.service.msg.mqueue.domain.Queue;
import xyz.service.msg.mqueue.util.Util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static xyz.service.msg.mqueue.constant.Constant.LINE_SEPARATOR;
import static xyz.service.msg.mqueue.constant.Constant.QUEUE_STATUS_QUEUED;

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
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DBOpsTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(DBOpsTest.class);
    private final String system = "Test", msg = "Delta-Tango";
    private static final String UUID = new Util().getUUID();

    @Autowired
    private DBOpsService dBOpsService;

    @BeforeClass
    public static void setUp() {
        LOGGER.info(LINE_SEPARATOR, "Initiating...");
    }

    @AfterClass
    public static void tearDown() {
        LOGGER.info(LINE_SEPARATOR, "Terminating...");
    }

    @Test
    public void a_saveToDb() {
        dBOpsService.saveToDb(UUID, system, msg, QUEUE_STATUS_QUEUED);
    }

    @Test
    public void b_findQueue() {
        final Iterable<Queue> queueIterable = dBOpsService.findAll();

        final Queue queue = queueIterable.iterator().next();    //dBOpsService.findById(10);

        LOGGER.info("Queue ID: {}", queue.getId());

        assertNotNull(queue);
        assertTrue(queue.getUuid().equals(UUID));
        assertTrue(queue.getSystem().equals(system));
        assertTrue(queue.getMessage().equals(msg));
        assertTrue(queue.getStatus().equals(QUEUE_STATUS_QUEUED));
    }
}