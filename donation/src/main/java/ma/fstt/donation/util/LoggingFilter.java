package ma.fstt.donation.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import reactor.core.publisher.Mono;

public class LoggingFilter implements ExchangeFilterFunction {
    private static final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    public Mono<ClientResponse> filter(ClientRequest request, ExchangeFunction next) {
        logger.info("Request: {} {}", request.method(), request.url());
        return next.exchange(request)
                .doOnSuccess(response -> logger.info("Response: {}", response.statusCode()));
    }
}
