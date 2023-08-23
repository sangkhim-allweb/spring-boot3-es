package com.sangkhim.spring_boot3_es.model.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "authors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author implements Serializable {

  private static final long serialVersionUID = 7156526077883281623L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "name")
  private String name;

  @OneToMany(mappedBy = "author")
  List<Post> postList;

  @CreationTimestamp(source = SourceType.DB)
  private Instant createdOn;

  @UpdateTimestamp(source = SourceType.DB)
  private Instant lastUpdatedOn;
}
