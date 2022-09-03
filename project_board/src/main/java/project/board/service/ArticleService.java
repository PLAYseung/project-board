package project.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.board.repository.ArticleRepository;

@RequiredArgsConstructor
@Service    // service bean으로 등록 되어서 사용할 수 있음
public class ArticleService {

    private  final ArticleRepository articleRepository;


}
