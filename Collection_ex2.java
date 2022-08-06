// https://edu-coding.tistory.com/119
// 컬렉션 문제 2번

// 이건 내 코드
import java.util.*;

public class Collection_ex2 {
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();

    public void SelectMenu() {
        while(true) {
            System.out.println("Lotto 프로그램");
            System.out.println("=============");
            System.out.println("1. Lotto 구매");
            System.out.println("2. 프로그램 종료");
            System.out.println("=============");
            
            System.out.print("메뉴 선택: ");
            int menu = scan.nextInt();
            System.out.println();

            if (menu==1) {
                BuyLotto();
            }
            else if (menu==2) {
                System.out.println("프로그램 종료");
                return;  // 해당 메소드 종료
            }
            else {
                System.out.println("번호를 잘못 입력했습니다. 1 또는 2를 입력하세요.");
            }
        }   
    }

    public void BuyLotto() {
        System.out.println("  Lotto 구매합니다.");
        System.out.println("[로또 구입단가 1000원]");
        System.out.print("금액 입력: ");
        int price = scan.nextInt();
        System.out.println();

        System.out.printf("로또 번호 출력하기 (%d개의 번호 출력)\n", price/1000);
        PrintLotto(price/1000);
        System.out.printf("받은 금액은 %d원이고, 사용금액은 %d원이며 거스름돈은 %d원입니다.\n\n", price, price-price%1000, price%1000);
    }

    public void PrintLotto(int n) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i=1; i<=n; i++) {
            while(set.size()!=6) {
                set.add(rand.nextInt(45)+1);
            }
            List<Integer> list = new ArrayList<Integer>(set);  // 저장용량을 set크기만큼함. 즉 6으로 설정. 하지만 더 늘어날수도잇을듯?
                                                               // 하지만 매개변수에 숫자를 넣으면 초기용량 지정이지만, 이번 경우처럼 set같은걸 넣으면 그대로 복사해서 넣어주는듯 하다.
                                                               // 이 코드의 경우에서는 List<HashSet> list = new ArrayList<HashSet>(set); 은 틀린거니까 주의하자.
            set.clear();
            Collections.sort(list);
            System.out.println("로또번호" + i + ": " + list);
        }
    }

    public static void main(String[] args) {
       Collection_ex2 start = new Collection_ex2();
       start.SelectMenu();
       // 위의 두줄 코드를 간결하게 압축하자면
       // new Collection_ex2().SelectMenu(); 이다.
    }
}

// 이건 다른사람 코드
/*
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LottoStore {
    Scanner scan = new Scanner(System.in);

    public void Store_Menu(){
        System.out.println("Lotto 프로그램");
        System.out.println("============");
        System.out.println("1. Lotto 구입");
        System.out.println("2. 프로그램 종료");
        System.out.println("============");
    }

    public void StoreStart(){
        while(true){
            Store_Menu();
            System.out.print("메뉴 선택 : ");
            int choice = scan.nextInt();

            if(choice == 1)
                BuyLotto();
            else if(choice == 2) {
                System.out.println("프로그램 종료");
                return;
            }
            else
                 System.out.println("번호를 잘못 입력했습니다. 1 또는2를 입력하세요.");
        }
    }

    public void BuyLotto(){
        System.out.print("금액 입력 : ");
        int money = scan.nextInt();
    
        if(money<1000){
            System.out.println("1000원 이상 입력해 주세요.");
            return;
        }else if(money>100000){
            System.out.println("100000원을 초과 할수 없습니다. 다시 입력해주세요.");
            return;
        }

        LottoNum(money);
        System.out.println("받은 금액은 " + money + "원이고, 거스름돈은 " + (money%1000) + "원 입니다.");
    }

    public void LottoNum(int money){
        Set<Integer> lottoSet = new HashSet<>();
        int amount = money/1000;
        System.out.println();
        System.out.println("로또 번호 출력하기");

        for(int i=1; i<=amount; i++){
             while(lottoSet.size()<6){
                 lottoSet.add((int)(Math.random() * 45 + 1));
             }

             ArrayList<Integer> lottoList = new ArrayList<Integer>(lottoSet);
             Collections.sort(lottoList);
             System.out.println("로또번호" + i + " : " + lottoList);
             lottoSet.clear();
        }
    }

    public static void main(String[] args) {
        new LottoStore().StoreStart();
    }
}
 */
