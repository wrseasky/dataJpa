package com.baidu.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jhon on 2018/3/31.
 */
@Configuration
public class RedisClusterConfig {

    @Value("${spring.redis.cluster.nodes}")
    private String redisNodes;

    @Bean
    public JedisCluster getJedisCluster(){
        Set<HostAndPort> nodes = new HashSet<>();
        String[] split = redisNodes.split(",");
        for (String str:split) {
            String[] hp = str.split(":");
            nodes.add(new HostAndPort(hp[0],Integer.parseInt(hp[1])));
        }

        JedisCluster jedisCluster = new JedisCluster(nodes);
        return jedisCluster;
    }
}
