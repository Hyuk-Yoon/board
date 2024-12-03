package board.board.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import board.board.dto.BoardDto;
import board.board.service.BoardService;

@RestController
@Tag(name = "게시판 API", description = "게시판 REST API")
public class RestBoardApiController {
	
	@Autowired
	private BoardService boardService;

	@Operation(summary = "리스트 조회", description = "게시글 전체 리스트를 전달")
	@RequestMapping(value="/api/board", method=RequestMethod.GET)
	public List<BoardDto> openBoardList() throws Exception{
		return boardService.selectBoardList();
	}

	@Operation(summary = "게시글 작성", description = "게시글 작성")
	@RequestMapping(value="/api/board/write", method=RequestMethod.POST)
	public void insertBoard(@RequestBody BoardDto board) throws Exception{
		boardService.insertBoard(board, null);
	}

	@Operation(summary = "게시글 조회", description = "게시글 상세 조회")
	@RequestMapping(value="/api/board/{boardIdx}", method=RequestMethod.GET)
	public BoardDto openBoardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception{
		
		return boardService.selectBoardDetail(boardIdx);
	}

	@Operation(summary = "게시글 수정", description = "게시글 수정")
	@RequestMapping(value="/api/board/{boardIdx}", method=RequestMethod.PUT)
	public String updateBoard(@RequestBody BoardDto board) throws Exception{
		boardService.updateBoard(board);
		return "redirect:/board";
	}

	@Operation(summary = "게시글 삭제", description = "게시글 삭제")
	@RequestMapping(value="/api/board/{boardIdx}", method=RequestMethod.DELETE)
	public String deleteBoard(@PathVariable("boardIdx") int boardIdx) throws Exception{
		boardService.deleteBoard(boardIdx);
		return "redirect:/board";
	}
}
