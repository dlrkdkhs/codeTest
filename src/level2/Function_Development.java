// 기능 개발

// 문제 설명
// 프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
//
// 또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고,
// 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.

// 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열
// speeds가 주어질 때 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.

// 제한 사항
// 작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
// 작업 진도는 100 미만의 자연수입니다.
// 작업 속도는 100 이하의 자연수입니다.
// 배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.

package level2;

import java.util.*;

public class Function_Development {
    public static ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<progresses.length; i++){
            // queue에 진도가 100이 되는 최소일수를 저장
            queue.add((int) (Math.ceil((100.0 - progresses[i]) / speeds[i])));
        }

        // queue가 비어 있지 않을 때 까지 반복
        while (!queue.isEmpty()){
            // 맨 앞에 있는 최소일수를 day에 저장후 queue에서 제거
            int day = queue.poll();
            // 하루에 배포 기능의 수
            int cnt = 1;

            // queue가 비어있지 않고 day와 맨 앞에 있는 일 수가 크거나 같을 때 까지 반복
            while(!queue.isEmpty() && day >= queue.peek()){
                // 배포할 기능의 수를 1씩 증가
                cnt++;
                // 맨 앞에 있는 최소일수를 제거
                queue.poll();
            }
            // 하루에 배포될 기능의 수를 저장
            list.add(cnt);
        }

        return list;
    }

    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speed = {1, 1, 1, 1, 1, 1};

        System.out.println(solution(progresses, speed));
    }
}
