package project.board.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter // 모든 필드는 접근이 가능 해야 한다
@ToString // 쉽게 출력이 가능, 관찰 할 수 있게
@Table(indexes = {  // draw.io의 문서를 토대로 작성
        @Index(columnList = "title"),
        @Index(columnList = "hashtag"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
@Entity
public class Article extends AuditingFields {

    @Id // 프라이머리 키 적용
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동으로 오토 인크리먼트 적용
    private Long id;

    // @Setter를 해줘야 도메인에서 수정이 가능
    @Setter @Column(nullable = false) private String title; // 제목
    @Setter @Column(nullable = false,length = 10000) private String content; // 본문

    @Setter private String hashtag; // 해시태그

    @ToString.Exclude
    @OrderBy("id")
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL) // mappedBy Article 테이블로부터 온 것이다
    private final Set<ArticleComment> articleComments = new LinkedHashSet<>();


    protected Article() {}
    private Article(String title,String content, String hashtag){ //생성자 메서드
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
    }

    public static Article of(String title,String content,String hashtag) {
        return new Article(title,content,hashtag); //생성자 사용 가능
    }

    /*동일성 동등성 검사를 위함*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article article)) return false;
        return id != null && id.equals(article.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
