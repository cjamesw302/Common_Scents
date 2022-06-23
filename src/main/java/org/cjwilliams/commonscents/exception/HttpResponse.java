package org.cjwilliams.commonscents.exception;

import org.springframework.http.HttpStatus;

public class HttpResponse {
	private int httpStatusCode;
	
	private HttpStatus httpStatus;
	
	private String reason;
	
	private String message;

	public HttpResponse(int httpStatusCode, HttpStatus httpStatus, String reason, String message) {
		this.httpStatusCode = httpStatusCode;
		this.httpStatus = httpStatus;
		this.reason = reason;
		this.message = message;
	}
	
	public HttpResponse() {}
}