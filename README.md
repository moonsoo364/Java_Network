# 자바 네트워크 프로그래밍 도서 예제 실습 코드

## ch3
###멀티스레드에서 경쟁조건을 해결 하기위한 방법을 코드로 알려줌
1. `DigestPollin` : 스레드에서 파일을 다 읽고 메인 함수에서 해시 값을 출력한다, CPU가 상태를 계속 확인해야 하므로 비효율적
2. `CallbackDigest` : 스레드에서 인스턴스를 생성한 클래스의 정적 메서드를 호출하여 순서를 보장한다.
3. `InstanceCallbackDigest` : `InstanceCallbackDigestUserInterface` 클래스의 인스턴스를 `InstanceCallbackDigest` 의 인스턴스를 생성할 때 필드로 전달한다.
`run()` 메서드에서 `callback`필드의 `receiveDigest` 메서드를 호출하여 해시 값을 출력한다. 
