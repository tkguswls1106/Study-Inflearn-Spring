# [Spring 공부 부분]

**스프링 인프런 강의 영상 사이트: https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EC%9E%85%EB%AC%B8-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8/dashboard**
```
기본 서버 실행시 주소: http://localhost:8080/

서버 킬때는 src_main_java_hellospring 안의 HelloSpringApplication 실행.
서버 새로고침할때는 위에 실행한거 껐다가 다시 실행시키면됨.

- 인텔리제이에서는 command + shift + enter 키를 누르면 적던 코드가 알아서 자동완성 된다.
- getter setter 같은거 사용할때에는 control + enter 키를 누르면 된다.
- implements로 인터페이스 상속시에 메소드들 불러올때 option + enter 키를 누르면 된다.
- 듣기론 import는 control + space 또는 option + enter 키를 누르면 된다고 한다.
- 연결된 변수나 클래스명 같은걸 코드를 보고싶을때는, 해당 변수 위에 command + 마우스클릭 을 하면 된다.
- 같은이름의 변수명을 바꾸고싶을때는 키보드 커서를 해당 변수에 갖다놓고 shift + (fn) + F6 키를 누르고 이름을 변경하면 다같이 한번에 변경된다.
- 예를들어 Optional<Member> result = memberRepository.findByName(member.getName()); 의 우항인 memberRepository.findByName(member.getName()); 만 작성해두고, command + option + v 키를 누르면 좌항이 Optional<Member> result 가 자동완성되고 이름을 지을 수 있다.
- 따로 메소드를 빼서 만들어주고싶다면, 해당 작성한 메소드를 전부 드래그해놓고, control + t 키를 누르고 extract method 를 선택하면 된다. 아니면 그냥 드래그하고 command + option + m 키를 누르면 된다.
- 테스트 클래스를 단축키로 간단하게 생성하려면, 코드 안의 클래스 위에 키보드 커서 올려두고 command + shift + t 키를 누르면 된다.
- 이전에 실행한 Run을 그대로 실행하려면 control + r 키를 누르면 된다.
- 예를들어 의존관계 DI 형성할때처럼, 작성한 코드를 이용하여 관련 생성자(Constructor)를 만들고싶다면, control + enter 키를 누르면 된다.
- 가장 최근에 봤던 파일들 목록들을 최근순으로 보려면 command + e 키를 누르면 된다.
- return 문에 람다식 적용시키고 싶다면, 해당 부분에 키보드 커서 올려두고, option + enter 키를 누르면 된다.
- 객체선언하고 return할때 변수명 코드가 중복되어 하나로 중복제거하고싶다면, 해당 return 옆의 변수 부분에 키보드 커서 올려두고, command + option + n 키를 누르면 된다.
- sout 입력시, System.out.println() 코드가 자동완성 된다.

----------- 'View 환경설정' 강의 부분 필기 -----------

static 폴더 안에 index.html 파일을 만들어두면 웰컴 페이지라고 해서
스프링이 실행되어 기본적인 localhost:8080 사이트로 접속시, 가장 먼저 뜨는 페이지가 된다.
만약 존재하지 않는 파일이라면, 그다음 순서는 templates 폴더의 index.html 파일을 찾게된다. 아마도 맞을것이다.
단, 컨트롤러 안에 @GetMapping("/") 으로 기본 사이트를 설정하고 특정 html 파일로 return하여 렌더링하였을시에는,
컨트롤러가 정적static 파일보다 우선순위가 높아 index.html 웰컴 페이지 대신 컨트롤러에서 렌더링한 html 파일이 열려 출력되게 된다.

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

< main_hellospring_controller_HelloController >
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

< main_hellospring_controller_HelloController >
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
    static class Hello {  // static은 정적이란 뜻으로, 그중 static class의 경우에는 외부클래스 안에 내부 클래스를 만들때 사용할수있는 방법중 하나이다.
                          // 원래 내부 클래스인 Hello로 객체를 생성할때 외부 클래스인 HelloController로 먼저 new 객체를 생성하고 그걸로 접근을 해서 내부클래스로 new하여 객체를 생성해야하는데,
                          // 내부 클래스를 static으로 선언하였으므로, 외부클래스의 접근 필요없이 위의 helloApi 메소드 안에서 Hello hello = new Hello(); 로 바로 내부 클래스를 사용하여 객체를 생성할수있게된것이다.
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

----- '회원 도메인과 리포지토리 만들기' 강의 부분 필기 -----

DB 데이터 이동 과정(데이터 저장소가 선정되지않아 가볍게 구현체로 구현했을경우)(라우팅 과정?):
hellospring_domain_Member 의 회원 관련 정보 입력하여 회원객체 생성
->
hellospring_repository_MemberRepository 인터페이스의 save 메소드 등등의 기능으로 저장하던가 하여 데이터 관리 '기능 실행'. (물론, 현재는 인터페이스로 껍데기 틀만 구현해놓은거지만, 대강 이러한 식의 과정이라는걸로 기억해두자.)
->
예를들어 save로 저장 기능을 실행했다면,
hellospring_repository_MemoryMemberRepository 에 DB로 회원정보 객체가 저장됨.


< main_hellospring_domain_Member >
// 회원 도메인 객체
public class Member {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


< main_hellospring_repository_MemberRepository >
// 아직 데이터 저장소가 선정되지 않아서, 우선 인터페이스로 구현 클래스를 변경할 수 있도록 설계.
// 데이터 저장소는 RDB, NoSQL 등등 다양한 저장소를 고민중인 상황으로 가정.

// 회원 객체 저장할 리포지토리 '인터페이스' // 헷갈리지 말자. 리포지토리에 넣고 빼는 등등의 객체 관리 기능을 구현하기위해 설계한 인터페이스이지, 이게 리포지토리가 아니다.
public interface MemberRepository {  // 여러 기능들을 인터페이스에 담을것이다.
    Member save(Member member);  // 반환자료형: Member클래스로 만든 객체자료형, 메소드명: save, 메소드 매개변수: Member클래스와 그 객체
                                 // 회원정보를 객체형으로 저장하는 기능임. 회원을 저장하면 저장된 회원 객체가 반환됨. 참고로 메소드 형태임.
    Optional<Member> findById(Long id);  // save메소드로 저장한 회원정보들중 id로 회원 도메인 객체를 찾는 기능임. 참고로 메소드 형태임.
                                         // findById() 메소드는 매개변수에 해당하는 값을 토대로 DB에서 값을 조회해오는 역할을 수행하며, 반환형은 Optional<T> 인 메소드이다.
                                         // findByid() 메소드는 조회하려는 값이 존재할 수도, 존재하지 않을 수도 있어서 null에 의한 오류를 최소화 하기 위해 리턴으로 Optional<T>를 받는다.
                                         // Optional<T> 클래스를 사용하면 반환된 값이 null 값인경우 나타나는 NPE(NullPointerException)를 방지해줄 수 있다.
    Optional<Member> findByName(String name);  // save메소드로 저장한 회원정보들중 name으로 회원 도메인 객체를 찾는 기능임. 참고로 메소드 형태임.
    List<Member> findAll();  // 지금까지 save메소드로 저장된 모든 회원들의 리스트들을 반환해준다. 이게 기능이다.
}


< main_hellospring_repository_MemoryMemberRepository >
// 개발을 진행하기 위해서 초기 개발 단계에서는 구현체로 가벼운 메모리 기반의 데이터 저장소 사용

// 회원 리포지토리 메모리 구현체
public class MemoryMemberRepository implements MemberRepository {  // 인터페이스를 상속받음

    private static Map<Long, Member> store = new HashMap<>();  // save 메소드로 저장을 할때 저장할 메모리 구현  // 내가 보기엔 c언어 자료구조(데이터구조)의 연결리스트나 구조체와 약간 유사하다고 생각함.
    // Map 컬렉션은 키(key)와 값(value) 쌍(pair) 으로 구성된 Entry 객체를 저장하는 구조를 가진 인터페이스이다.
    // id는 Long 자료형이므로 키로 Long을, 값으로 객체를 주기로하면 Member 자료형이므로 값으로 Member을 줘서, Map<Long, Member> 이다.
    // HashMap은 Map 인터페이스를 구현한 대표적인 Map 컬렉션이다.
    // 대부분 HashMap 객체를 생성할 때에는 매개변수가 없는 생성자를 사용한다. 하지만 HashMap에 담을 데이터의 개수가 많은 경우에는 초기 크기를 지정해주는 것을 권장한다.
    // 동시성 문제가 고려되어 있지 않음. 실무에서는 위처럼 공유되는 변수를 사용할때는 ConcurrentHashMap 사용 고려. 여기선 예제니까 단순하게 고려하지않고 그냥 썼다고함.
    private static long sequence = 0L;  // sequence는 0,1,2 이렇게 키값을 생성해주는 역할이라고 보면 된다고 한다.
    // 동시성 문제가 고려되어 있지 않음. 실무에서는 AtomicLong 사용 고려. 여기선 예제니까 단순하게 고려하지않고 그냥 썼다고함.

    @Override
    public Member save(Member member) {
        member.setId(++sequence);  // member의 id로 ++sequence 를 저장하고,  // 메소드 매개변수 안에 Member member가 적혀있으므로, 따로 new로 생성해주지 않고 바로 사용하면 된다.
        store.put(member.getId(), member);  // 방금 저장한 id를 불러와서 그걸 키로 넣고, 값으로 member을 넣어서, 구조체처럼 store라는 이름의 메모리구현체에 키값쌍정보를 DB처럼 저장함.
        return member;  // 저장한 회원정보 반환.
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));  // store 메모리 구현체에서 정보를 꺼낼것이다.
                                                    // null이 반환될 가능성이 있으므로, Optional.ofNullable()로 감싸준다.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()  // 아마도 데이터가공시에 사용되는것이 stream인듯 하다. -> 인 화살표로 람다 작성.
                .filter(member -> member.getName().equals(name))  // member.getName()이 findByName(String name)의 매개변수로 넘어온 name과 같은지 확인하는 것이다. 같은경우에만 필터링이 실행된다.
                // (member -> member.getName().equals(name))에서, 첫 member은 데이터들을 모두 돌려보는 어떠한 메소드의 매개변수값이고,
                // 그 메소드의 return 반환결과값이 member.getName().equals(name) 인 것이다.
                // 즉, 하나하나 전부 member 데이터를 매개변수로 넣어 돌려 찾아가면서 findByName(String name)의 매개변수로 넘어온 name과 같은지 확인하는 것이다.
                .findAny();  // 필터링된 그중에서 가장 먼저 탐색된 요소를 반환함.
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
        // ArrayList는 List 컬렉션 인터페이스를 구현한 구현클래스이다.
    }
}

------------------------------------------------

---- '회원 리포지토리 테스트 케이스 작성' 강의 부분 필기 ----

여기 부분은 Spring 사용없이 순수한 자바 코드만으로 이루어져있으므로, @SpringBootTest를 적지않아도 된다.

< test_hellospring_repository_MemoryMemberRepositoryTest >
class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 테스트로 클래스 실행을 하면, 안의 메소드들이 무작위 순서로 실행된다.
    // 그러면서 겹치는 중복 객체라든가가 생기면 에러가 날 수 있기때문에, 각 메소드들 테스트 실행할때마다 다시 리포지토리를 초기화를 시켜주는 clear를 작성해주어야한다.
    @AfterEach  // AfterEach는 클래스 테스트 실행시, 각 메소드들이 실행이 끝날때마다 어떠한 동작을 실행할수있게 해주는 역할이다.
    public void afterEach() {
        repository.clearStore();  // 이는 MemoryMemberRepository 클래스 안에 clearStore 메소드를 적어주고 코드를 적은것이다.
    }

    @Test
    public void save() {  // 실행시켜서 녹색이 뜨면 정상실행 검사 성공. 참고로 이처럼 메소드별 검사도 가능하고, 클래스나 전체 등등 여러 범위로 검사 실행이 가능하다.
        Member member = new Member();  // 메소드 매개변수 안에 Member member가 적혀있지않으므로, 따로 new로 생성해주고 사용해야만 한다.
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();  // findById의 반환타입이 Optional이므로,
                                                                    // 반환된 Optional<Member> 에서 정보를 꺼낼땐 .get()를 써준다.
        assertThat(result).isEqualTo(member);
        // 참고로 위와 같은 코드로 Assertions.assertEquals(member, result); 가 있다.
        // 저장하고 난후 DB에서 불러온 result값이, 초반에 new로 저장한 member와, 값이 서로 같은지 잘 저장되고 잘 불러와졌는지 검증(확인)해보는 것임.
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);  // 반환타입이 Optional이 아니므로, .get()을 사용하지 않는다.
    }
}

------------------------------------------------

---------- '회원 서비스 개발' 강의 부분 필기 ----------

MemberRepository 인터페이스는 단순히 데이터를 저장소에 저장하고 넣었다뺐다하는, 기계적인 개발적 느낌이 강하다면,
MemberService 클래스같은 서비스 클래스는 join, findMembers 를 보다시피, 이름이 비즈니스적이다. 그래서 서비스 클래스에는 대개 비즈니스 관련 용어의 이름을 쓰며 비즈니스적 느낌이 강하다.

< main_hellospring_service_MemberService >
public class MemberService {

    // private final MemberRepository memberRepository = new MemoryMemberRepository(); // 좌항 우항 다른거니까 이름 비슷하다고 헷갈리지말자!
    private final MemberRepository memberRepository;  // private final로 선언한다면 직접적으로 값을 참조할 수는 없지만 생성자를 통해 매개변수로 넣어 값을 참조할 수 있다. 각각 생성자 메소드 매개변수 별로 호출할 때마다 새로이 값이 할당(인스턴스화)된다.
                                                      // 반면에 private static final을 선언한 변수를 사용하면 재할당하지 못하며, 메모리에 한 번 올라가면 같은 값을 클래스 내부의 전체 필드, 메소드에서 공유한다.
                                                      // 쉽게 설명하자면, 예를들어 조금씩 다르게 생긴 여러 생성자 메소드들을 생성하였을때, private final 은 각각 메소드별로 별개의 값으로 사용이 가능하지만, private static final 은 통합적인 같은값으로 관리된다는 것이다.
    public MemberService(MemberRepository memberRepository) {  // MemberRepository 매개변수를 가진 생성자 MemberService 메소드를 적어주어, MemberService를 MemberRepository에 연결하여 의존관계를 형성하였다. (DI)
                                                               // 이처럼 객체 의존관계를 외부에서 넣어주는 것을 DI (Dependency Injection), 의존성 주입이라 한다. 참고로 이건 DI 방법중 생성자 주입 방법이다.
        this.memberRepository = memberRepository;
    }  // 이 코드 대신 위의 주석처리된 코드로 쓰면 각 테스트마다 DB저장소가 개별의 것으로 점점 늘어나니까, 하나의 DB 저장소 사용으로 변경해주기위해 이 코드로 대신 작성해준다.
    // 이처럼 외부에서 저장소를 넣어주는것도 DI 이다.

    public Long join(Member member) {  // 회원가입 기능중, 저장기능
        // Optional<Member> result = memberRepository.findByName(member.getName());
        // result.ifPresent(m -> {  // isPresent() 메소드를 사용하여 Optional 객체에 저장된 값이 null인지 아닌지를 먼저 확인한다. 즉, 값이 있다면 해당 로직을 실행한다.
        // throw new IllegalStateException("이미 존재하는 회원입니다.");
        // });
        // 위의 코드 4줄을 줄여서 압축하면 밑의 메소드가 나온다.
        validateDuplicateMember(member);  // 같은 이름의 중복 회원 검증  // 참고로 동일패키지 동일클래스라서 private인 메소드도 사용 가능하다.

        memberRepository.save(member);
        return member.getId();  // 회원가입을 하면, id값을 반환해준다.
    }
    private void validateDuplicateMember(Member member) {  // 회원가입 기능중, 같은 이름의 중복 회원 검증 기능
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {  // isPresent() 메소드를 사용하여 Optional 객체에 저장된 값이 null인지 아닌지를 먼저 확인한다. 즉, 값이 있다면 해당 로직을 실행한다.
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers() {  // 전체 회원 조회 기능
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

------------------------------------------------

---------- '회원 서비스 테스트' 강의 부분 필기 ----------

여기 부분은 Spring 사용없이 순수한 자바 코드만으로 이루어져있으므로, @SpringBootTest를 적지않아도 된다.

참고로 @AfterEach나 @Transactional로 롤백을 할시에,
테스트 케이스에서 특정 메소드만 DB 롤백없이 그대로 반영하고싶을때에는
@Test 밑에 @Commit 을 적어주면 된다.

< test_hellospring_service_MemberServiceTest >
class MemberServiceTest {

    // MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    MemoryMemberRepository memberRepository;
    // MemberService memberService = new MemberService(memberRepository);
    MemberService memberService;

    @BeforeEach  // BeforeEach는 클래스 테스트 실행시, 각 테스트 메소드들이 실행되기 전에 미리 앞서서 어떠한 동작을 실행할수있게 해주는 역할이다.
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach  // AfterEach는 클래스 테스트 실행시, 각 메소드들이 실행이 끝날때마다 어떠한 동작을 실행할수있게 해주는 역할이다.
    public void afterEach() {
        memberRepository.clearStore();  // 이는 MemoryMemberRepository 클래스 안에 clearStore 메소드를 적어주고 코드를 적은것이다.
    }

    @Test
    void 회원가입() {  // 사실 테스트의 메소드명은 한글로 만들어도 된다.
        // given  // 1. 테스트에서 이러한 것이 주어졌는데
        Member member = new Member();
        member.setName("hello");

        // when  // 2. 이것을 실행했을때
        Long saveId = memberService.join(member);  // 테스트로 memberService의 join 메소드를 검증하겠다

        // then  // 3. 이러한 결과가 나와야한다
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());  // 여기의 Assertions는 assertj 꺼다. option + enter 로 스태틱 임포트 해주면 된다.
    }

    @Test
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class,  // assertThrows 메소드는 첫번째 인자로 발생할 예외 클래스의 Class 타입을 받고, 두번째 인자에서 예외 발생시 그 예외가 앞의 예외class와 동일한것인지 체크한다.
                () -> memberService.join(member2));// memberService.join(member2) 를 실행할때, 예외가 발생시 예외class타입을 반환함.

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        /*
        // 여기서 try ~ catch 사용 가능하긴함
        try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
        */
    }
}

------------------------------------------------

---- '컴포넌트 스캔과 자동 의존관계 설정' 강의 부분 필기 ----

스프링 컨테이너는 자바 객체의 생명 주기를 관리하며, 생성된 자바 객체들에게 추가적인 기능을 제공하는 역할을 한다.
여기서 말하는 자바 객체를 스프링에서는 빈(Bean)이라고 부르며, IoC와 DI의 원리가 이 스프링 컨테이너에 적용된다.
개발자는 new 연산자, 인터페이스 호출, 팩토리 호출 방식으로 객체를 생성하고 소멸시킬 수 있는데, 스프링 컨테이너가 이 역할을 대신해 준다.
즉, 제어 흐름을 외부에서 관리하며 작성한 코드의 처리과정을 위임받은 독립적인 존재인것이다.
또한, 중요한점은 객체들 간의 의존 관계를 스프링 컨테이너가 런타임 과정에서 알아서 만들어 주며, DI는 '생성자 주입', 'setter 주입', 그냥 필드에다가 @Autowired를 적는 '필드 주입'의 3가지 방법을 통해 적용한다.
참고로 main_hellospring_controller_HelloController 는 스프링이 제공하는 컨트롤러여서 스프링 빈으로 자동 등록된다.
@Controller 가 있으면 자동 등록되긴 하는데, 만약 안붙어있으면 따로 스프링 빈에 등록해주어야한다.
@Component 어노테이션이 있으면 스프링 빈으로 자동 등록되는데, 그걸 포함한 @Controller, @Service, @Repository 도 마찬가지로 자동등록 된다.
즉, 과정은 스프링 컨테이너에서 스프링 빈 등록되어있는것들중에서 의존관계 코드가 적혀있는것들끼리 알아서 연결해준다는 것이다.
이러한 방법은 스프링 빈을 등록하는 2가지 방법중에서, '컴포넌트 스캔과 자동 의존관계 설정' 방법에 해당하는 방법이다.
참고로 다른 나머지 하나의 방법은, '자바 코드로 직접 스프링 빈 등록하기'이다.
참고로 스프링은 스프링 컨테이너에 스프링 빈을 등록할 때, 기본으로 싱글톤으로 등록한다(각각 유일하게 하나씩만 등록해서 공유한다).

여기서는 의존관계가 'MemberController' -> 'MemberService' -> 'DI 어노테이션은 구현체인 MemoryMemberRepository에 적고, 관계상으로는 MemberRepository' 이렇게 연결되어있다.

@Controller 이나 @Service 이나 @Repository 로 스프링 빈에 등록하지 않았다면,
@Autowired 을 작성하여 연결해주려고해도 스프링 빈에서 꺼내올 빈이 없기때문에 연결되지 않는다.
그러니까 꼭 스프링 빈 등록코드와 연결 코드를 모두 작성해주도록 하자.

< main_hellospring_controller_MemberController >
@Controller
public class MemberController {

    // private final MemberService memberService = new MemberService();

    private final MemberService memberService;
    @Autowired  // 생성자에 @Autowired 가 있으면, 스프링이 연관된 객체를 스프링 컨테이너에서 찾아서 넣어준다. 이는 객체 의존관계를 외부에서 넣어주는 것인 DI이다.
    // 스프링 컨테이너가 뜰때 클래스 MemberController를 생성해주는데, 그때 MemberController 생성자 호출을 하게된다.
    // 그런데 그 생성자에 @Autowired 가 붙어있으면, 스프링이 스프링 컨테이너에 저장된 MemberService를 가져와서 의존성 연결을 MemberController에다가 해준다.
    // 하지만 이는 혹여나 MemberService를 스프링 컨테이너에 스프링 빈으로 등록(저장)해두지 않은상태에서 @Autowired로 의존관계 연결해주고 Run을 하게된다면, 에러가 발생하게 된다.
    // 그러므로 MemberService 클래스는 HelloController도 아니고, @Controller 등등의 어노테이션도 안붙어있기때문에, 따로 스프링 빈에 등록해주는 코드를 작성해주어야 정상적인 Run이 가능하다.
    public MemberController(MemberService memberService) {  // MemberService 매개변수를 가진 생성자 MemberController 메소드를 적어주어, MemberController를 MemberService에 연결하여 의존관계를 형성하였다. (DI 방법중 생성자 주입 방법)
        this.memberService = memberService;
    }
}

< main_hellospring_service_MemberService >
스프링 빈 등록을 위해
@Service 와 @Autowired 를 추가함.

@Service  // 스프링 컨테이너에 스프링 빈으로 등록하게 해줌.
public class MemberService {
    private final MemberRepository memberRepository;
    @Autowired  // 생성자에 @Autowired 가 있으면, 스프링이 연관된 객체를 스프링 컨테이너에서 찾아서 넣어준다. 이는 객체 의존관계를 외부에서 넣어주는 것인 DI이다.
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
}

< main_hellospring_repository_MemoryMemberRepository >
스프링 빈 등록을 위해
@Repository 를 추가함.

@Repository  // 스프링 컨테이너에 스프링 빈으로 등록하게 해줌.
public class MemoryMemberRepository implements MemberRepository {
}

------------------------------------------------

--- '자바 코드로 직접 스프링 빈 등록하기' 강의 부분 필기 ---

DI에는 필드 주입, setter 주입, 생성자 주입 이렇게 3가지 방법이 있다.
의존관계가 실행중에 동적으로 변하는 경우는 거의 없으므로 생성자 주입 방법을 권장한다.

실무에서는 주로 정형화된 컨트롤러, 서비스, 리포지토리 같은 코드는 컴포넌트 스캔 방법을 사용한다.
그리고 정형화 되지 않거나, 상황에 따라 구현 클래스를 변경해야 하면 config 설정을 통한 직접 스프링 빈 등록방법으로 사용한다.
후자의 예시로 우리가 지금까지 했던 데이터베이스 종류를 정하지않고 임시적으로 메모리레포지토리를 만들어 사용하였는데, 이걸 나중에 정한 데이터베이스로 다른 여러 코드를 손대지않고 간단하게 저장소 종류를 바꿔치기할것이다. 이게 바로 특정 상황에 따라 메모리레포지토리 구현 클래스를 변경하는 예시이므로, 이러한 예시의 상황에는 직접 스프링 빈 등록방법을 사용하는것이 config 코드만 조금 수정하면 되는일이라 더욱 간편하다.

'어노테이션으로 자동 의존관계 연결하고 스프링 빈을 등록하는 방법(=컴포넌트 스캔 방법)' 말고, '자바 코드로 직접 스프링 빈 등록하기' 방법을 사용하기 위하여
위 강의에서 추가해둔 코드인
회원 서비스(main_hellospring_service_MemberService)와
회원 리포지토리(main_hellospring_repository_MemoryMemberRepository)의
@Service, @Repository, @Autowired 어노테이션 코드를 제거하고 코드작성을 진행한다.

< main_hellospring_SpringConfig >
@Configuration
public class SpringConfig {

    @Bean  // 스프링 빈을 내가 직접 등록할거야 라는 의미이다.
    public MemberService memberService() {  // public 메소드반환자료형 메소드명()  // memberService()는 생성자 아니니까 헷갈리지말자!
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {  // public 메소드반환자료형 메소드명()  // memberRepository()는 생성자 아니니까 헷갈리지말자!
        return new MemoryMemberRepository();  // MemberRepository는 인터페이스이기때문에 new로 인스턴스 생성이 불가능하므로, 메모리구현체인 new MemoryMemberRepository() 를 반환한다.
    }
}

/*
직접 스프링 빈 등록 및 연결 과정(컨트롤러는 어쩔수없이 컴포넌트 스캔 방법 사용):

< main_hellospring_controller_MemberController 에서 >
@Controller 이라서 어쩔수없이 @Autowired로 컴포넌트 스캔 방법으로 MemberController을 MemberService에 연결함.

->

< main_hellospring_SpringConfig 에서 >
@Configuration을 봄
-> @Bean을 봄
-> MemberService와 MemberRepository를 모두 스프링 빈으로 등록

->

< main_hellospring_service_MemberService 에서 (main_hellospring_SpringConfig 에서 확인해도 되긴함) >
스프링 빈에 등록되어있는 MemberRepository를, 생성자메소드 MemberService()안의 매개변수로 넣어줌으로써, 어노테이션 자동 의존관계 연결(컴포넌트 스캔 방법)없이 직접 연결해주게 되는 것이다.

결국 의존관계가 'MemberController' -> 'MemberService' -> MemberRepository' 이렇게 연결되게 되었다.
*/

------------------------------------------------

--------- '회원 웹 기능 - 등록' 강의 부분 필기 ---------

< /members/new 링크 회원가입 절차 라우팅 과정 >
사용자가 /members/new 링크로 접속
->
main_hellospring_controller_MemberController 의 @GetMapping("/members/new") 부분의 코드 실행
->
return "members/createMemberForm"; 로 인하여 main_templates_members_createMemberForm.html 파일로 이동하여, 겉폼양식 출력
->
input name의 입력할데이터 입력하고 summit 버튼으로 post방식으로 데이터 전달함
->
main_hellospring_controller_MemberController 의 @PostMapping("/members/new") 부분의 코드 실행
->
가져온데이터가 main_hellospring_controller_MemberForm 의 객체 형태(MemberForm form)로 저장되어, @PostMapping("/members/new") 부분의 메소드의 매개변수로 할당됨.
->
멤버 객체를 생성하고,
매개변수로 가져온 form의 name 정보를 getName으로 가져와서,
그 name 정보를 멤버 객체에 setName으로 저장함.
그리고 완성된 멤버 객체를 멤버서비스의 join메소드로 회원가입 기능을 실행함. 즉, 회원 데이터 저장.
마지막으로 return "redirect:/";으로, 홈화면으로 리다이렉트하여 보내버림.

< main_hellospring_controller_MemberController 추가작성 코드 >
@Controller
public class MemberController {

    @GetMapping("/members/new")  // method='get' 방식일때
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")  // method='post' 방식일때
    public String create(MemberForm form) {
        Member member = new Member();  // 멤버 객체를 생성하고,
        member.setName(form.getName());  // 매개변수로 가져온 form의 name 정보를 getName으로 가져와서, 그 name 정보를 멤버 객체에 setName으로 저장함.

        memberService.join(member);  // 완성된 멤버 객체를 멤버서비스의 join메소드로 회원가입 기능을 실행함. 즉, 회원 데이터 저장.

        return "redirect:/";  // 홈화면으로 리다이렉트하여 보내버림.
    }
}

< main_templates_members_createMemberForm.html 코드 중요한거만 요약 >
<form action="/members/new" method="post">
  <input type="text" id="name" name="name" placeholder="이름을 입력하세요">  <!-- name="name" 에 주목해야한다. -->
  <button type="submit">등록</button>
</form>

< main_hellospring_controller_MemberForm >
public class MemberForm {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

------------------------------------------------

--------- '회원 웹 기능 - 조회' 강의 부분 필기 ---------

< main_hellospring_controller_MemberController 추가작성 코드 >
@Controller
public class MemberController {

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}

< main_templates_members_memberList.html 코드 중요한거만 요약 >
<tr th:each="member : ${members}">  <!-- 장고 템플릿 코드 for 문이랑 비슷하고, 거기에 향상된 for문을 응용시킨것 같다. -->
  <td th:text="${member.id}"></td>
  <td th:text="${member.name}"></td>
</tr>

------------------------------------------------

--------- 'H2 데이터베이스 설치' 강의 부분 필기 ---------

iterm 터미널에서 ./h2.sh 로 실행하고 들어가진 사이트 링크 앞에 ip주소가 적혀있다면, 해당부분만 localhost 로 바꿔주면 정상실행된다.
그리고 해당 사이트에서 JDBC URL 부분에 jdbc:h2:~/test 적혀있을텐데, 최초는 그걸로 연결하고,
나중에는 jdbc:h2:tcp://localhost/~/test 이걸로 접속하면 된다.

접속하고 코드 작성하고 command + enter 키를 누르면 해당 코드가 실행된다.

< member 테이블 생성 >
drop table if exists member CASCADE;
create table member
(
    id   bigint generated by default as identity,
    name varchar(255),
    primary key (id)
);

< member 테이블 조회 >
select * from member; (이거는 아무것도 적지말고 옆의 MEMBER 클릭만해도 자동 작성됨)

< member 테이블에 name='spring' 데이터 insert (첫데이터면 ID=1)>
insert into member(name) values('spring')

< member 테이블 데이터 전체 삭제 >
delete from member

------------------------------------------------

------------- '순수 JDBC' 강의 부분 필기 -------------

참고로 해당 강의 부분의 '순수 JDBC' DB 사용방법은 옛날식의 방법으로, 요즘은 쓰이지 않는 방법이다.
그러므로 어느정도 이렇다만 알아둬도 된다고 한다.

@Autowired 는
스프링 4.3버전부터
생성자 DI 방법으로 의존관계 형성할때,
생성자가 하나이고 그 생성자의 파라미터가 빈에 등록되어있는 상태라면,
@Autowired 를 생략하고 적지않아도 된다고 한다.
참고로 스프링 부트의 경우 DataSource 같은 DB Connection에 사용하는 기술 지원 로직까지 내부에서 자동으로 빈으로 컨테이너에 등록해준다.

main_resources_application.properties 파일에 코드 작성.
main_hellospring_repository_JdbcMemberRepository 클래스 파일 생성하고, 코드 작성.
main_hellospring_SpringConfig 파일 코드 수정 및 추가.

< main_hellospring_repository_JdbcMemberRepository 코드 중요한거만 요약 >
public class JdbcMemberRepository implements MemberRepository {

    private final DataSource dataSource;  // DB에 연결하려면 DataSource 라는것이 필요하다. 스프링을 통해서 데이터소스를 주입받을것이다. 예를들어 dataSource.getConnection() 같은 걸로.
    // control + enter 키 입력

    // @Autowired를 생략하였다.
    // 스프링 부트의 경우 DataSource 같은 DB Connection에 사용하는 기술 지원 로직까지 내부에서 자동으로 빈으로 컨테이너에 등록하기때문에,
    // 생성자가 하나이고 그 생성자의 파라미터가 빈에 등록되어있는 상태라면, @Autowired를 생략 가능하다라는 조건에 충족하여, @Autowired를 생략한것이다.
    public JdbcMemberRepository(DataSource dataSource) {  // 메모리 구현이 아닌, DB로 연결
        this.dataSource = dataSource;
    }

    // 나머지 오버라이딩이나 클로즈 코드들 구현하면 됨.
}

< main_hellospring_SpringConfig 추가작성 및 수정 코드 >
@Configuration
public class SpringConfig {

    // 코드 추가 부분
    private DataSource dataSource;
    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // 코드 수정 부분
    @Bean
    public MemberRepository memberRepository() {
        return new JdbcMemberRepository(dataSource);  // 이로써 MemoryMemberRepository 를 Jdbc 데이터베이스로 교체하였음.
    }
}

------------------------------------------------

---------- '스프링 통합 테스트' 강의 부분 필기 ----------

< test_hellospring_service_MemberServiceIntegrationTest 추가작성 및 수정 코드 >
// test_hellospring_service_MemberServiceTest 클래스 파일을 복사해와서 수정하였음.
@SpringBootTest  // 스프링 컨테이너와 테스트를 함께 실행한다. 즉, 이전에 해보았던 다른 test들과는 다르게, Spring을 사용하므로 @SpringBootTest 를 적어주어야 한다.
@Transactional  // 테스트 케이스에 @Transactional 를 적어주면 테스트 시작 전에 트랜잭션을 시작하고, 테스트 완료 후에 항상 롤백한다.
                // 이렇게 하면 DB에 데이터가 남지 않으므로 다음 테스트에 영향을 주지 않는다.
                // 덕분에 @AfterEach로 DB 초기화를 시켜주는 코드를 작성하지 않아도 된다.
class MemberServiceIntegrationTest {

    // MemberRepository memberRepository = new JdbcMemberRepository(dataSource);
    @Autowired MemberRepository memberRepository;  // MemoryMemberRepository가 아닌, MemberRepository로 코드를 수정한다.
                                                   // 그 이유는 main_hellospring_SpringConfig 의 코드를 jdbc 연결로 변경했기때문이다.
    // MemberService memberService = new MemberService(memberRepository);
    @Autowired MemberService memberService;

// @BeforeEach와 @AfterEach 코드부분 삭제했음. 나머지 @Test 코드 부분들은 동일함.
}

------------------------------------------------

-------- '스프링 JdbcTemplate' 강의 부분 필기 --------

스프링 JdbcTemplate과 MyBatis 같은 라이브러리는 JDBC API에서 본 반복 코드를 대부분 제거해준다. 하지만 SQL은 직접 작성해야 한다.

query() 메소드는 sql 파라미터로 전달받은 쿼리를 실행하고 RowMapper를 이용해서 ResultSet의 결과를 자바 객체로 변환한다.
dbcTemplate.query()는 List<Member> 형태를 반환한다.
RowMapper 인터페이스의 mapRow() 메소드는 SQL 실행 결과로 구한 ResultSet에서 한 행의 데이터를 읽어와 자바 객체로 변환하는 매퍼 기능을 구현한다.

List<Member> result = jdbcTemplate.query("select * from member where id = ?", memberRowMapper(), id);  // 첫번째 파라미터는 sql 쿼리의 ?물음표 부분에, memberRowMapper()로 불러온 ResultSet의 member 객체의 id값을 집어넣는다.
        return result.stream().findAny();  // 그러면 완성된 쿼리(반환 자료형은 리스트)로 DB에 적용시켜 DB에서 찾아봄.

< main_hellospring_repository_JdbcTemplateMemberRepository 코드 중요한거만 요약 >
import javax.sql.DataSource;  // 메모리 구현이 아닌, DB로 연결

public class JdbcTemplateMemberRepository implements MemberRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    // @Autowired를 생략할 수 있다.
    // 스프링 부트의 경우 DataSource 같은 DB Connection에 사용하는 기술 지원 로직까지 내부에서 자동으로 빈으로 컨테이너에 등록하기때문에,
    // 생성자가 하나이고 그 생성자의 파라미터가 빈에 등록되어있는 상태라면, @Autowired를 생략 가능하다라는 조건에 충족하여, @Autowired를 생략할 수 있다.
    public JdbcTemplateMemberRepository(DataSource dataSource) {  // DataSource를 인젝션 받는다.
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<Member> findById(Long id) {
        // query() 메소드는 sql 파라미터로 전달받은 쿼리를 실행하고 RowMapper를 이용해서 ResultSet의 결과를 자바 객체로 변환한다.
        // jdbcTemplate.query()는 List<Member> 형태를 반환함.
        List<Member> result = jdbcTemplate.query("select * from member where id = ?", memberRowMapper(), id);  // 첫번째 파라미터는 sql 쿼리의 ?물음표 부분에, memberRowMapper()로 불러온 ResultSet의 member 객체의 id값을 집어넣는다.
        return result.stream().findAny();  // 그러면 완성된 쿼리(반환 자료형은 리스트)로 DB에 적용시켜 DB에서 찾아봄.
    }
    // findByName 메소드는 위의 findById 메소드의 코드에서 id를 name으로 바꾸기만 하면 된다.

    @Override
    public List<Member> findAll() {
        return jdbcTemplate.query("select * from member", memberRowMapper());
    }

    private RowMapper<Member> memberRowMapper() {  // RowMapper 는 결과인 ResultSet인 rs 값을 담아와서 그 객체를 반환하는 역할이다.
        return (rs, rowNum) -> {
            Member member = new Member();
            member.setId(rs.getLong("id"));
            member.setName(rs.getString("name"));
            return member;
        };
    }
    /*
    // 아래 코드를 option + enter 키를 눌러, 람다로 변경한것이 위의 코드임.
    // 참고로 람다 함수는 함수형 프로그래밍 언어에서 사용되는 개념으로 익명 함수라고도 한다.
    // RowMapper 인터페이스의 mapRow() 메소드는 SQL 실행 결과로 구한 ResultSet에서 한 행의 데이터를 읽어와 자바 객체로 변환하는 매퍼 기능을 구현한다.
    private RowMapper<Member> memberRowMapper() {
        return new RowMapper<Member>() {
            @Override
            public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                Member member = new Member();
                member.setId(rs.getLong("id"));
                member.setName(rs.getString("name"));
                return member;
            }
        };
    }
    */
}

< main_hellospring_SpringConfig 수정 코드 >
return new JdbcMemberRepository(dataSource); 를
return new JdbcTemplateMemberRepository(dataSource); 로 교체해주면 된다.

------------------------------------------------

--------------- 'JPA' 강의 부분 필기 ---------------

JPA는 기존의 반복 코드는 물론이고, 기본적인 SQL도 JPA가 직접 만들어서 실행해준다.
JPA를 사용하면, SQL과 데이터 중심의 설계에서 객체 중심의 설계로 패러다임을 전환을 할 수 있다.

JPA는 ORM(Object-relational mapping) 기술로
객체와 DB의 데이터테이블을 매핑시켜주는 역할을 한다.
매핑은 어노테이션으로 한다.

Entity는 객체 관점에서 테이블에 대응되어 부르는 개념이다. @Entity 를 붙인 클래스의 이름으로 자동으로 데이터베이스의 테이블과 매핑이 된다.

@Entity 어노테이션을 클래스에 선언하면 그 클래스는 JPA가 관리한다.
@Column은 객체 필드를 테이블의 컬럼에 매핑시켜주는 어노테이션이다.

@Column(name = "name(필드와 매핑할 테이블의 컬럼 이름. 기본값은 객체의 필드 이름)")  //  @Column(name = "username")
private String name;

@Entity  // @Entity를 적어주면, 이것은 JPA가 관리하는 엔티티이다 라는 것이다.
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)  // sql쿼리로 DB에 데이터를 insert해주면, DB가 pk id값을 자동으로 생성해서 부여해주것을 IDENTITY 전략(strategy) 이라고 부른다.

< build.gradle 파일 코드 수정 부분>
// implementation 'org.springframework.boot:spring-boot-starter-jdbc' 이부분 삭제하고
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'  // 이걸로 변경

< main_resources_application.properties 파일 추가 코드 작성 >
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=none

< main_hellospring_domain_Member 수정 코드 >
// 회원 도메인 객체
@Entity  // 이것은 JPA가 관리하는 엔티티이다 라는 것이다.
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)  // sql쿼리로 DB에 데이터를 insert해주면, DB가 pk id값을 자동으로 생성해서 부여해주것을 IDENTITY 전략(strategy) 이라고 부른다.
    private Long id;

    // @Column(name = "name(필드와 매핑할 테이블의 컬럼 이름. 기본값은 객체의 필드 이름)")  // @Column(name = "username")
    private String name;
}

< main_hellospring_repository_JpaMemberRepository >
public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {  // JPA는 EntityManager 라는것으로 모든걸 동작한다.
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);  // persist는 영속하다. 영구 저장하다. 라는 뜻이다.
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {  // findById 에서 pk id 처럼 단건으로 조회하는기능은 createQuery jpql을 사용할필요 없지만, 다른 findByName나 findAll 기능은 jpql을 작성하여 사용해야한다.
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)  // 엔티티 m의 name 필드값에, m.name = ?로 ?값을 조회하고싶은데, 이 ?값을 name이라는 내맘대로 이름으로 지정해두고
                .setParameter("name", name)  // 왼쪽 "name"은 createQuery의 :name 부분이고, 오른쪽 name은 찾고자하는 이름인 findByName 메소드의 매개변수인 name 값이다.
                // setParameter로 데이터를 동적으로 바인딩시켜, 위의 :name부분을 찾고자하는 이름의 name값으로 치환시켜, 조회하는 기능의 jpql 쿼리를 날리겠다는 뜻이다.
                .getResultList();
        return result.stream().findAny();  // 필터링된 그중에서 가장 먼저 탐색된 요소를 반환함.
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList();  // createQuery는 JPQL이라는 객체지향 쿼리언어 이다.
                                                                                                // 보통 DB테이블을 대상으로 sql쿼리를 날리지만, jpql은 엔티티가 된 객체를 대상으로 쿼리를 날린다.
                                                                                                // 그러면 나중에 알아서 sql로 번역이 된다.
                                                                                                // 해당 코드를 해석해보자면, Member 엔티티를 조회하는데 그건 m으로 정히겠다는 뜻이다.
    }
}

< main_hellospring_service_MemberService 수정 코드>
    @Transactional  // JPA를 통한 모든 데이터 변경은 트랜잭션 안에서 실행해야 한다.
    public Long join(Member member) {
    }

< main_hellospring_SpringConfig 수정 코드 >
    private DataSource dataSource;
    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
이거를
    private EntityManager em;
    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }
이걸로 수정해준다.
그리고
return new JdbcMemberRepository(dataSource); 를
return new JpaMemberRepository(em); 로 교체해주면 된다.

------------------------------------------------

---------- '스프링 데이터 JPA' 강의 부분 필기 ----------

< main_hellospring_repository_SpringDataJpaMemberRepository > 
// 아래의 SpringDataJpaMemberRepository 인터페이스의 경우처럼 인터페이스 JpaRepository를 상속받는 인터페이스의 경우,
// 스프링 데이터 JPA가 인터페이스 SpringDataJpaMemberRepository의 메소드 구현체를 알아서 자동으로 만들어서 스프링 빈으로 자동 등록해준다.
// 뿐만아니라 MemberRepository라는 빈을 따로 등록할 필요가 없다. 스프링 jpa가 구현체를 자동으로 생성하여 bean으로 자동 등록해주었기 때문에 그냥 호출해서 사용하면된다.
// 즉, 인터페이스 스프링 제이피에이가 구현체를 자동으로 만들어줌으로써 그걸 가져다쓰기만하면되고, 이걸 SpringConfig에서 따로 Bean등록없이 MemberRepository를 @Autowired 할수있게 해준다.
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {  // 인터페이스가 인터페이스를 상속받을때에는 implements가 아닌, extends를 사용한다. 그리고 콤마(,)로 구분하여 다중 상속이 가능하다.
                                                                                                        // <Member, Long>는 <@Entity가 적혀있는 Member 클래스의 DB 엔티티, Member 엔티티의 pk id의 자료형인 Long> 이다.  // 자료형 <class T,ID 식별자 pk 자료형>
    @Override
    Optional<Member> findByName(String name);
    // findAll , save, findById는 구현이 필요없는데, 이는 JpaRepository안에 매우 기본적이고 공통적인 CRUD등이 전부 구현되어 있기 때문이다.
    // 하지만, findByName처럼 JpaRepository에 없는 특별한 경우에 대해서는 구현되어 있기 어렵다. (모든 시스템이 다르기 때문에)
    // 그래서 findByName 은 직접 구현해주어야한다.
}

< main_hellospring_SpringConfig 수정 코드 (전부 다시 적음) >
@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    // main_hellospring_repository_SpringDataJpaMemberRepository 덕분에 알아서 구현체가 빈에 등록되어있어 @Autowired로 의존관계 형성 가능해져서 인젝션 받음.
    @Autowired  // @Autowired 생략 가능하긴함.
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean  // 스프링 빈을 내가 직접 등록할거야 라는 의미이다.
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    /*
    @Bean
    public MemberRepository memberRepository() {  // public 메소드반환자료형 메소드명()  // memberRepository()는 생성자 아니니까 헷갈리지말자!
        // return new MemoryMemberRepository();  // MemberRepository는 인터페이스이기때문에 new로 인스턴스 생성이 불가능하므로, 메모리구현체인 new MemoryMemberRepository() 를 반환한다.
        // return new JdbcMemberRepository(dataSource);  // 이로써 MemoryMemberRepository 를 Jdbc 데이터베이스로 교체하였음.
        // return new JdbcTemplateMemberRepository(dataSource);
        // return new JpaMemberRepository(em);
    }
    */
}

------------------------------------------------

------------- 'AOP 적용' 강의 부분 필기 -------------

< main_hellospring_aop_TimeTraceAop >
@Aspect
@Component  // 이처럼 이걸로 컴포넌트 스캔 방법으로 스프링 빈에 등록하여 사용해도 되긴하지만,
            // 이 클래스는 좀 특별하다고 생각되기에 main_hellospring_SpringConfig 에 따로 직접 스프링 빈 등록 방법을 더 선호한다.
            // 일단 여기서는 컴포넌트 스캔 방법을 사용하겠다.
public class TimeTraceAop {

    @Around("execution(* hello.hellospring..*(..))")  // 원하는 곳(해당 경로 범위)에 공통 관심 사항 (시간측정로직 TimeTraceAop) 적용
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());  // joinPoint.toString() 이걸로 어떤 메서드를 콜하는지 이름을 알수있게 해준다.
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");  // joinPoint.toString() 이걸로 어떤 메서드를 콜하는지 이름을 알수있게 해준다.
        }
    }
}

------------------------------------------------

```
