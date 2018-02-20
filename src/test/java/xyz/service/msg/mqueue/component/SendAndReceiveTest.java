package xyz.service.msg.mqueue.component;

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

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * PROJECT   : consumer
 * PACKAGE   : xyz.service.msg.component
 * USER      : sean
 * DATE      : 11-February-2018
 * TIME      : 22:49
 */

//@ComponentScan(basePackages = "xyz.service.msg.mqueue")
@DirtiesContext
@SpringBootTest
@RunWith(SpringRunner.class)
public class SendAndReceiveTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(SendAndReceiveTest.class);

    @Autowired
    private Sender sender;

    @Autowired
    private Receiver receiver;


    @BeforeClass
    public static void setUp() {
        LOGGER.info("Initiation sequence completed...");
    }

    @AfterClass
    public static void tearDown() {
        LOGGER.info("Execution Terminated...");
    }

    @Test
    public void activeMqTest() throws Exception {
        final String codeWord = "Alpha-Mike";
        sender.sendActiveMqMsg(codeWord);

        receiver.getLatch().await(5000, TimeUnit.MILLISECONDS);
        assertThat((Long) receiver.getLatch().getCount()).isEqualTo(1);
    }

    @Test
    public void rabbitMqTest() throws Exception {
        final String codeWord = "Romeo-Mike";
        sender.sendRabbitMqMsg(codeWord);

        receiver.getLatch().await(5000, TimeUnit.MILLISECONDS);
        assertThat((Long) receiver.getLatch().getCount()).isEqualTo(1);
    }
}