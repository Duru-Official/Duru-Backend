# Duru-Backend

**둘이 함께, 하루를 두루.**

Duru는 둘의 지출, 일정, 일간·주간·월간 목표를 함께 관리하는 웹앱입니다.
개인 개발·운영 프로젝트로, 실제 사용을 통해 개선한 과정과 기술적 판단을 기록합니다.

## 프로젝트 문서

| 문서 | 내용 |
| --- | --- |
| [개발 가이드](CONTRIBUTING.md) | 이슈·브랜치·커밋·PR·릴리스 |
| [코드 기준](CONVENTIONS.md) | 구조·데이터·품질·보안 |
| [AI 지침](AGENTS.md) | 작업 절차·검증·변경 범위 |
| [저장소 운영 설정](docs/REPOSITORY_SETUP.md) | Ruleset·CI 적용과 초기 업로드 |

## 기술과 개발 환경

| 구분 | 구성 |
| --- | --- |
| 애플리케이션 | Java · Spring Boot |
| 실행 환경 | JDK 21, Gradle Wrapper |
| 코드 검증 | JUnit·Spring Boot 테스트, 실행 JAR 빌드 |

정확한 라이브러리 버전은 `build.gradle`·Gradle Wrapper를 기준으로 합니다.

## 로컬 실행

저장소 루트에서 실행합니다.

```bash
./gradlew bootRun
```

접속 주소: http://127.0.0.1:8080. 종료는 실행한 터미널에서 Control + C입니다.
macOS에서는 `./scripts/dev.sh`로도 실행할 수 있습니다.

`GET /api/health`의 `status`가 `UP`이면 정상 실행 상태입니다.
Windows는 `gradlew.bat`을 사용합니다. Gradle은 별도로 설치하지 않습니다.
IntelliJ에서 저장소를 Gradle 프로젝트로 열고 Project SDK·Gradle JVM에 Java 21을 지정합니다.

## 검증

```bash
./gradlew test bootJar
```

CI 정의는 [`.github/workflows/ci.yml`](.github/workflows/ci.yml)에 있으며, dev·main push와 PR에서 `Backend CI`를 실행합니다.
문서 변경도 CI 실행 대상입니다. 미실행·미확인 검사는 통과로 기록하지 않습니다.

### 도구 적용 범위

Java 서식 기준은 CONVENTIONS에 정의합니다. Checkstyle·자동 formatter는 아직 빌드에 연결하지 않았습니다.
CI·필수 검사 설정의 실제 적용 상태는 [저장소 운영 설정](docs/REPOSITORY_SETUP.md)에 기록합니다.

## 개발 흐름

```text
작업 브랜치 ── PR / Squash ──▶ dev ── 릴리스 PR / Merge commit ──▶ main
                                ◀──── 동기화 PR / Merge commit ────┘
```

기본 작업 기준은 dev이며 main은 릴리스 기준입니다. 서버 수와 독립적으로 운영합니다.
상세 병합·완료 기준은 CONTRIBUTING을 따릅니다.

## 구현 범위

애플리케이션 실행과 `GET /api/health`를 제공하는 개발 기반 단계입니다.
지출·캘린더·목표·인증·DB와 실제 배포는 개발 범위에 포함되며 아직 구현하지 않았습니다.
세부 진행 상황은 Issue·Milestone에서 관리합니다.

## 관련 저장소

- [Duru-Frontend](https://github.com/Duru-Official/Duru-Frontend)
- [Duru Organization](https://github.com/Duru-Official)

문서·예시·화면에는 가짜 데이터를 사용하며, 실제 지출·일정·인증정보는 공개 저장소에 올리지 않습니다.
