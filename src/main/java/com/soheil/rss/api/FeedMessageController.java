package com.soheil.rss.api;

import com.soheil.rss.data.FeedMessageRepository;
import com.soheil.rss.data.model.FeedMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : parvizis
 * @since : 12/22/18
 */

@RestController
@RequestMapping(path = "/api/messages", produces = "application/json")
@CrossOrigin(origins = "*")
public class FeedMessageController {

    private FeedMessageRepository feedMessageRepository;

    @Autowired
    public FeedMessageController(FeedMessageRepository feedMessageRepository) {
        this.feedMessageRepository = feedMessageRepository;
    }

    @GetMapping
    @RequestMapping(path = "/all")
    public List<FeedMessage> allFeedMessages() {
        return feedMessageRepository.findAll();
    }

    @GetMapping
    @RequestMapping(path = "/last")
    public List<FeedMessage> lastFeedMessages(@RequestParam int items) {
        return feedMessageRepository.findLastItems(items);
    }

    @GetMapping
    @RequestMapping(path = "/lastten")
    public List<FeedMessage> lastTenFeedMessages() {
        return feedMessageRepository.findLastItems(10);
    }

}
