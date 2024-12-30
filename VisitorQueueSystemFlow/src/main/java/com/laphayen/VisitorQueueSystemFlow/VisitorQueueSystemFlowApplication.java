package com.laphayen.VisitorQueueSystemFlow;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.data.redis.core.ReactiveRedisTemplate;

@SpringBootApplication
@RequiredArgsConstructor
public class VisitorQueueSystemFlowApplication implements ApplicationListener<ApplicationReadyEvent> {

	private final ReactiveRedisTemplate<String, String> reactiveRedisTemplate;

	public static void main(String[] args) {
		SpringApplication.run(VisitorQueueSystemFlowApplication.class, args);
	}

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		reactiveRedisTemplate.opsForValue().set("testKey", "testValue").subscribe();
	}

}
