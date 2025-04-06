# schedule-revamp



| 기능       | Method | URL                   | Request 예시                                               | Response 예시                                              | 상태 코드       |
|------------|--------|------------------------|------------------------------------------------------------|-------------------------------------------------------------|----------------|
| 일정 생성  | POST   | /api/schedules         | { "schedule_content": "내용", "schedule_title": "제목" }   | { "id": 1, "name": "홍길동", "scheduleTitle": "제목", "scheduleContent": "내용" } | 201 Created    |
| 일정 조회  | GET    | /api/schedules/{id}    | 없음 (PathVariable 사용)                                   | { "id": 1, "name": "홍길동", "scheduleTitle": "제목", "scheduleContent": "내용" } | 200 OK         |
| 일정 수정  | PATCH  | /api/schedules/{id}    | { "name": "홍길동", "schedule_content": "수정내용", "schedule_title": "수정제목" } | 없음 또는 수정된 객체 반환                                 | 200 OK         |
| 일정 삭제  | DELETE | /api/schedules/{id}    | 없음 (PathVariable 사용)                                   | 없음                                                       | 204 No Content |

