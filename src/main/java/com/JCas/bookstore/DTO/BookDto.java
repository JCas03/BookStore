package com.JCas.bookstore.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private String title;
    private String description;
    private int id;
    private int releaseYear;
}
