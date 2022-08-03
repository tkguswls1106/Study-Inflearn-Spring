# [Spring 공부 부분]

**스프링 인프런 강의 영상 사이트: https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EC%9E%85%EB%AC%B8-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8/dashboard**
```
기본 서버 실행시 주소: http://localhost:8080/

서버 킬때는 src_main_java_hellospring 안의 HelloSpringApplication 실행.
서버 새로고침할때는 위에 실행한거 껐다가 다시 실행시키면됨.

인텔리제이에서는 command + shift + enter 키를 누르면 적던 코드가 알아서 자동완성 된다.
getter setter 같은거 사용할때에는 control + enter 키를 누르면 된다.

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
참고로 p태그안의 안녕하세요. 손님 은 절대경로로 사이트 링크부분에 입력해서 서버없이 html파일 출력 확인할때 뜨게된다.
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

------------ '정적 컨텐츠' 강의 부분 필기 ------------

static 폴더 안에 예를들어 hello-static.html 이란 파일을 만들고
src_main_java_hellospring 안의 HelloSpringApplication 을 실행하여 서버를 켜면
hello-static 이라는 맵핑 관련 컨트롤러가 존재하지않으므로, static 폴더를 보게되고,
localhost:8080/hello-static.html 링크로 해당 파일을 출력시킬수 있다.

------------------------------------------------

--------- 'MVC와 템플릿 엔진' 강의 부분 필기 ---------

MVC: Model, View, Controller

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {  // 쿼리파라미터 /hello-mvc?name=shj 이런식으로 적어주면 된다. 참고로 쿼리파라미터는 get방식이다.
        model.addAttribute("name", name);
        return "hello-template";
    }
//  이러한 방식은
//  템플릿 엔진을 모델,뷰,컨트롤러인 MVC로 쪼개서
//  뷰파일을 가지고 렌더링을 하여
//  템플릿 엔진 코드로 템플릿 뷰 파일의 코드를 변경하여
//  화면에 출력시켜주는 방식인 '템플릿 엔진' 방식이다.

------------------------------------------------

--------------- 'API' 강의 부분 필기 ---------------

    @GetMapping("hello-string")
    @ResponseBody  // @ResponseBody 를 사용하면 뷰 리졸버(viewResolver)를 사용하지 않아서 뷰 파일과 관련없어진다.
                   // 대신에 HTTP의 BODY에 문자 내용을 직접 반환하여 그 문자만 출력된다.
    public String helloString(@RequestParam("name") String name) {
        return "<strong>hello " + name + "</strong>";  // 예를들어 /hello-string?name=hihihi 이면, 화면상에 hello hihihi 만 출력된다.
        // return의 문자열 부분에 html 코드를 작성할 순 있긴하지만, 이는 매우 비효율적이다.
    }
// 이러한 방식은 '템플릿 엔진' 방식처럼 뷰파일을 사용하여 변경하거나 하는 방식이 아닌,
// 데이터 그대로 화면에 내려주는 방식이다. 이를 'API' 방식이라고 한다.

    @GetMapping("hello-api")
    @ResponseBody  // 이거 사용해서 뷰 리졸버를 사용하지않게되는데, 반환값이 문자가 아닌 객체이므로, JSON 방식으로 변환되어 출력시킴.
    public Hello helloApi(@RequestParam("name") String name) {  // 'Hello클래스로 만든 객체 자료형'을 반환하는 메소드 안에
        Hello hello = new Hello();  // 클래스Hello 새로생성할객체hello = new 클래스생성자Hello()
        hello.setName(name);
        return hello;  // 방금 Hello클래스로 만든 hello객체를 반환함.
    }
    static class Hello {  // static은 정적이란 뜻으로, 선언하게 되는 경우 자바가 컴파일 되는 시점에 정의가 된다. 그래서 위의
        private String name;
        
        public String getName() {  // private로 지정한 name 필드에 접근하기위해 getter setter 이용함.
            return name;  // 꺼낼때
        }
        public void setName(String name) {  // private로 지정한 name 필드에 접근하기위해 getter setter 이용함.
            this.name = name;  // 넣을때
        }
    }
// 이거 실행하면 /hello-api?name=hihihi 링크의 화면에 {"name":"hihihi"} 이라고 뜬다.
// 이는 객체가 반환되어 전달되며, 키-값 쌍으로 이루어진 데이터 오브젝트를 전달하는 JSON 방식으로 변환되어 출력된 것이다.
// 이러한 방식처럼 데이터를 직접 넘겨주는 방식이 'API' 방식이다. 위는 응용하여 자주 사용되는 'API 방식이자 JSON 방식'의 예시이다.

------------------------------------------------

```
