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

  @Id @GeneratedValue Long id;

  String Title;

  String Description;

  @Column(columnDefinition = "TEXT") String Text;

  NewsStatus status;

  NewsCategory category;

  String ImageName1;

  String ImageName2;

  @Temporal(TemporalType.DATE) @DateTimeFormat(pattern = "yyyy-MM-dd") @Column(name = "created", nullable = false)
  public Date created;

  @Column(columnDefinition = "boolean default false") public boolean deleted;
}
