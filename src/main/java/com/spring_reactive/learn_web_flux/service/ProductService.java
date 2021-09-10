package com.spring_reactive.learn_web_flux.service;

import com.spring_reactive.learn_web_flux.dto.ProductDto;
import com.spring_reactive.learn_web_flux.repository.ProductRepository;
import com.spring_reactive.learn_web_flux.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }


    public Mono<ProductDto> createProduct(Mono<ProductDto>productDtoMono){
       return productDtoMono.map(AppUtils::dtoToEntity)
                .flatMap(repository::insert)
                .map(AppUtils::entityToDto);
    }

    public Flux<ProductDto> getProducts(){
        return repository.findAll().map(AppUtils::entityToDto);
    }

    public Mono<ProductDto> getProduct(String id){
        return repository.findById(id).map(AppUtils::entityToDto);
    }

    public Flux<ProductDto> getProductByRange(double min,double max){
    return repository.findByPriceBetween(Range.closed(min,max));
    }

    public Mono<ProductDto> updateProduct(Mono<ProductDto> productDtoMono,String id){
      return   repository.findById(id)
                .flatMap(p -> productDtoMono.map(AppUtils::dtoToEntity)
                        .doOnNext(e -> e.setId(id)))
                        .flatMap(repository::save)
                        .map(AppUtils::entityToDto);

    }

    public Mono<Void> deleteProduct(String id){
        return repository.deleteById(id);
    }

}
