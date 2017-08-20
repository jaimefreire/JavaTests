package com.example.thread.livelock.codewars.rectanglesIntersect;

import org.junit.Assert;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class RectanglesUnion {
    public static void main(String[] args) throws IOException {
        /*
        Assert.assertEquals("One rectangle [0, 4, 11, 6] => 22"
                , 22, RectanglesUnion.calculateSpace(new int[][]{{0, 4, 11, 6}}));

        Assert.assertEquals(36, RectanglesUnion.calculateSpace(new int[][]{{3, 3, 8, 5}
                , {6, 3, 8, 9}, {11, 6, 14, 12}})); // returns 36

        Assert.assertEquals(18000010, RectanglesUnion.calculateSpace(new int[][]{{3, 3, 8, 5}
                , {11000, 6000, 14000, 12000}})); // returns 36

        */
        List<String> rects = Files.readAllLines(Paths.get("./src/com/example/thread/livelock/codewars/rectanglesIntersect/simplerIntersections.txt"));

        int[][] rectangles = rects.parallelStream()
                .map(s -> s.replace("[", ""))
                .map(s -> s.replace("]", ""))
                .map(s -> s.replace(",", ""))
                .map(s -> s.trim())
                .map(s -> s.split(" "))
                .map(s -> Arrays.stream(s).mapToInt(m -> Integer.valueOf(m).intValue()).toArray())
                .sorted((x, y) -> (Integer.compare(x[0], y[0])))
                .toArray(int[][]::new);

        //System.out.println(Arrays.deepToString(rectangles));
        System.out.println(RectanglesUnion.calculateSpace(rectangles));
        //int[][] intg = new int [][] {{0,4,11,6}};
        //System.out.println(RectanglesUnion.calculateSpace(intg));

    }

    public static int calculateSpace(int[][] rectangles) {
        if (rectangles == null || rectangles.length == 0) return 0;
        long I = 0, S = 0;

        for (int i = 0; i < rectangles.length; i++) {

            int[] rec = rectangles[i];
            Rectangle r = new Rectangle(rec[0], rec[1], rec[2] - rec[0], rec[3] - rec[1]);
            long ll = r.height * r.width;
            S += ll;

            //Intersections
            for (int j = i + 1; j < rectangles.length; j++) {
                int[] recB = rectangles[j];
                Rectangle r2 = new Rectangle(recB[0], recB[1], recB[2] - recB[0], recB[3] - recB[1]);

                if (r.intersects(r2)) {
                    //area += Calculate(overlap, inclusionExclusion * -1, nextRectangle + 1);

                }
            }
            I+=r.getHeight()*r.getWidth();
        }

        return (int) (S - I);
    }

    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        int areaOfSqrA = (C - A) * (D - B);
        int areaOfSqrB = (G - E) * (H - F);

        int left = Math.max(A, E);
        int right = Math.min(G, C);
        int bottom = Math.max(F, B);
        int top = Math.min(D, H);

        //If overlap
        int overlap = 0;
        if (right > left && top > bottom)
            overlap = (right - left) * (top - bottom);

        return areaOfSqrA + areaOfSqrB - overlap;
    }

}