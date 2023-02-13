package com.example.homework27.Service;


import com.example.homework27.Exception.ApiException;
import com.example.homework27.Model.Blog;
import com.example.homework27.Model.MyUser;
import com.example.homework27.Repository.BlogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;


    public List<Blog> getBlogs(MyUser myUser) {
        List<Blog> allBlogs= blogRepository.findAll();

        List<Blog> userBlogs = new ArrayList<>();

        for (Blog blog : allBlogs) {
            if(blog.getMyUser().getId()== myUser.getId()){
                userBlogs.add(blog);
            }
        }
        return userBlogs;
    }


    public Blog getBlog(MyUser myUser, Integer id) {
        Blog blog = blogRepository.findBlogById(id);
        if(blog== null || blog.getMyUser().getId() != myUser.getId()){
            throw new ApiException("This blog does not exist");
        }
        return blog;
    }




    public void addBlog(MyUser myUser,Blog blog) {
        blog.setMyUser(myUser);

        blogRepository.save(blog);
    }

    public void UpdateBlog(MyUser myUser, Integer BlogId , Blog blog) {
        Blog currentBlog= getBlog(myUser, BlogId);

        blog.setId(currentBlog.getId());
        blog.setMyUser(myUser);
        blogRepository.save(blog);
    }

    public void removeBlog(MyUser myUser, Integer BlogId) {
        Blog blog= getBlog(myUser, BlogId);

        blogRepository.deleteById(BlogId);
    }


    public Blog findBlogByTitle(MyUser myUser, String title){
        Blog blog = blogRepository.findBlogByTitle(title);

        if(blog== null || blog.getMyUser().getId() != myUser.getId()){
            throw new ApiException("This blog does not exist");
        }
        return blog;
    }



}
