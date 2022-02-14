package com.pangpang.level1.controller;

import com.pangpang.level1.entity.Board;
import com.pangpang.level1.entity.Reply;
import com.pangpang.level1.model.BoardDto;
import com.pangpang.level1.model.ReplyDto;
import com.pangpang.level1.repository.BoardRepository;
import com.pangpang.level1.repository.ReplyRepository;
import com.pangpang.level1.service.ReplyServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyServiceImpl replyServiceImpl;
    private final ReplyRepository replyRepository;
    private final BoardRepository boardRepository;

    // 조회 : 게시판 글 id에 맞는 글 가져오기 ==> service 단으로 넘어가서 데이터 넘겨받기
    @GetMapping("/api/reply/{boardId}")
    public List<Reply> getReply(@PathVariable Long boardId){
        return  replyRepository.findAllByBoardIdOrderByModifiedAtDesc(boardId);
    }

    // 생성 : 게시판 글 id 갖고오기
    @PostMapping("api/reply")
    public Reply createReply(@RequestBody ReplyDto replyDto){
        Reply reply = new Reply(replyDto);
        return replyRepository.save(reply);
    }

    //삭제
    @DeleteMapping("/api/reply/{replyId}")
    public Long deleteBoard(@PathVariable Long replyId){
        replyRepository.deleteById(replyId);
        return replyId;
    }

    // 업데이트
    @PatchMapping("/api/reply/{replyId}")
    public Long updateBoard(@PathVariable Long replyId, @RequestBody ReplyDto replyDto){
        replyServiceImpl.updateReply(replyId, replyDto);
        return replyId;
    }



}
