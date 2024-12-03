package board.board.dto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "게시글 내용")
public class BoardDto {

	@Schema(description = "게시글 번호")
	private int boardIdx;

	@Schema(description = "게시글 제목")
	private String title;

	@Schema(description = "게시글 내용")
	private String contents;

	@Schema(description = "조회수")
	private int hitCnt;

	@Schema(description = "작성자")
	private String creatorId;

	@Schema(description = "작성시간")
	private String createdDatetime;

	@Schema(description = "수정자")
	private String updaterId;

	@Schema(description = "수정시간")
	private String updatedDatetime;

	@Schema(description = "첨부파일 목록")
	private List<BoardFileDto> fileList;
}
