# schedule-revamp


📌 API 명세표
📅 Schedule API
기능	Method	URL	Request 예시	Response 예시	상태 코드
일정 생성	POST	/api/schedules	json<br>{ "schedule_content": "내용", "schedule_title": "제목" }	json<br>{ "id": 1, "name": "홍길동", "scheduleTitle": "제목", "scheduleContent": "내용" }	201 Created
일정 조회	GET	/api/schedules/{id}	없음 (PathVariable 사용)	json<br>{ "id": 1, "name": "홍길동", "scheduleTitle": "제목", "scheduleContent": "내용" }	200 OK
일정 수정	PATCH	/api/schedules/{id}	json<br>{ "name": "홍길동", "schedule_content": "수정내용", "schedule_title": "수정제목" }	없음 또는 수정된 객체 반환	200 OK
일정 삭제	DELETE	/api/schedules/{id}	없음 (PathVariable 사용)	없음	200 OK
👤 User API
기능	Method	URL	Request 예시	Response 예시	상태 코드
회원가입	POST	/api/schedules/signup	json<br>{ "username": "정현환", "password": "비밀번호", "email": "email@example.com" }	json<br>{ "id": 43, "username": "정현환", "email": "email@example.com" }	201 Created
로그인	POST	/api/schedules/login	json<br>{ "password": "비밀번호", "email": "email@example.com" }	로그인 되었습니다.	200 OK
유저 조회	GET	/api/schedules/{id}	없음 (PathVariable 사용)	json<br>{ "username": "test3", "email": "gpdnjs3@gmail.com" }	200 OK
유저 수정	PATCH	/api/schedules/{id}	json<br>{ "password": "기존비밀번호", "newPassword": "새비밀번호" }	없음 또는 수정 성공 메시지	200 OK
유저 삭제	DELETE	/api/schedules/{id}	json<br>{ "password": "비밀번호" }	없음	200 OK
