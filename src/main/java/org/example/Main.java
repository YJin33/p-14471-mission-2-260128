package org.example;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        System.out.println("== 명언 앱 ==");
        Scanner sc = new Scanner(System.in);
        int i=1;
        ArrayList<Ment> list = new ArrayList<>(); //번호 ==인덱스 위치에 저장한 클래스
        ArrayList<Integer> now = new ArrayList<>();//지금 존재하는 번호만 저장
        Ment mnt = new Ment();
        list.add(mnt);//0번

        while(true){
            System.out.println("명령) ");
            String order = sc.nextLine();
            String suborder = order.substring(0,2);
            if(suborder.equals("종료")){
                break;
            }else if(suborder.equals("등록")){
                Ment mn = new Ment();
                System.out.println("명언: ");
                mn.sentence = sc.nextLine();
                System.out.println("작가: ");
                mn.author = sc.nextLine();
                mn.number=i;
                list.add(mn);
                now.add(i);
                System.out.println(i+"번 명언이 등록되었습니다.");
                i++;
            }else if(suborder.equals("목록")){
                System.out.println("번호 / 작가 / 명언");
                System.out.println("---------");
                for(int j = now.size()-1;j>=0;j--){
                    int k = now.get(j);
                    Ment mn = list.get(k);
                    System.out.println(String.format("%d / %s / %s",mn.number,mn.sentence, mn.author));
                }
            }else if(order.substring(2).matches("^[?]id=[0-9]+$")){
                //삭제 또는 수정의 형식일 경우: id 존재 여부 확인
                int id = Integer.parseInt(order.substring(6));
                if(!now.contains(id)){
                    System.out.println(id+"번 명언은 존재하지 않습니다.");
                    continue;
                }
                //삭제 또는 수정 처리
                if(suborder.equals("삭제")) {
                    now.remove(now.indexOf(id));
                    now.trimToSize();
                }else if(suborder.equals("수정")){
                    Ment modifyingMent = list.get(id);
                    System.out.println("명언(기존) : "+modifyingMent.sentence);
                    System.out.println("명언 : ");
                    modifyingMent.sentence = sc.nextLine();

                    System.out.println("작가(기존) : "+modifyingMent.author);
                    System.out.println("작가 : ");
                    modifyingMent.author = sc.nextLine();

                    list.set(id,modifyingMent);
                }

            }
        }
    }
}
class Ment{
    int number;
    String sentence;
    String author;
}