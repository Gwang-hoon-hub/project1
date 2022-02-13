package com.pangpang.level1.entity;

import com.pangpang.level1.model.BoardDto;
import com.pangpang.level1.model.Timestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Board extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    public Board(String username, String contents) {
        this.username = username;
        this.contents = contents;
    }

    // Dto로 받아오는 생성자 있어야됨
    public Board(BoardDto boardDto){
        this.username = boardDto.getUsername();
        this.contents = boardDto.getContents();
    }

    // update는 반드시 테이블에 접근을 하여 데이터를 바꿔주어야한다.
    // 따라서 해당 메소드는 entity에 있어야한다.
    public void update(BoardDto boardDto){
        this.username = boardDto.getUsername();
        this.contents = boardDto.getContents();
    }
}
