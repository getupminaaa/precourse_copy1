# 기능 목록(순서 무관)

- 난수 생성 기능
- 힌트 결정(= 난수와 플레이어 입력값 비교) 기능
- 플레이어 입력 받는 기능 (“숫자를 입력해주세요: “)
- 입력받은 값의 유효성 검사 기능 (플레이어의 입력에 문제가 있는지)
- `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료하는 기능
- 힌트와 게임 종료 조건 비교 기능 (힌트가 3스트라이크와 같은지 아닌지)
- 게임 재시작 여부 결정 기능(= 사용자에게 1 또는 2를 입력받아 재시작 여부를 결정하는 기능)
- 힌트를 출력하는 기능
- 게임 종료 멘트 출력 기능 (”3개의 숫자를 모두 맞히셨습니다! 게임 종료”)
- 게임 시작 멘트 출력 기능 (”숫자 야구 게임을 시작합니다.”)

# 🌱 정리


### 플레이어

- 1~9 사이의 숫자로 구성된 서로 다른 세 자리 수로 구성된 수를 시스템에 입력
- 게임 종료 후, 재시작 여부를 시스템에 입력

### 상대방(컴퓨터)

- 난수 생성 후 저장
- 시스템으로 받은 값으로 스트라이크, 볼, 낫싱 힌트 결정
    - 저장된 난수와 비교
    - 힌트 결정
- 힌트를 시스템에 전달

### 시스템

- 게임 시작 문구 출력

  `숫자 야구 게임을 시작합니다.`

- 플레이어의 입력을 받음

  `숫자를 입력해주세요 : ㅇㅇㅇ`

- 플레이어의 입력값 유효성 검사
    - 플레이어가 문제없는 값을 입력한 경우, 값을 상대방(컴퓨터)에게 전달

      (문제가 없는 값 ⇒ 1~9 사이의 숫자로 구성된 서로 다른 세 자리 수)

    - 플레이어가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료
- 전달받은 힌트 확인

  if) 힌트 == 3스트라이크

    - 게임종료 멘트 출력

      `3개의 숫자를 모두 맞히셨습니다! 게임 종료`

    - 종료할 지, 재시작할 지 사용자에게 입력 받음

      `게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.`

    else) 힌트 출력 기능 실행

- 힌트 출력

  ex) `1볼 2스트라이크`


# 프로그램 흐름


**시스템)** 게임 시작 출력

- `숫자 야구 게임을 시작합니다.`

**컴퓨터) 난수 생성 후 저장**

**시스템) 플레이어에게 입력을 받음**

- `숫자를 입력해주세요 :`

**플레이어)** 3자리수 입력

**시스템)** 입력 값이 유효한 지 검사

- 유효하지 않을 경우 ⇒  `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료
- 유효한 경우 ⇒ 컴퓨터에게 전달

**컴퓨터)** 저장된 난수와 비교 후 힌트 결정 (힌트 - 낫싱, 볼, 스트라이크)

**컴퓨터)** 시스템에게 힌트 전달

**시스템)** 전달받은 힌트 확인

- if) 힌트 == 3스트라이크

  - **시스템)** 종료 프로세스 시작

    - 종료 프로세스 [
        - **시스템)** 게임종료 멘트 출력
            - `게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.`
        - **플레이어)** 1 또는 2 입력

          if) 1 입력

          - **[ 컴퓨터) 난수 생성 후 저장 ] 단계**로 돌아감

          if) 2 입력

          - 프로그램 종료

        ]

- else)
  - **시스템)**  전달받은 힌트 출력

  - **시스템)**  **[ 시스템) 플레이어에게 입력을 받음 ] 단계**로 돌아감
