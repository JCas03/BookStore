package com.JCas.bookstore.Service;

import com.JCas.bookstore.DTO.BookDto;
import com.JCas.bookstore.Repository.BookRepository;
import com.JCas.bookstore.model.Book;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class BookService {

    private final BookRepository bookRepository;

    private final ModelMapper modelMapper;

    public BookService(BookRepository bookRepository, ModelMapper modelMapper){
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    public List<BookDto> getBooks(){
        Iterable<Book> all = bookRepository.findAll();
        return StreamSupport.stream(all.spliterator(),false)
                .map(convertBookModelToBookdto())
                .collect(Collectors.toList());
    }

    private Function<Book, BookDto> convertBookModelToBookdto() {
        return book -> modelMapper.map(book, BookDto.class);
    }
}
