package com.soheil.rss.data;

import com.soheil.rss.data.model.FeedMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : parvizis
 * @since : 12/22/18
 */

@Repository
public class FeedMessageRepositoryImpl implements FeedMessageRepository {

    @Autowired
    private JdbcTemplate jdbc;

    @Autowired
    public FeedMessageRepositoryImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<FeedMessage> findAll() {

        List<FeedMessage> feedMessageList = jdbc.query("select id, link, title, html_desc, text_desc, source, item_time, fetch_time from Feed_Message order by fetch_time desc",
                this::mapRowToFeedMessage);

        if (feedMessageList.isEmpty())
            throw new FeedMessageNotFoundException("No feed message exists!");

        return feedMessageList;
    }

    @Override
    public List<FeedMessage> findLastItems(int i) {

        List<FeedMessage> feedMessageList = jdbc.query("select top(" + i + ") id, link, title, html_desc, text_desc, source, item_time, fetch_time from Feed_Message order by fetch_time desc",
                this::mapRowToFeedMessage);

        if (feedMessageList.isEmpty()) {
            throw new FeedMessageNotFoundException("No feed message exists!");
        }

        return feedMessageList;
    }

    @Override
    public FeedMessage save(FeedMessage feedMessage) {
        jdbc.update(
                "insert into Feed_Message (id, link, title, html_desc, text_desc, source, item_time, fetch_time) values (?, ?, ?, ?, ?, ?, ?, ?)",
                feedMessage.getId(),
                feedMessage.getLink(),
                feedMessage.getTitle(),
                feedMessage.getHtmlDescription(),
                feedMessage.getTextDescription(),
                feedMessage.getSource(),
                feedMessage.getItemTimeStamp(),
                feedMessage.getFetchTimeStamp());
        return feedMessage;
    }

    private FeedMessage mapRowToFeedMessage(ResultSet rs, int rowNum)
            throws SQLException {
        return new FeedMessage(
                rs.getString("id"),
                rs.getString("link"),
                rs.getString("title"),
                rs.getString("html_desc"),
                rs.getString("text_desc"),
                rs.getString("source"),
                rs.getTimestamp("item_time"),
                rs.getTimestamp("fetch_time")
        );
    }

}
