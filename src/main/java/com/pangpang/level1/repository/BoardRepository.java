package com.pangpang.level1.repository;

import com.pangpang.level1.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    // 커스텀 메소드를 만들기
    // jpa가 알아서 문법에 맞게 데이터를 정렬하고 돌려준다.
    List<Board> findAllByOrderByModifiedAtDesc();
    //findAll OrderBy ModifiedAt Desc
}
