package com.melo_play.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "movies")
@Getter
@Setter
@NoArgsConstructor
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150, unique = true)
    private String title;

    @Column(nullable = false, length = 3)
    private Integer duration;

    @Column(nullable = false, length = 40)
    private String genre;

    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    @Column(precision = 3, scale = 2)
    private BigDecimal rating;

    @Column(nullable = false, length = 1)
    private String status;
}
