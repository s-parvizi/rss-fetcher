package com.soheil.rss.schedule;

import com.rometools.rome.feed.synd.SyndEntry;
import com.soheil.rss.data.FeedMessageRepository;
import com.soheil.rss.data.model.FeedMessage;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : parvizis
 * @since : 12/21/18
 */

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private ConfigurableApplicationContext ac =
            new ClassPathXmlApplicationContext("integration/FeedInboundChannelAdapter.xml");
    private PollableChannel feedChannel = ac.getBean("feedChannel", PollableChannel.class);

    private final FeedMessageRepository feedMessageRepository;

    @Autowired
    public ScheduledTasks(FeedMessageRepository feedMessageRepository) {
        this.feedMessageRepository = feedMessageRepository;
    }

    @Scheduled(fixedRateString = "${rss.fetch.interval}", initialDelay = 1000)
    private void rssFetchSchedule() {

        log.info("Fetching New Data, The time is now {}", dateFormat.format(new Date()));

        fetchData();

    }

    private void fetchData() {

        Message<SyndEntry> message = null;

        for (int i = 0; i < 10; i++) {

            message = (Message<SyndEntry>) feedChannel.receive(1000);
            if (message != null) {

                SyndEntry entry = message.getPayload();

                log.info(entry.getPublishedDate() + " - " + entry.getTitle());

                processData(message);

            } else {

                log.info("Message is null, The time is now {}", dateFormat.format(new Date()));
                break;

            }

        }

    }

    private void processData(Message<SyndEntry> message) {

        FeedMessage feedMessage = new FeedMessage();

        feedMessage.setId(message.getHeaders().getId().toString());
        feedMessage.setLink(message.getPayload().getLink());
        feedMessage.setTitle(message.getPayload().getTitle());
        feedMessage.setHtmlDescription(message.getPayload().getDescription().getValue());
        feedMessage.setTextDescription(html2text(message.getPayload().getDescription().getValue()));

        if (message.getPayload().getSource()!=null) {
            feedMessage.setSource(message.getPayload().getSource().getLink());
        }

        if (message.getHeaders().getTimestamp()!=null) {
            feedMessage.setItemTimeStamp(new Timestamp(message.getHeaders().getTimestamp()));
        }

        feedMessage.setFetchTimeStamp(new Timestamp(System.currentTimeMillis()));

        saveDataIntoMemory(feedMessage);

    }

    private void saveDataIntoMemory(FeedMessage message) {
        feedMessageRepository.save(message);
    }

    private static String html2text(String html) {
        return Jsoup.parse(html).text();
    }

    @PreDestroy
    private void dest() {
        ac.close();
    }

}
