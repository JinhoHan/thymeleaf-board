package com.acma.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acma.app.domain.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

}
