package com.pangpang.level1.repository;

import com.pangpang.level1.entity.Board;
import com.pangpang.level1.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    List<Reply> findAllByBoardIdOrderByModifiedAtDesc(Long boardId);
}
