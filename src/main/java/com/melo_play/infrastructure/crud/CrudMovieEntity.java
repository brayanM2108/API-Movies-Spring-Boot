package com.melo_play.infrastructure.crud;

import com.melo_play.infrastructure.persistence.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudMovieEntity extends JpaRepository<MovieEntity, Long> {

    MovieEntity findByTitle(String title);
}
