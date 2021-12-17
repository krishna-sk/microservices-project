package com.krishna.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.krishna.entity.Product;
import com.krishna.model.ProductModel;
import com.krishna.repository.ProductRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ProductModel>> findAll() {

        List<ProductModel> products = productRepository.findAll().stream()
                .collect(Collectors.mapping(product -> mapToModel(product), Collectors.toList()));
        return ResponseEntity.ok(products);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createProduct(@Valid @RequestBody ProductModel productModel) {
        productRepository.save(mapToEntity(productModel));
        return ResponseEntity.ok("Product saved successfully");
    }

    private Product mapToEntity(ProductModel productModel) {
        return modelMapper.map(productModel, Product.class);
    }

    private ProductModel mapToModel(Product product) {
        return modelMapper.map(product, ProductModel.class);
    }

}
