package com.pangpang.level1.controller;

import com.pangpang.level1.entity.Board;
import com.pangpang.level1.model.BoardDto;
import com.pangpang.level1.repository.BoardRepository;
import com.pangpang.level1.service.BoardService;
import com.pangpang.level1.service.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardServiceImpl boardServiceImpl;
    private final BoardRepository boardRepository;

    /*
    * api 설정 : 생성, 조회, 수정, 삭제
    *
    * 생성 : createBorad  =>(POST) api/boards
    * 조회 : getBoards => (GET) api/boards
    * 하나만 조회 : getOneBoard => (GET) api/board
    * 수정 : updateBoard => (PATCH) api/board
    * 삭제 : deleteBoard => (DELETE) api/board
    *
    * */

    @PostMapping("/api/boards")
    public Board createBoard(@RequestBody BoardDto boardDto){
        Board board = new Board(boardDto);
        return boardRepository.save(board);
    }

    @GetMapping("api/boards")
    public List<Board> getBoards(){
        return boardRepository.findAllByOrderByModifiedAtDesc();
    }

    @GetMapping("/api/board/{id}")
    public Board getOneBoard(@PathVariable Long id){
        // 파라미터 던져주기
        return boardServiceImpl.getOneBoard(id);
    }

    @DeleteMapping("/api/board/{id}")
    public Long deleteBoard(@PathVariable Long id){
        boardRepository.deleteById(id);
        return id;
    }

    @PatchMapping("/api/board/{id}")
    public Long updateBoard(@PathVariable Long id, @RequestBody BoardDto boardDto){
        boardServiceImpl.updateBoard(id, boardDto);
        return id;
    }



}
