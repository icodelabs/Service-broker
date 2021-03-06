package org.openpaas.servicebroker.mongodb.exception;

import org.openpaas.servicebroker.exception.ServiceBrokerException;


/**
 * Exception thrown when issues with the underlying mongo service occur.
 * NOTE: com.mongodb.MongoException is a runtime exception and therefore we 
 * want to have to handle the issue.
 * 
 * @author 
 *
 */
public class MongoServiceException extends ServiceBrokerException {

	private static final long serialVersionUID = 8667141725171626000L;

	public MongoServiceException(String message) {
		super(message);
	}
	
}
