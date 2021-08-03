package com.meng;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    CategoryMapper categoryMapper;

    @RequestMapping("/getAllcategory")
    public List<Category> getAllcategory() {
        return categoryMapper.getCategories();
    }

    @RequestMapping("/getOne/{id}")
    public Category getOne(@PathVariable("id") int id) {
        return categoryMapper.getCategotyById(id);
    }
}
