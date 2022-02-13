package com.pangpang.level1.service;

import com.pangpang.level1.entity.Board;
import com.pangpang.level1.model.BoardDto;
import com.pangpang.level1.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    @Transactional
    @Override
    public Long updateBoard(Long id, BoardDto boardDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new NullPointerException("아이디 없음.")
        );
        board.update(boardDto);
        return id;
    }

    @Transactional
    @Override
    public Board getOneBoard(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new NullPointerException("데이터 없음.")
        );
        return board;
    }

    @Transactional
    @Override
    public List<Board> getAllBoard() {
        List<Board> boardList = boardRepository.findAllByOrderByModifiedAtDesc();
        return boardList;
    }

    @Transactional
    @Override
    public void createBoard(Long id, BoardDto boardDto) {
        if(boardRepository.existsById(id)) {
            new IllegalAccessException("존재하는데 왜 넣냐");
        }else{
            // 데이터를 테이블에 넣기 위해서는 ENTITY에 접근을 해야한다.
            Board board = new Board(boardDto);
            boardRepository.save(board);
        }
    }
}
