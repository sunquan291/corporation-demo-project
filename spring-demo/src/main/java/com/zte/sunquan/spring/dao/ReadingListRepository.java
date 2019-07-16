package com.zte.sunquan.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zte.sunquan.spring.bean.Book;

/**
 * ReadingListRepository class
 *
 * @author 10184538
 * @date 2019/7/13
 */
public interface ReadingListRepository extends JpaRepository<Book, Long> {
    List<Book> findByReader(String reader);
}
