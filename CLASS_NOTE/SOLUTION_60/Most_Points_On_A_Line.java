/*
* class Point {
*   public int x;
*   public int y;
*   public Point(int x, int y) {
*     this.x = x;
*     this.y = y;
*   }
* }
*/
public class Solution {
    public int most(Point[] points) {
        // corner case
        if (points == null || points.length <= 1) {
            return 0;
        }
        int result = 0;

        for (int i = 0; i < points.length; i++) {
            int sameNode = 1;
            int sameX = 0;
            int most = 0;
            Map<Double, Integer> map = new HashMap<>();

            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }

                if (points[j].x == points[i].x && points[j].y == points[i].y) {
                    sameNode++;
                } else if (points[j].x == points[i].x) {
                    sameX++;
                } else {
                    double slope = (points[j].y - points[i].y) / (points[j].x - points[i].x - 0.0);
                    if (map.containsKey(slope)) {
                        map.put(slope, map.get(slope) + 1);
                    } else {
                        map.put(slope, 1);
                    }
                    most = Math.max(most, map.get(slope));
                }
            }
            most = Math.max(most, sameX);
            result = Math.max(result, most + sameNode);
        }
        return result;
    }
}