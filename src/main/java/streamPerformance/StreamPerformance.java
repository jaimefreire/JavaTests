package streamPerformance;

import java.util.stream.IntStream;

public class StreamPerformance implements Measurable {

    public static void main(String[] args) {
        System.out.println("Measuring performance through Proxy");
        Measurable task = (Measurable) ProxyFactory.newInstance(new StreamPerformance());
        task.measure();
        task.measureB();

    }

    @Override
    public void measure() {
        System.out.println("Sum result: " + IntStream.rangeClosed(1, 300440112).parallel().reduce((x, y) -> x + y).orElse(0));
    }
    @Override
    public void measureB() {
        System.out.println("Sum result: " + IntStream.rangeClosed(1, 300440112).reduce((x, y) -> x + y).orElse(0));
    }

}
