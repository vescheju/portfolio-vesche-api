package com.vesche.portfolio_vesche.configuration;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Configuration
public class RestConfiguration {

    private final int connectTimeout;

    private final int readTimeout;

    private final int writeTimeout;

    public RestConfiguration(@Value("CONNECT_TIMEOUT_SECONDS") final int connectTimeout,
                             @Value("READ_TIMEOUT_SECONDS") final int readTimeout,
                             @Value("WRITE_TIMEOUT_SECONDS") final int writeTimeout) {
        this.connectTimeout = connectTimeout;
        this.readTimeout = readTimeout;
        this.writeTimeout = writeTimeout;
    }

    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(HttpClient.create()
                        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, this.connectTimeout * 1000)
                        .doOnConnected(conn -> conn
                                .addHandlerLast(new ReadTimeoutHandler(this.readTimeout))
                                .addHandlerLast(new WriteTimeoutHandler(this.writeTimeout)))));
    }

}
