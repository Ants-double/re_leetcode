package com.ants.leetcode.middle;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author ants_
 */
public class PlanetaryCollisions735 {


    public static void main(String[] args) {
        PlanetaryCollisions735 test = new PlanetaryCollisions735();
        int[] ints = test.asteroidCollision(new int[]{1, -2, -2, -2});
        Arrays.stream(ints).forEach(x -> System.out.println(x));
    }

    Stack<Integer> temp = new Stack<>();

    public int[] asteroidCollision(int[] asteroids) {

        for (int i = 0; i < asteroids.length; i++) {

            if (temp == null || temp.size() <= 0) {
                temp.push(asteroids[i]);
                continue;
            }
            if (temp.peek() < 0) {
                temp.push(asteroids[i]);
                continue;
            }
            Integer pop = temp.pop();
            Integer compare = compare(pop, asteroids[i]);

            while (compare != null && !temp.isEmpty()) {
                Integer popTemp = temp.pop();
                compare = compare(popTemp, compare);
            }
            if (compare != null && temp.isEmpty()) {
                temp.push(compare);
            }
        }
        int[] re = new int[temp.size()];
        for (int i = temp.size() - 1; i >= 0; i--) {
            re[i] = temp.pop();
        }
        return re;
    }

    public Integer compare(int pop, int asteroid) {
        Integer re = null;
        // 同号不处理
        if (pop > 0 && asteroid > 0) {
            temp.push(pop);
            temp.push(asteroid);
        }
        if (pop < 0 && asteroid < 0) {
            temp.push(pop);
            temp.push(asteroid);
        }
        // 异号
        if (pop * asteroid < 0) {
            if (Math.abs(pop) == Math.abs(asteroid)) {
                // 全丢
            }
            if (Math.abs(pop) > Math.abs(asteroid)) {
                // 保留原值

                temp.push(pop);
            }
            if (Math.abs(pop) < Math.abs(asteroid)) {
                return asteroid;
                // 继续向前碰撞
            }
        }

        return re;
    }

    public int[] asteroidCollision1(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            //  当前行星往右移，或者栈顶行星往左移，他们都不会发生碰撞
            if (stack.isEmpty() || asteroids[i] > 0 || stack.peek() < 0) {
                stack.add(asteroids[i]);
            } else if (stack.peek() <= -asteroids[i]) {
                // 如果产生碰撞，确定哪个销毁，如果当前行星不销毁，就继续碰撞
                if (stack.pop() < -asteroids[i]) {
                    i--;
                }
            }
        }

        return stack.stream().mapToInt(x -> x).toArray();
    }
}
