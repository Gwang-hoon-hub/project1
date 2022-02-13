package com.pangpang.level1.service;

import com.pangpang.level1.entity.Reply;
import com.pangpang.level1.model.ReplyDto;
import com.pangpang.level1.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl {

    private final ReplyRepository replyRepository;

    @Transactional
    public Long createReply(Long replyId, ReplyDto replyDto){
        Reply reply = new Reply(replyDto);
        replyRepository.save(reply);
        return replyId;
    }

//    @Transactional
//    public List<Reply> getReply(Long boardId) {
//        List<Reply> replyList = replyRepository.findAllByBoardIdOrderByModifiedAtDesc(boardId);
//        return replyList;
//    }

    @Transactional
    public Long updateReply(Long replyId, ReplyDto replyDto) {
        Reply reply = replyRepository.findById(replyId).orElseThrow(
                () -> new NullPointerException("아이디 없음.")
        );
        reply.update(replyDto);
        return replyId;
    }



}
