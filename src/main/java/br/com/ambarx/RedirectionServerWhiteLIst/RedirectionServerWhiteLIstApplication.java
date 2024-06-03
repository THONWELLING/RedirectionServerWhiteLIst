package br.com.ambarx.RedirectionServerWhiteLIst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.route.RouteLocator;

@SpringBootApplication
public class RedirectionServerWhiteLIstApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedirectionServerWhiteLIstApplication.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
			.route("amazon_route", route -> route.path("/amazon/**")
				.filters(filter -> filter.stripPrefix(1))
				.uri("https://api.amazon.com")
			)
			.route("mercado_livre_route", route -> route.path("/mercadolivre/**")
					.filters(filter -> filter.stripPrefix(1))
					.uri("https://api.mercadolibre.com")
			)
			.route("shopee_route", route -> route.path("/shopee/**")
					.filters(filter -> filter.stripPrefix(1))
					.uri("https://api.shopee.com")
			)
			.build();
	}

}
