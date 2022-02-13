package com.pangpang.level1.entity;

import com.pangpang.level1.model.ReplyDto;
import com.pangpang.level1.model.Timestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Reply extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long replyId;

    @Column(nullable = false)
    private Long boardId;

    @Column(nullable = false)
    private String replyUsername;

    @Column(nullable = false)
    private String replyText;

    public Reply(Long boardId, String replyUsername, String replyText) {
        this.boardId = boardId;
        this.replyUsername = replyUsername;
        this.replyText = replyText;
    }
    // Dto 로 받아오는 생성자 만들기
    public Reply(ReplyDto replyDto){
        this.boardId = replyDto.getBoardId();
        this.replyUsername = replyDto.getReplyUsername();
        this.replyText = replyDto.getReplyText();
    }

    public void update(ReplyDto replyDto) {
        this.replyUsername = replyDto.getReplyUsername();
        this.replyText = replyDto.getReplyText();
    }
}
