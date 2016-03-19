package util;

import java.time.Duration;
import java.time.Instant;

/**
 * @author Mike
 *
 * Uses JAVA8 time services
 */
public class ElapsedTime {
	
	Instant startTime;
	Instant endTime;

	public void start() {
		startTime = Instant.now();
	}
	
	public void stop() {
		endTime = Instant.now();

	}
	
	public long getElapsedTimeNano() {
		return Duration.between(startTime, endTime).toNanos();
	}
	
	public long getElapsedTimeMilliseconds() {
		return Duration.between(startTime, endTime).toMillis();
	}
	
	public long getElapsedTimeSeconds() {
		return Duration.between(startTime, endTime).getSeconds();
	}
}
