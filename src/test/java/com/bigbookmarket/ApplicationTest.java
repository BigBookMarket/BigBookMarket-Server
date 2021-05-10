package com.bigbookmarket;

import com.bigbookmarket.domain.Item;
import com.bigbookmarket.domain.ItemRepository;
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

    @Test
    public void itemTest() {
        List<Item> list = itemRepository.findAll();
        System.out.println(list.get(0).getMethod());
        System.out.println(list.get(0).getStatus());
    }

}
