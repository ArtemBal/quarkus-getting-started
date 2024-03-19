package org.artem.balan.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import jakarta.persistence.Entity;
import lombok.*;


@Data
@Entity
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book extends PanacheEntity {
    private String title;
    private String author;
}
