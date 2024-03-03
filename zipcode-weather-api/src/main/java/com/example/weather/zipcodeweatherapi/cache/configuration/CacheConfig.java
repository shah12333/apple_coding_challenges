package com.example.weather.zipcodeweatherapi.cache.configuration;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.RemovalCause;
import com.github.benmanes.caffeine.cache.RemovalListener;


@Configuration
public class CacheConfig {

	    @Bean
	    public CacheManager cacheManager() {
	        CaffeineCacheManager cacheManager = new CaffeineCacheManager("weatherCache");
	        cacheManager.setAllowNullValues(false); //can happen if you get a value from a @Cachable that returns null
	        cacheManager.setCaffeine(caffeineCacheBuilder());
	        return cacheManager;
	    }
	 
	 Caffeine<Object, Object> caffeineCacheBuilder() {
	        return Caffeine.newBuilder()
	        		.initialCapacity(100)
	        		.maximumSize(1000)
	        		.expireAfterAccess(1, TimeUnit.MINUTES)
	        		.expireAfterWrite(30, TimeUnit.MINUTES)
	                .removalListener(new CustomRemovalListener())
	                .recordStats();
	    }
	 

	 
	 
	 class CustomRemovalListener implements RemovalListener<Object, Object>{
	        @Override
	        public void onRemoval(Object key, Object value, RemovalCause cause) {
	            System.out.format("removal listerner called with key [%s], cause [%s], evicted [%S]\n", 
	                    key, cause.toString(), cause.wasEvicted());
	        }
	    }
	 
	 
	
	 
	 
	 
}
