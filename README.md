# 📅 Spring 기반 JPA 일정 관리 앱 개발

## ✅ 프로젝트 개요

본 프로젝트는 Spring Boot와 JPA를 기반으로 한 **일정 관리 애플리케이션**입니다.  
**3계층 아키텍처**, **세션 기반 인증**, **JPA Auditing**, **비밀번호 암호화** 및  
**커스텀 필터를 통한 로그인 인증 처리** 등 핵심 웹 기술들을 구현하였습니다.

---

## 🔧 기술 스택

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL
- Jakarta Bean Validation
- HttpSession 기반 인증
- Bcrypt 비밀번호 암호화 (`at.favre.lib:bcrypt`)

---

### 📅 Schedule API

| 기능       | Method | URL                   | Request 예시                                               | Response 예시                                                                                     | 상태 코드       |
|------------|--------|------------------------|------------------------------------------------------------|----------------------------------------------------------------------------------------------------|----------------|
| 일정 생성  | POST   | /api/schedules         | { "schedule_content": "내용", "schedule_title": "제목" }   | { "id": 1, "name": "홍길동", "scheduleTitle": "제목", "scheduleContent": "내용" }                  | 201 Created    |
| 일정 조회  | GET    | /api/schedules/{id}    | 없음                                    | { "id": 1, "name": "홍길동", "scheduleTitle": "제목", "scheduleContent": "내용" }                  | 200 OK         |
| 일정 수정  | PATCH  | /api/schedules/{id}    | { "name": "홍길동", "schedule_content": "수정내용", "schedule_title": "수정제목" } | 없음 또는 수정된 객체 반환                                                                       | 200 OK         |
| 일정 삭제  | DELETE | /api/schedules/{id}    | 없음                                   | 없음                                                                                               | 204 No Content |

### 👤 User API

| 기능       | Method | URL                        | Request 예시                                                                                         | Response 예시                                                                                         | 상태 코드       |
|------------|--------|-----------------------------|--------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------|----------------|
| 회원가입   | POST   | /api/schedules/signup       | { "username": "홍길동", "password": "비밀번호", "email": "email@example.com" }                         | { "id": 1, "username": "홍길동", "email": "email@example.com" }                                       | 201 Created    |
| 로그인     | POST   | /api/schedules/login        | { "password": "비밀번호", "email": "email@example.com" }                                               | "로그인 되었습니다."                                                                                   | 200 OK         |
| 유저 조회  | GET    | /api/schedules/{id}         | 없음                                                                             | { "username": "홍길동", "email": "eamil@example.com" }                                                  | 200 OK         |
| 유저 수정  | PATCH  | /api/schedules/{id}         | { "password": "기존비밀번호", "newPassword": "새비밀번호" }                                           | 수정 성공 메시지                                                                            | 200 OK         |
| 유저 삭제  | DELETE | /api/schedules/{id}         | { "password": "비밀번호" }                                                                            | 없음                                                                                                   | 204 No Content |
---
### 📦 ERD 다이어그램

![화면 캡처 2025-04-06 233120](https://github.com/user-attachments/assets/bf7f027d-9492-4f64-8cf7-f01a1ad1eb78)

---
## ✨ 구현된 기능 요약

| 기능 | 구현 여부 | 설명 |
|------|-----------|------|
| 일정 CRUD | ✅ | 생성/조회/수정/삭제 (작성자 연동 포함) |
| 유저 CRUD | ✅ | 유저 생성/조회/수정/삭제 |
| 유저 회원가입 | ✅ | 이메일, 비밀번호, 유저명으로 회원가입 |
| 우저 로그인 | ✅ | 이메일 + 비밀번호 기반, 세션 저장 방식 |
| 인증 처리 | ✅ | 커스텀 Filter + 세션 기반 처리 |
| 비밀번호 암호화 | ✅ | BCrypt + PasswordEncoder |
예외 처리 | ✅ | Bean Validation + Optional.orElseThrow() + 커스텀 예외 응답 포맷 |

---
