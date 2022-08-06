// https://edu-coding.tistory.com/119
// 컬렉션 문제 4번

// 이건 내 코드
import java.util.*;

public class Collection_ex4 {
    Scanner scan = new Scanner(System.in);
    Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
    ArrayList<Integer> list = new ArrayList<Integer>();

    public void Menu() {
        while(true) {
            System.out.printf("성적관리 프로그램\n  1.성적입력  2.성적출력  3.성적수정  4.성적삭제  5.종료\n");
            System.out.print("번호 입력: ");
            int menu_num = scan.nextInt();
            System.out.println();
            
            if (menu_num==1)
                InputGrade();
            else if (menu_num==2)
                PrintGrade();
            else if (menu_num==3)
                CorrectGrade();
            else if (menu_num==4)
                RemoveGrade();
            else {
                System.out.println("프로그램 종료");
                return;  // 해당 메소드 종료
            }
        }
    }

    public void InputGrade() {
        ArrayList<Integer> copy_list = new ArrayList<Integer>();

        System.out.print("이름: ");
        String name = scan.next();
        System.out.print("국어: ");
        list.add(scan.nextInt());
        System.out.print("영어: ");
        list.add(scan.nextInt());
        System.out.print("수학: ");
        list.add(scan.nextInt());
        
        copy_list.addAll(list);
        map.put(name, copy_list);
        list.clear();

        System.out.println();
    }

    public void PrintGrade() {
        System.out.printf("이름\t국어\t영어\t수학\t총점\t평균\n");
        for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
            int a = entry.getValue().get(0);
            int b = entry.getValue().get(1);
            int c = entry.getValue().get(2);

            System.out.println(entry.getKey() + "\t" + a + "\t" + b + "\t" + c + "\t"
            + (a+b+c) + "\t" + String.format("%.5f", ((a+b+c)/3.0)));
        }

        System.out.println();
    }

    public void CorrectGrade() {
        // arraylist.set(0, "b"); 이런식이면 0번째인덱스의 요소를 b로 변경한다는 뜻이다. 이처럼 응용하여 풀면된다.
        System.out.println("굳이 안해도 될듯 하여 건너뛰겠음.");
        System.out.println();
    }

    public void RemoveGrade() {
        System.out.println("굳이 안해도 될듯 하여 건너뛰겠음.");
        System.out.println();
    }

    public static void main(String[] args) {
        new Collection_ex4().Menu();
    }
}
