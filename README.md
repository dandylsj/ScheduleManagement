# 스케줄 관리 

## 프로젝트 소개

- `3 Layer Architecture` 에 따라 각 Layer의 목적에 맞게 개발해야 합니다.
- CRUD 필수 기능은 모두 데이터베이스 연결 및 `JPA` 를 사용해서 개발해야 합니다.

Spring의 기본적인 CRUD 를 구현하여 클라이언트가 요청(Request)하는 값을 (Create,Read,Update,Delete)을 보냈을때 
백엔드 서버에서 어떤 식으로 DB에 값을 요청하고 다시 응답(Response)을 어떻게 하는지 알아보는 프로젝트입니다.
자바로 만들었을 경우 데이터베이스에 요청하고 응답하는것을 개발자가 일일이 만들어 주어야 하지만 
JPA 를 사용하면 Repository에서 기본적인 기능들을 알아서 수행해주는 메소드가 있어 간편하게 만들 수 있다는 것을 알았습니다.


<br>

## 기술 스택

**Language**: Java Corretto 17 
**IDE**: IntelliJ IDEA 

<br>


## 개발 기간

2025.11.03 ~ 2025.11.06


<br>

## 와이어 프레임

<img width="1452" height="1361" alt="image" src="https://github.com/user-attachments/assets/7259e741-3b09-43e5-9710-7912aa3eee58" />




## 실행 화면

![키오스크 작동 화면](https://github.com/user-attachments/assets/bda6d07b-8226-4f6b-9b72-20ff2eed2e86)


##  주요 기능

실제 매장의 키오스크 작동방식에 따라 상위메뉴(ex 음료류) 를 누르면 하위메뉴(ex 아메리카노,에이드,티) 가 나오도록 만들었고
하위메뉴의 메뉴 번호를 누르면 선택한 메뉴가 어떤것인지 나오도록 만들었습니다.
<br>

## API 명세서

[API 명세서 보러가기]https://www.notion.so/2a24d058410381cc94b7f03cd03dd60d?v=2a24d058410381fe9420000c2f60ac76

<img width="1133" height="784" alt="스크린샷 2025-11-06 140242" src="https://github.com/user-attachments/assets/89faff92-0903-4e0b-82ef-f64ec16f44bb" />

<img width="1297" height="1870" alt="image" src="https://github.com/user-attachments/assets/bdddf4b3-f2ba-4fb0-8e9a-4d393551968d" />

사이드 보기로들어가면 자세히 볼 수 있습니다.

[키오스크 프로젝트 트러블슈팅 보러가기](https://velog.io/write?id=1c049713-a0cf-4c6e-9050-9c297f8725ef))
