package com.pangpang.level1.service;

import com.pangpang.level1.entity.Board;
import com.pangpang.level1.model.BoardDto;

import java.util.List;

public interface BoardService {
    /*
    * 생성 => 데이터 객체를 넣기만 하면 된다.
    * 삭제 =>
    * 조회 =>
    * 하나만 조회 => 받아온 데이턱 있는지 확인하여 id에 맞는 데이터 보여주기
    * 수정 =>
    *
    * */

    public Long updateBoard(Long id, BoardDto boardDto);

    public Board getOneBoard(Long id);
    // 자바스크립트에서 데이터가 하나만 들어오느지 체크하는 함수를 작성하기

    public List<Board> getAllBoard();

    public void createBoard(Long id, BoardDto boardDto);

}
