package com.example.lab2;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Random;

@Controller
public class LAB2 {

    @RequestMapping("/")
    @ResponseBody
    public String greet() {
        return "Akylbek Zhannat " +
                "\n" + "Lab2";
    }

    @GetMapping("/currentTime")
    @ResponseBody
    public String getDayOfWeek() {
//            long sec = Instant.now().toEpochMilli();
//            return "after " + sec;

        Instant DayX = Instant.parse("2000-10-01T00:00:00Z");
        Instant now = Instant.now();
        Duration duration = Duration.between(DayX, now);
        long sec = duration.toMillis();
        return "after " + sec;

//        LocalDateTime now = LocalDateTime.now();
//        return "Current time: " + now.getDayOfWeek().toString();
//        return "Current time: " + LocalDateTime.now().toString();
    }

    @GetMapping("/api")
    @ResponseBody
    public String getNumber(@RequestParam("q") int n) {
        StringBuilder numbers = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            numbers.append(i).append(" ");
        }
        return numbers.toString();
    }

    @GetMapping("/random_number")
    @ResponseBody
    public int getRandomNumber(){
        Random random = new Random();
        return random.nextInt(501);
    }

    @GetMapping("/fib")
    @ResponseBody
    public long getFibonacci(@RequestParam("n") int n){
        return fibo(n);
    }

    private long fibo(int n){
        long x = 0, y = 1;
        for (int i = 2; i <= n; i++) {
            long temp = x;
            x = y;
            y = temp + x;
        }
        return y;
    }


    @GetMapping("/{string}")
    @ResponseBody
    public String reverseString(@PathVariable String string, @RequestParam String str) {
        return new StringBuilder(str).reverse().toString();
    }

}













































//@GetMapping("/api")
//@ResponseBody
//public String getNumbers(@RequestParam("q") int n) {
//    int[] numbersArray = new int[n];
//
//    // Заполняем массив числами от 1 до n
//    for (int i = 0; i < n; i++) {
//        numbersArray[i] = i + 1;
//    }
//
//    // Преобразуем массив в строку
//    StringBuilder numbers = new StringBuilder();
//    for (int num : numbersArray) {
//        numbers.append(num).append(" ");
//    }
//
//    return numbers.toString();
//}



//public int[] getNumbers(@RequestParam(value = "q", defaultValue = "10") int n) {
//    int [] i = new int[n];
//    for(int j = 0; j< n; j ++){
//        i[j] = j;
//    }
//    return i;
//}