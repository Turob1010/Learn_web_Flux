package com.spring_reactive.learn_web_flux.utils;

import com.spring_reactive.learn_web_flux.dto.ProductDto;
import com.spring_reactive.learn_web_flux.entity.Product;
import org.springframework.beans.BeanUtils;


public class AppUtils {

    public static ProductDto entityToDto(Product product){
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product,productDto);
        return productDto;
    }
    public static Product dtoToEntity(ProductDto productDto){
        Product product = new Product();
        BeanUtils.copyProperties(productDto,product);
        return product;
    }
}
