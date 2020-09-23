package com.zte.sunquan.spring;

import com.zte.sunquan.spring.bean.Book;
import com.zte.sunquan.spring.dao.ReadingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ReadingListController class
 *
 * @author 10184538
 * @date 2019/6/18
 * 在controller上加注解@Controller 和@RestController都可以在前端调通接口，
 * 但是二者的区别在于，当用前者的时候在方法上必须添加注解@ResponseBody，
 * 如果不添加@ResponseBody，就会报上面错误，因为当使用@Controller 注解时，
 * spring默认方法返回的是view对象（页面）。而加上@ResponseBody，则方法返回的就是具体对象了。
 * @RestController的作用就相当于@Controller+@ResponseBody的结合体
 */
@Controller
@RequestMapping("/readingList")
//@ResponseBody
public class ReadingListController {
    private ReadingListRepository readingListRepository;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository) {
        this.readingListRepository = readingListRepository;
    }


    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public String readersBooks(@PathVariable("reader") String reader, Model model) {
        List<Book> readingList = readingListRepository.findByReader(reader);
        if (readingList != null && !readingList.isEmpty()) {
            model.addAttribute("books", readingList);
        }
        return "readingList";
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    public String addToReadingList(@PathVariable("reader") String reader, Book book) {
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/readingList/{reader}";
    }

    @GetMapping("order/by-user/{id}")
    @ResponseBody
    public String getOrderByUser(@PathVariable("id") String id) {
        System.out.println("port:"+serverPort);
        return "order:" + id;
    }
}
