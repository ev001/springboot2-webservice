package com.dennis.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter // 6
@NoArgsConstructor // 5
@Entity // 1
public class Posts {
    @Id // 2
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 3
    private Long id;

    @Column(length = 500, nullable = false) // 4
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 7
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}

/*
    @Entity는 JPA의 어노테이션이며,
    @Getter와 @NoArgsConstructor는 롬복의 어노테이션
    롬복은 코드를 단순화 시켜주지만, 필수 어노테이션은 아니다.
    (그래서 주요 어노테이션인 Entity를 클래스에 가까이 두고, 롬복 어노테이션을 그 위로 둔다.
     장점 : 코틀린 등의 새 언어 전환으로 롬복이 더이상 필요 없을 경우 쉽게 삭제 가능)

    Post 클래스는 실제 DB의 테이블과 매칭될 클래스이며 Entity 클래스라고도 한다.
    JPA를 사용하면 DB 데이터에 작업할 경우 실제 쿼리를 날리기 보단, 이 Entity 클래스의 수정을 통해 작업한다.

1. @Entity
    테이블과 링크될 클래스임을 나타낸다.
    기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭한다.
    ex) SalesManger.java -> sales_manager table

2. @Id
    해당 테이블의 PK 필드를 나타낸다.

3. @GeneratedValue
    PK의 생성 규칙을 나타낸다.
    스프링 부트 2.0에서는 GenerationType.IDENTITY 옵션을 추가해야하만 auto_increment가 된다.

4. @Column
    테이블의 칼럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 된다.
    사용하는 이유 : 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용한다.
    문자열의 경우 VARCHER(255)가 기본값인데, 사이즈를 500으로 늘리고 싶거나 타입을 TEXT로 변경하고 싶거나 등의 경우에 사용ㄴ.


///////////// 5 ~ 7 : 롬복 어노테이션  ////////////////


5. @NoArgsConstructor
    기본 생성자 자동 추가
    public Posts(){}와 같은 효과

6. @Getter
    클래스 내 모든 필드의 Getter 메소드를 자동생성

7. @Builder
    해당 클래스의 빌더 패턴 클래스를 생성
    생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함



    서비스 초기 구축 단계에서는 테이블 설계(여기서는 Entity 설계)가 빈번하게 변경되는데,
    이때 롬복의 어노테이션들은 코드 변경량을 최소화화시켜 기 때문에 적극적으로 사용한다.

    이 Posts 클래스는 "Setter 메소드"가 없다는 특이점이 있다.
    자바빈 규약을 생각하면서 getter/setter를 무작정 생성하는 경우가 있다. 이럴경우 해당 클래스의 인스턴스 값들이
    언제 어디서 변해야 하는지 코드상으로 명확하게 구분할 수가 없어, 차후 기능 변경 시 복잡해진다.

    그래서 Entity 클래스에서는 절!대! 'Setter 메소드를 만들지 않는다'!!!
    대신 해당 필드의 값 변경이 필요하면 명확히 그 목적과 의도를 나타낼 수 있는 메소드를 추가해야만 한다.


 */