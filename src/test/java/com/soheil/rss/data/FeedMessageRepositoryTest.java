package com.soheil.rss.data;

import com.soheil.rss.data.model.FeedMessage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : parvizis
 * @since : 12/23/18
 */

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class FeedMessageRepositoryTest {

    @Autowired
    FeedMessageRepository feedMessageRepository;

    private FeedMessage firstFeedMessage;
    private FeedMessage secondFeedMessage;
    private FeedMessage thirdFeedMessage;

    @Before
    public void setUp() {

        firstFeedMessage = new FeedMessage();

        firstFeedMessage.setId("1c967df3-5bed-c11f-7ed2-963a75cb179a");
        firstFeedMessage.setLink("https://www.wcvb.com/article/teenager-belts-out-song-during-brain-surgery-to-preserve-her-ability-to-sing/25655912");
        firstFeedMessage.setTitle("Teenager belts out song during brain surgery to preserve her ability to sing");
        firstFeedMessage.setHtmlDescription("<a href=\\\"https://www.wcvb.com/article/teenager-belts-out-song-during-brain-surgery-to-preserve-her-ability-to-sing/25655912\\\" target=\\\"_blank\\\">Teenager belts out song during brain surgery to preserve her ability to sing</a>&nbsp;&nbsp;<font color=\\\"#6f6f6f\\\">WCVB Boston</font><p>A teenager in Seattle is recovering from brain surgery that could have compromised her vocal skills if it weren't for her interesting method to preserving them ...</p><strong><a href=\\\"https://news.google.com/stories/CAAqOQgKIjNDQklTSURvSmMzUnZjbmt0TXpZd1NoTUtFUWpDcXBHd2pZQU1FZm5CRnlxQ3JfdC1LQUFQAQ?oc=5\\\" target=\\\"_blank\\\">View full coverage on Google News</a></strong>");
        firstFeedMessage.setTextDescription("Teenager belts out song during brain surgery to preserve her ability to singWCVB BostonA teenager in Seattle is recovering from brain surgery that could have compromised her vocal skills if it weren't for her interesting method to preserving them ...View full coverage on Google News");
        firstFeedMessage.setSource("https://www.wcvb.com");
        firstFeedMessage.setItemTimeStamp(new Timestamp(System.currentTimeMillis()));
        firstFeedMessage.setFetchTimeStamp(new Timestamp(System.currentTimeMillis()));

        secondFeedMessage = new FeedMessage();

        secondFeedMessage.setId("45d448f1-5db5-ebf4-7a1c-7f0b773221e6");
        secondFeedMessage.setLink("https://www.washingtonexaminer.com/opinion/its-beginning-to-look-a-lot-like-a-government-shutdown");
        secondFeedMessage.setTitle("It's beginning to look a lot like a government shutdown - Washington Examiner");
        secondFeedMessage.setHtmlDescription("<ol><li><a href=\\\"https://www.washingtonexaminer.com/opinion/its-beginning-to-look-a-lot-like-a-government-shutdown\\\" target=\\\"_blank\\\">It's beginning to look a lot like a government shutdown</a>&nbsp;&nbsp;<font color=\\\"#6f6f6f\\\">Washington Examiner</font></li><li><a href=\\\"https://www.cnn.com/2018/12/20/politics/government-shutdown-what-will-happen/index.html\\\" target=\\\"_blank\\\">How a partial government shutdown could play out: By the numbers</a>&nbsp;&nbsp;<font color=\\\"#6f6f6f\\\">CNN</font></li><li><a href=\\\"https://wtop.com/government/2018/12/the-impact-of-a-partial-government-shutdown-on-feds-and-non-feds/\\\" target=\\\"_blank\\\">FAQ: What to expect during a partial government shutdown</a>&nbsp;&nbsp;<font color=\\\"#6f6f6f\\\">WTOP</font></li><li><a href=\\\"https://www.bloomberg.com/view/articles/2018-12-20/government-shutdown-docile-republicans-won-t-defy-trump\\\" target=\\\"_blank\\\">Government Shutdown: Docile Republicans Won't Defy Trump</a>&nbsp;&nbsp;<font color=\\\"#6f6f6f\\\">Bloomberg</font></li><li><a href=\\\"https://thehill.com/homenews/senate/422402-schumer-house-passed-border-wall-bill-dead-in-the-senate\\\" target=\\\"_blank\\\">Schumer: House-passed border wall bill dead in the Senate | TheHill</a>&nbsp;&nbsp;<font color=\\\"#6f6f6f\\\">The Hill</font></li><li><strong><a href=\\\"https://news.google.com/stories/CAAqOQgKIjNDQklTSURvSmMzUnZjbmt0TXpZd1NoTUtFUWliN3VLd2pZQU1FWDFrUUFKRElXQ0tLQUFQAQ?oc=5\\\" target=\\\"_blank\\\">View full coverage on Google News</a></strong></li></ol>");
        secondFeedMessage.setTextDescription("It's beginning to look a lot like a government shutdownWashington ExaminerHow a partial government shutdown could play out: By the numbersCNNFAQ: What to expect during a partial government shutdownWTOPGovernment Shutdown: Docile Republicans Won't Defy TrumpBloombergSchumer: House-passed border wall bill dead in the Senate | TheHillThe HillView full coverage on Google News");
        secondFeedMessage.setSource("https://www.washingtonexaminer.com");
        secondFeedMessage.setItemTimeStamp(new Timestamp(System.currentTimeMillis()));
        secondFeedMessage.setFetchTimeStamp(new Timestamp(System.currentTimeMillis()));

        thirdFeedMessage = new FeedMessage();

        thirdFeedMessage.setId("d7482fdb-eddd-8755-0ab0-3e22cea90c0a");
        thirdFeedMessage.setLink("https://bgr.com/2018/12/23/google-search-christmas-state-by-state");
        thirdFeedMessage.setTitle("Here are the most Googled queries in each state around Christmastime - BGR");
        thirdFeedMessage.setHtmlDescription("<a href=\\\"https://bgr.com/2018/12/23/google-search-christmas-state-by-state/\\\" target=\\\"_blank\\\">Here are the most Googled queries in each state around Christmastime</a>&nbsp;&nbsp;<font color=\\\"#6f6f6f\\\">BGR</font><p>The Christmas holiday is a time of gift-giving, family get-togethers, and singing carols. We get time off from work, we get to spend time with the ones we love, ...</p>");
        thirdFeedMessage.setTextDescription("Here are the most Googled queries in each state around ChristmastimeBGRThe Christmas holiday is a time of gift-giving, family get-togethers, and singing carols. We get time off from work, we get to spend time with the ones we love, ...");
        thirdFeedMessage.setSource("https://bgr.com");
        thirdFeedMessage.setItemTimeStamp(new Timestamp(System.currentTimeMillis()));
        thirdFeedMessage.setFetchTimeStamp(new Timestamp(System.currentTimeMillis()));

    }

    @Test
    public void findAll() throws Exception {

        feedMessageRepository.save(firstFeedMessage);

        List<FeedMessage> feedMessageList = feedMessageRepository.findAll();

        assertThat(feedMessageList.size() == 1);
        assertThat(feedMessageList.get(0).equals(firstFeedMessage));

    }

    @Test
    public void findLastItems() throws Exception {

        feedMessageRepository.save(secondFeedMessage);

        List<FeedMessage> feedMessageList = feedMessageRepository.findLastItems(1);

        assertThat(feedMessageList.size()).isEqualTo(1);

    }

    @Test
    public void save() throws Exception {

        FeedMessage feedMessage = feedMessageRepository.save(thirdFeedMessage);

        assertThat(feedMessage).isEqualTo(thirdFeedMessage);

    }

}