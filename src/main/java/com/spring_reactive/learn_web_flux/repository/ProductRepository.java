package com.spring_reactive.learn_web_flux.repository;

import com.spring_reactive.learn_web_flux.dto.ProductDto;
import com.spring_reactive.learn_web_flux.entity.Product;
import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product,String> {
    Flux<ProductDto> findByPriceBetween(Range<Double>PriceRange);
}
