package com.pangpang.level1.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReplyDto {

    private Long boardId;
    private String replyUsername;
    private String replyText;

}
