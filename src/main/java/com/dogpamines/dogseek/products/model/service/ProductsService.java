package com.dogpamines.dogseek.products.model.service;

import com.dogpamines.dogseek.products.model.dao.ProductsMapper;
import com.dogpamines.dogseek.products.model.dto.ProductsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    private ProductsMapper productsMapper;

    @Autowired
    public ProductsService(ProductsMapper productsMapper) {this.productsMapper = productsMapper;}

    public List<ProductsDTO> selectAllProducts() {
        return productsMapper.selectAllProducts();
    }

    public Object selectFindByCode(int prodCode) {
        return productsMapper.selectFindByCode(prodCode);
    }

    public List<ProductsDTO> productsComparison(int prodCode1, int prodCode2) {
        return productsMapper.productsComparison(prodCode1, prodCode2);
    }
}
