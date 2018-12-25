package com.soheil.rss.data.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * @author : parvizis
 * @since : 12/22/18
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedMessage {

    @NotNull
    private String id;

    private String link;

    @NotNull
    private String title;

    @NotNull
    private String htmlDescription;

    @NotNull
    private String textDescription;

    private String source;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ", timezone = "GMT")
    private Timestamp itemTimeStamp;

    @NotNull
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ", timezone = "GMT")
    private Timestamp fetchTimeStamp;

}
