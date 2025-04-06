# schedule-revamp




| 기능 | Method | URL | Request 예시 | Response 예시 | 상태 코드 | |------------|--------|---------------------------|------------------------------------------------------------|-------------------------------------------------------------|-------------| | 회원가입 | POST | /api/schedules/signup | { "username": "정현환", "password": "1234", "email": "a@b.com" } | { "id": 1, "username": "정현환", "email": "a@b.com" } | 201 Created | | 로그인 | POST | /api/schedules/login | { "email": "a@b.com", "password": "1234" } | "로그인 되었습니다." | 200 OK | | 유저 조회 | GET | /api/schedules/{id} | 없음 | { "username": "test", "email": "test@example.com" } | 200 OK | | 유저 수정 | PATCH | /api/schedules/{id} | { "password": "1234", "newPassword": "5678" } | 없음 또는 수정 성공 메시지 | 200 OK | | 유저 삭제 | DELETE | /api/schedules/{id} | { "password": "1234" } | 없음 | 204 No Content |
