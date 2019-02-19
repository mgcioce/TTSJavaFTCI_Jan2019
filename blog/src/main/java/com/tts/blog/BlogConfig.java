package com.tts.blog;

import com.tts.blog.model.BlogPost;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class BlogConfig {

    @Bean
    public ArrayList<BlogPost> blogPosts() {

        return new ArrayList<BlogPost>();
    }
}
