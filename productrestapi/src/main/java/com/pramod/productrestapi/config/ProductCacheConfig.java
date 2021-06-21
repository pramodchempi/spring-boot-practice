package com.pramod.productrestapi.config;

import com.hazelcast.config.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductCacheConfig {

    @Bean
    public Config cacheConfig() {
        return new Config()
                   .setInstanceName("hazel-instance")
                   .addMapConfig(new MapConfig()
                   .setName("product-cache")
                   .setEvictionConfig(new EvictionConfig().setMaxSizePolicy(MaxSizePolicy.FREE_HEAP_SIZE)
                           .setEvictionPolicy(EvictionPolicy.LRU)));
    }
}
