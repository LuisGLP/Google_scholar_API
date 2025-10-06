package com.challenge3.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String authors;
    private String year;
    private String link;
    private int citedBy;

    // Relación muchos a uno con Author
    @ManyToOne
    @JoinColumn(name = "author_id")
    @JsonIgnore
    private Author author;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthors() { return authors; }
    public void setAuthors(String authors) { this.authors = authors; }

    public String getYear() { return year; }
    public void setYear(String year) { this.year = year; }

    public String getLink() { return link; }
    public void setLink(String link) { this.link = link; }

    public int getCitedBy() { return citedBy; }
    public void setCitedBy(int citedBy) { this.citedBy = citedBy; }

    public Author getAuthor() { return author; }
    public void setAuthor(Author author) { this.author = author; }
}