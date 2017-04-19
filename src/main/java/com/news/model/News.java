package com.news.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class News {

    @Id
    @GeneratedValue
    Long id;

    String Title;

    String Description;

    String Text;

    NewsCategory category;

    String Image1Url;

    String Image2Url;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name="created", nullable = false)
    public Date created;

    // Type(type="yes_no")
    @Column(columnDefinition="boolean default false")
    public boolean deleted;
}
