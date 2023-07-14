package com.lifesup.jpadata.controller;

import com.lifesup.jpadata.dto.ProductDto;
import com.lifesup.jpadata.repository.ProductRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class HomeController {

    private final ProductRepository productRepository;

    public HomeController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(value = "/all-product")
    public Page<ProductDto> getAllProduct() {
        Pageable page = PageRequest.of(0, 10);
        Page<ProductDto> productDtoList = productRepository.getAllNested(page);
        log.info("ok");
        return productDtoList;
    }
}
