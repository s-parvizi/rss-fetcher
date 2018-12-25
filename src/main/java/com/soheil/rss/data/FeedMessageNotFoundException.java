package com.soheil.rss.data;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FeedMessageNotFoundException extends RuntimeException {

	public FeedMessageNotFoundException(String exception) {
		super(exception);
	}

}
