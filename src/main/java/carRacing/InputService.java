package carRacing;

import java.util.Scanner;

public class InputService {

    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int inputRepeatCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
