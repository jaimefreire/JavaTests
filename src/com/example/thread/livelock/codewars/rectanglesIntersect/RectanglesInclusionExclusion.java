package com.example.thread.livelock.codewars.rectanglesIntersect;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class RectanglesInclusionExclusion {

    public static void main(String[] args) throws IOException {

        List<String> rects = Files.readAllLines(Paths
                .get("./src/com/example/thread/livelock/codewars/rectanglesIntersect/simpleIntersections2.txt"));

        int[][] rectangles = rects.parallelStream()
                .map(s -> s.replace("[", ""))
                .map(s -> s.replace("]", ""))
                .map(s -> s.replace(",", ""))
                .map(s -> s.trim())
                .map(s -> s.split(" "))
                .map(s -> Arrays.stream(s).parallel().mapToInt(m -> Integer.valueOf(m).intValue()).toArray())
                .sorted((x, y) -> (Integer.compare(x[0], y[0])))
                .toArray(int[][]::new);

        int area = calculateSpace(rectangles);

        System.out.println("Area:  " + area);
    }

    public static int calculateSpace(int[][] rectangles) {
        int area = 0;

        List<Rectangle> rList = Arrays.stream(rectangles)
                .map(r -> new Rectangle(r[0], r[1], r[2] - r[0], r[3] - r[1]))
                .sorted((r1, r2) -> (Double.compare(r1.getX(), r2.getX())))
                .collect(Collectors.toList());

        Iterator<Rectangle> itr = rList.iterator();

        for (int i = 0; itr.hasNext(); i++) {
            area += calc(itr.next(), 1, rList, i + 1);
            System.out.println(String.format("Area in it - %s : %s", i, area));
        }
        return area;

    }

    //A depth-first search for overlaps.
    //Each consecutive overlap alternates inclusionExclusion.
    private static int calc(Rectangle currentRectangle, int inclusionExclusion, List<Rectangle> rList, int nextIdx) {

        int area = (int) (currentRectangle.getHeight() * currentRectangle.getWidth() * inclusionExclusion);

        for (int i = nextIdx; i < rList.size(); i++) {

            if (currentRectangle.intersects(rList.get(i))) {
                Rectangle overlap = currentRectangle.intersection(rList.get(i));
                int overl = calc(overlap, inclusionExclusion * -1, rList, i+1);
                System.out.println("overl: " +overl);
                area += overl;
            }
        }
        return area;
    }
}