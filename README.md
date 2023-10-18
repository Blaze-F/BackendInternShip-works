## 채용공고 등록 서비스

## 사용 기술
- JAVA 17
- SpringBoot
    - modelmapper
    - Gradle
    - SpringDataJPA
- Mysql



Endpoint:
### 생성
---
POST /article/create
Request:
```json
{
  "companyId": 123,
  "position": "Backend Junior Developer",
  "reward": 1000000,
  "description": "We are hiring a Backend Junior Developer at WantedLab. Qualifications include..."
}
```
Response:
```json

{
  "id": 1,
  "position": "Backend Junior Developer",
  "reward": 1000000,
  "description": "내용"
}
```
### 업데이트

PUT /article
Request:
```json

{,{
  "position": "Backend Junior Developer",
  "reward": 1500000,
  "description": "내용"}
}
```
Response:
```json
{
  "id": 1,
  "position": "Backend Junior Developer",
  "reward": 1500000,
  "description": "내용"
}
```
### 삭제

Endpoint:
http
DELETE /article/{id}
Response:

```json
Copy code
{
  "message": "1 deleted succeed"
}
```
### 리스트
Endpoint:
GET /company/list
Response:
```json
[
  {
    "id": 1,
    "companyName": "WantedLab",
    "country": "Korea",
    "location": "Seoul",
    "position": "Backend Junior Developer",
    "reward": 1500000,
  },
  {
    "id": 2,
    "companyName": "Naver",
    "country": "Korea",
    "location": "Pangyo",
    "position": "Django Backend Developer",
    "reward": 1000000,
    "technologies": "Django"
  }
  ...
]
```

### 검색

GET /company/find?name=WantedLab
Response:
```json
[
  {
    "id": 1,
    "companyName": "WantedLab",
    "country": "Korea",
    "location": "Seoul",
    "position": "Backend Junior Developer",
    "reward": 1500000,
  },
  {
    "id": 2,
    "companyName": "WantedKorea",
    "country": "Korea",
    "location": "Busan",
    "position": "Frontend Developer",
    "reward": 500000,
  }
] ```
