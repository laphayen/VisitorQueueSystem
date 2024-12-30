package com.laphayen.VisitorQueueSystemFlow.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class UserQueueService {

    private final ReactiveRedisTemplate<String, String> reactiveRedisTemplate;

    public Mono<Long> registerWaitQueue(final  Long userId) {
        var unixTimestamp = Instant.now().getEpochSecond();

        return reactiveRedisTemplate.opsForZSet().add("user-queue", userId.toString(), unixTimestamp)
                .filter(i -> i)
                .switchIfEmpty(Mono.error(new RuntimeException("User queue already exists")))
                .flatMap(i -> reactiveRedisTemplate.opsForZSet().rank("user-queue", userId.toString()))
                .map(i -> i >= 0 ? i+1 : i);

    }

}
