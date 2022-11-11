package com.JCas.bookstore.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "BookDto", description = "All details about book")
public class BookDto {
    @ApiModelProperty(
            readOnly = true,
            value = "ID",
            dataType = "Int",
            example = "1",
            notes = "The database generated id for book id",
            required = true
    )
    private int id;

    @ApiModelProperty(
            readOnly = true,
            value = "title",
            dataType = "String",
            example = "Book Title",
            notes = "Book Title",
            required = true
    )
    private String title;

    @ApiModelProperty(
            readOnly = true,
            value = "description",
            dataType = "String",
            example = "Book Description",
            notes = "Book Description",
            required = true
    )
    private String description;

    @ApiModelProperty(
            readOnly = true,
            value = "releaseYear",
            dataType = "Int",
            example = "2022",
            notes = "Book Release Year",
            required = true
    )
    private int releaseYear;
}
