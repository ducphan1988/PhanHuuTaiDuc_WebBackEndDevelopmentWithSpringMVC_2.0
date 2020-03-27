package com.example.controller;

import com.example.model.Blog;
import com.example.model.Category;
import com.example.repository.BlogRepository;
import com.example.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @ModelAttribute("categories")
    public Iterable<Category> categories() {
        return categoryRepository.findAll();
    }

    @GetMapping("")
    public ModelAndView listBlog() {
        Iterable<Blog> blogs = blogRepository.findAll();
        return new ModelAndView("/blog/list", "blogs", blogs);
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        return new ModelAndView("/blog/create", "blog", new Blog());
    }

    @PostMapping("/create")
    public ModelAndView saveBlog(@ModelAttribute("blog") Blog blog) {
        blogRepository.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView findById(@PathVariable Long id) {
        Optional<Blog> blog = blogRepository.findById(id);
        if (blog != null) {
            return new ModelAndView("/blog/view", "blog", blog);

        } else {
            ModelAndView modelAndView = new ModelAndView("/error");
            return modelAndView;
        }
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Blog blog = blogRepository.findById(id).orElse(null);
        if (blog != null) {
            return new ModelAndView("/blog/edit", "blog", blog);
        } else {
            return new ModelAndView("/error");
        }
    }

    @PostMapping("/edit")
    public ModelAndView updateBlog(@ModelAttribute("blog") Blog blog) {
        blogRepository.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Blog updated successfully");
        return modelAndView;
    }

    @GetMapping("/{id}/delete")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Blog> blog = blogRepository.findById(id);
        if (blog != null) {
            return new ModelAndView("/blog/delete", "blog", blog);
        } else {
            return new ModelAndView("/error");
        }
    }

    @PostMapping("/{id}/delete")
    public String deleteBlog(@PathVariable("id")Long id) {
        blogRepository.deleteById(id);
        return "redirect:/";
    }
    @GetMapping("/search")
    public ModelAndView showSearchForm() {
        return new ModelAndView("/blog/search.html", "blog", new Blog());
    }

    @RequestMapping(value = "/searchAjax", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<Blog> searchAjax(@RequestBody Blog blog) {
        return blogRepository.findByNameBlogContaining(blog.getNameBlog());
    }
}
