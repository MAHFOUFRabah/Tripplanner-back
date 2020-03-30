package org.sid.sec;

public interface SecurityParams {

    String HEADER_NAME = "Authorization";
    String SECRET = "ramaBNHY";
    long EXPIRATION = 10 * 24 * 3600 * 1000;
    String HEADER_PREFIX = "Bearer ";
}
