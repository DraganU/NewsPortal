package com.news.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class News {

  @Id
  @GeneratedValue
  private Long id;

  private String title;

  private String description;

  @Column(columnDefinition = "TEXT")
  private String text;

  private NewsStatus status;

  private NewsCategory category;

  private String imageName1;

  private String imageName2;

  @Temporal(TemporalType.DATE) @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Column(name = "created", nullable = false)
  private Date created;

  @Column(columnDefinition = "boolean default false")
  private boolean deleted;
}
