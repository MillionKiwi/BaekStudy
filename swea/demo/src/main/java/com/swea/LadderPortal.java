    package com.swea;

    import java.util.*;
    import java.io.*;

    class Location {
        public int x; // 열 (Column)
        public int y; // 행 (Row)

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public class LadderPortal {

        static char[][] ladder;
        static int N; // 행 (세로줄)
        static int M; // 열 (참가자 수)
        static Map<Character, List<Location>> portalMap = new HashMap<>();    //위치 저장용 해쉬맵

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken()); // 행의 수 (세로 길이)
            M = Integer.parseInt(st.nextToken()); // 열의 수 (참가자 수)

            ladder = new char[N][M];

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                st = new StringTokenizer(line, "."); // "."을 구분자로 문자열을 자름

                for (int j = 0; j < M; j++) {
                    String token = st.nextToken();
                    char alpha = token.charAt(0); 
                    
                    ladder[i][j] = alpha;

                    if (alpha != '|') {
                        portalMap.putIfAbsent(alpha, new ArrayList<>());
                        portalMap.get(alpha).add(new Location(j, i));
                    }
                }
            }

            int[] ans = new int[M]; // 정답 기록용 배열

            for (int i = 0; i < M; i++) {
                Location curLocation = new Location(i, 0);

                // 사다리 끝에 도달할 때까지 아래로 이동
                while (curLocation.y < N) {
                    if (ladder[curLocation.y][curLocation.x] == '|') {
                        curLocation.y++;
                    } else {
                        curLocation = findNextLoc(curLocation);
                        curLocation.y++;
                    }
                }
                ans[curLocation.x] = i + 1;
            }

            // 정답 출력
            for (int i = 0; i < M; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }

        public static Location findNextLoc(Location loc) {
            int cur_x = loc.x;
            int cur_y = loc.y; 

            char cur_char = ladder[cur_y][cur_x];
            List<Location> locList = portalMap.get(cur_char);

            if(locList.get(0).x == cur_x && locList.get(0).y == cur_y){
                Location nextLoc = locList.get(1);
                return new Location(nextLoc.x, nextLoc.y);
            }
            else{
                Location nextLoc = locList.get(0);
                return new Location(nextLoc.x, nextLoc.y);
            }
        }
    }