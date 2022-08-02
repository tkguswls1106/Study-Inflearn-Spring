# [Spring 공부 부분]

**스프링 인프런 강의 영상 사이트: https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EC%9E%85%EB%AC%B8-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8/dashboard**
```
기본 서버 실행시 주소: http://localhost:8080/

서버 킬때는 src_main_java_hellospring 안의 HelloSpringApplication 실행.
서버 새로고침할때는 위에 실행한거 껐다가 다시 실행시키면됨.

----------- 'View 환경설정' 강의 부분 필기 -----------

static 폴더 안에 index.html 파일을 만들어두면 웰컴 페이지라고 해서
스프링이 실행되어 기본적인 localhost:8080 사이트로 접속시, 가장 먼저 뜨는 페이지가 된다.
만약 존재하지 않는 파일이라면, 그다음 순서는 templates 폴더의 index.html 파일을 찾게된다. 아마도 맞을것이다.

<라우팅 과정>
사용자가 localhost:8080/hello 링크로 접속
->
패스파라미터가 '/hello'이면 Mapping은 "hello"이고,
그저 링크 이동이기에 method='get'방식이므로,
src_main_java_hellospring_controller 안의 HelloController 확인하여
@GetMapping("hello") 부분을 보게되고
그 밑의 메소드인 public String hello(Model model) 실행.
->
data:hello!! 값을 렌더링하게 될것이며
return "hello"; 코드때문에
return으로 (ViewName)+.html 이므로 hello.html 파일인 View 파일을 가리키게되고,
위의 data:hello!! 값을 templates_hello.html 파일로 렌더링함.
->
templates_hello.html 파일의
타임리프 템플릿 엔진 처리로 인하여
그러면 <p th:text="'안녕하세요. ' + ${data}" >안녕하세요. 손님</p> 코드 부분에서
${data} 부분이 'hello!!'로 치환되고
그러면 화면에 출력될때 '안녕하세요. hello!!' 이렇게 출력되게 된다.
즉, <p >안녕하세요. hello!!</p> 으로 코드가 치환된다는 것이다.
참고로 물론 작은따옴표인 ''는 출력안된다.

------------------------------------------------

---------- '빌드하고 실행하기' 강의 부분 필기 ----------

가장 상위 폴더인 hello-spring 디렉토리에서 터미널로 빌드코드 입력하면된다.
단, 빌드는 서버를 여는것과 동일하므로 같은 8080포트로 서버가 또 열리지않도록 실행되고있는 컨트롤러를 꺼주고 빌드해야만 한다.

./gradlew build
cd build/libs
java -jar hello-spring-0.0.1-SNAPSHOT.jar

여기까지 터미널에 치면 localhost:8080/ 서버 접속이 가능해진다.

아마 나중에 배포할때도 서버컴에 jar 파일 복사해두고 실행시키면 되는듯하다.

------------------------------------------------

```
