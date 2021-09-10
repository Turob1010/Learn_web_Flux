package com.spring_reactive.learn_web_flux.resource;


import com.spring_reactive.learn_web_flux.dto.ProductDto;
import com.spring_reactive.learn_web_flux.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductResource {
    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public Mono<ProductDto> createProduct(@RequestBody Mono<ProductDto> productDtoMono){
        return productService.createProduct(productDtoMono)
                .log("create method access");
    }
    @GetMapping("/getall")
    public Flux<ProductDto> getproducts(){
        return productService.getProducts().log("get all method access");
    }
    @GetMapping("/getbyid/{id}")
    public  Mono<ProductDto> getProductById(@PathVariable String id){

        return productService.getProduct(id).log("get by id method access");
    }

    @GetMapping("/getrange")
    public  Flux<ProductDto> getByRange(@RequestParam ("min") double min,@RequestParam ("max") double max){
        return productService.getProductByRange(min, max).log("get by range method access");
    }

    @PutMapping("/update/{id}")
    public Mono<ProductDto> updateProduct(@RequestBody Mono<ProductDto>productDtoMono,@PathVariable String id){
        return productService.updateProduct(productDtoMono,id).log("update product method access");
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteProduct(@PathVariable String id){
        return  productService.deleteProduct(id)
                .log("delete method access");
    }

}
