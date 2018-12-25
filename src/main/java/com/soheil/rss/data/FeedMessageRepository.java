package com.soheil.rss.data;

import com.soheil.rss.data.model.FeedMessage;

import java.util.List;

/**
 * @author : parvizis
 * @since : 12/22/18
 */
public interface FeedMessageRepository {

    List<FeedMessage> findAll();

    List<FeedMessage> findLastItems(int i);

    FeedMessage save(FeedMessage feedMessage);

}
