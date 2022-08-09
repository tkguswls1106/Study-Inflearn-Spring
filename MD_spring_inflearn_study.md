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
- 같은이름의 변수명을 바꾸고싶을때는 키보드 커서를 해당 변수에 갖다놓고 shift + (fn) + F6 키를 누르고 이름을 변경하면 다같이 한번에 변경된다.
- 예를들어 Optional<Member> result = memberRepository.findByName(member.getName()); 의 우항인 memberRepository.findByName(member.getName()); 만 작성해두고, command + option + v 키를 누르면 좌항이 Optional<Member> result 가 자동완성되고 이름을 지을 수 있다.
- 따로 메소드를 빼서 만들어주고싶다면, 해당 작성한 메소드를 전부 드래그해놓고, control + t 키를 누르고 extract method 를 선택하면 된다. 아니면 그냥 드래그하고 command + option + m 키를 누르면 된다.

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

MemberRepository 인터페이스는 단순히 데이터를 저장소에 저장하고 넣었다뺐다하는, 기계적인 개발적 느낌이 강하다면,
MemberService 클래스같은 서비스 클래스는 join, findMembers 를 보다시피, 이름이 비즈니스적이다. 그래서 서비스 클래스에는 대개 비즈니스 관련 용어의 이름을 쓰며 비즈니스적 느낌이 강하다.

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
        member.setId(++sequence);  // member의 id로 ++sequence 를 저장하고,
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
        Member member = new Member();
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

< main_hellospring_service_MemberService >
public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository(); // 좌항 우항 다른거니까 이름 비슷하다고 헷갈리지말자!

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

```
