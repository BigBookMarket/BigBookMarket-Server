package com.bigbookmarket;

import com.bigbookmarket.domain.Item;
import com.bigbookmarket.domain.ItemRepository;
import com.bigbookmarket.domain.Post;
import com.bigbookmarket.domain.PostRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    ItemRepository itemRepository;
    PostRepository postRepository;

    @Test
    public void itemTest() {
        List<Item> list = itemRepository.findAll();
        List<Post> list2 = postRepository.findAllDesc();
        System.out.println(list.get(0).getMethod());
        System.out.println(list.get(0).getStatus());
        System.out.println(list2.get(0).getPostId());
    }

}
