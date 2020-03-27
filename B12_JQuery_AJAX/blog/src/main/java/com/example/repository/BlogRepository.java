package com.example.repository;

import com.example.model.Blog;
import com.example.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends PagingAndSortingRepository<Blog, Long> {
    Iterable<Blog> findAllByCategory(Category category);

    Iterable<Blog> findByNameBlogContaining(String nameBlog);
}
