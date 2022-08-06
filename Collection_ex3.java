// https://edu-coding.tistory.com/119
// 컬렉션 문제 3번

// 이건 내 코드
import java.util.*;

public class Collection_ex3 {
    public static void main (String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(800525, "임꺽정");
        map.put(891205, "철수");
        map.put(870721, "일지매");
        map.put(891205, "홍길동");
        map.put(900817, "순이");

        System.out.println("이름\t주민번호");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getValue() + "\t" + entry.getKey());
        }
    }
}
