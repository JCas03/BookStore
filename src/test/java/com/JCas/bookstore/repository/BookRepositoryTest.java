package com.JCas.bookstore.repository;

import com.JCas.bookstore.Repository.BookRepository;
import com.JCas.bookstore.model.Book;
import lombok.Data;
import org.h2.tools.Script;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.StreamSupport;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    @Sql(scripts = {"classpath:insertInitialBookRecordForTest.sql "})
    void shouldAbleToFetchAllBooksInDB(){
        Iterable<Book> all = bookRepository.findAll();
        Long totalBookCount = StreamSupport.stream(all.spliterator(),false).count();
        Assertions.assertEquals(totalBookCount, 2);
    }

    @Test
    @Sql(scripts = {"classpath:insertInitialBookRecordForTest.sql "})
    void shouldReturnOneBookWhenTitleIsTestTitle(){
        List<Book> test_title = bookRepository.findBooksByTitle("test title");
        Assertions.assertEquals(test_title.size(), 1);

    }
}
