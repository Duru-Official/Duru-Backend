# duru-backend

둘이 함께 쓰는 지출 기록·일정 공유·목표 체크 웹앱 duru의 백엔드입니다.
현재는 Spring Boot 기본 프로젝트와 서버 연결 확인 API를 준비한 단계입니다.
DB·로그인·지출 저장 등 서비스 기능은 아직 구현하지 않았습니다.

## 기술

Java 21 · Spring Boot 4.1.2 · Gradle Wrapper 9.8.2

## 실행

JDK 21을 설치하고 이 저장소의 루트에서 실행합니다. Gradle은 별도 설치하지 않습니다.

```bash
./gradlew bootRun
```

Windows에서는 `gradlew.bat bootRun`을 사용합니다.
macOS에서는 `./scripts/dev.sh`로 실행해도 됩니다.
서버는 `http://127.0.0.1:8080`에서 실행됩니다. 종료는 Control + C입니다.

```bash
curl http://127.0.0.1:8080/api/health
```

정상 응답은 `status`가 `UP`인 JSON입니다.
현재 서버는 로컬 접속만 허용합니다. 운영 배포 시 바인딩·네트워크·인증 설정을 따로 구성해야 합니다.

## IntelliJ에서 열기

Open으로 이 저장소 폴더를 선택하고 Gradle 프로젝트로 불러옵니다.
Project SDK와 Gradle JVM은 Java 21을 선택합니다.
현재 맥의 JDK 경로는 `/opt/homebrew/opt/openjdk@21/libexec/openjdk.jdk/Contents/Home`입니다.
`src/main/java/com/duru/DuruApplication.java`의 main으로도 실행할 수 있습니다.
이미 서버가 실행 중이면 종료한 뒤 실행해 포트 충돌을 피합니다.

## 검증

```bash
./gradlew test
./gradlew bootJar
```

현재 테스트는 애플리케이션 시작과 HTTP 상태 확인 API를 검증합니다.

## 개발 방법

작업 방식과 버전 관리는 [CONTRIBUTING.md](CONTRIBUTING.md)를 참고하세요.
인증 정보·DB 비밀번호·실제 사용자 데이터는 커밋하지 않습니다.

## 관련 프로젝트

프론트엔드 저장소 이름은 `duru-frontend`입니다. GitHub Organization 생성 후 실제 링크를 추가합니다.
개인 개발·운영 프로젝트로 진행합니다. 배포는 기능 구현 후 시작할 계획입니다.
Oracle 무료 VM을 사용할 경우 Oracle DB를 써야 하는 것은 아닙니다.
DB 종류와 ARM64 배포 구성은 배포 준비 단계에서 확정합니다.
