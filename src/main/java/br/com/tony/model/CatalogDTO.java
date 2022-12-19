package br.com.tony.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.ArrayList;
import java.util.List;

@XStreamAlias("catalog")
public class CatalogDTO {
    @XStreamImplicit(itemFieldName = "book")
    private List<BookDTO> books = new ArrayList<>();

    public List<BookDTO> getBooks() {
        return books;
    }

    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "CatalogDTO{" +
                "books=" + books +
                '}';
    }
}
