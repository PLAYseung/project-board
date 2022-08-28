package project.board.controller;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*
   테스트가 무겁고 모킹을 할 때 오류가 난다
   dataRest의 기능은 원래 잘 작동 해야 한다
   @Disabled 처리

   Spring Data REST 테스트 제외 처리
   이 프로젝트의 비지니스 로직으로 구현한 내용이 아니라
   Data rest 기능이고
   통합테스트라 무거우면 db에도 영향을 준다
   공부 목적으로는 의미가 있기 떼문에 삭제하지 않고
   제외 처리해서 전체 테스트 중에 실행 되지 않게끔 처리
 */
@Disabled("Spring Data REST 통합테스트는 불필요하므로 제외시킴")
@DisplayName("Data Rest - API Test")
@Transactional // 테스트에서 기본동작 하는 트렌잭션널(Transactional)의 기본 동작은 롤백
@AutoConfigureMockMvc
@SpringBootTest
public class DataRestTest {

    private final MockMvc mvc;

    public DataRestTest(@Autowired MockMvc mvc) {

        this.mvc = mvc;
    }


    @DisplayName("[api] 게시글 리스트 조회")
    @Test
    void givenNothing_whenRequestingArticles_thenReturnsArticlesJsonResponse() throws Exception{
        // Given

        // When & Then
        mvc.perform(MockMvcRequestBuilders.get("/api/articles"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName("[api] 게시글 단건 조회")
    @Test
    void givenNothing_whenRequestingArticles_thenReturnsArticleJsonResponse() throws Exception{
        // Given

        // When & Then
        mvc.perform(MockMvcRequestBuilders.get("/api/articles/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName("[api] 게시글 -> 댓글 리스트 조회")
    @Test
    void givenNothing_whenRequestingArticlesComments_thenReturnsArticleCommentsJsonResponse() throws Exception{
        // Given

        // When & Then
        mvc.perform(MockMvcRequestBuilders.get("/api/articles/1/articleComments"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName("댓글 단건 조회")
    @Test
    void givenNothing_whenRequestingArticlesComment_thenReturnsArticleCommentJsonResponse() throws Exception{
        // Given

        // When & Then
        mvc.perform(MockMvcRequestBuilders.get("/api/articleComments/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }
}

