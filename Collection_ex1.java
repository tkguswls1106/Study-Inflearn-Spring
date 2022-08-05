// https://edu-coding.tistory.com/119
// 컬렉션 문제 1번

// 이건 내 코드
import java.util.HashSet;

public class Collection_ex1 {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 40, 30, 20};

        HashSet<Integer> set1 = new HashSet<Integer>();
        System.out.println("데이터" + "\t" + "set삽입");
        for (int i=0; i<arr.length; i++) {
            int setsize = set1.size();
            set1.add(arr[i]);
            if (setsize != set1.size()) {
                System.out.println(arr[i] + "\t" + "true");
            }
            else {
                System.out.println(arr[i] + "\t" + "중복데이터");
            }
        }

        System.out.println("set"+set1);
    }
}

// 이건 다른사람 코드
/*
import java.util.HashSet;
import java.util.Set;

public class ex01 {

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 40, 30, 20};
        int i;
        Set<Integer> set = new HashSet<Integer>();

        System.out.println("데이터" + "\t" + "set삽입");
        for(i=0; i<arr.length; i++) {
            System.out.println(arr[i] + "\t" + (set.add(arr[i])?"true":"중복데이터"));
            // HashSet.add()애서 add() 메소드는 인자를 저장하고, 객체를 저장할 때 객체가 Set에 저장되어있지 않았다면 True를 리턴한다. 이미 저장되어있다면 False를 리턴한다.
        }

        System.out.println("set" + set);
    } 
}
 */