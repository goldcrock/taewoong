package testPackage;

import com.example.testkotlin.MainActivityKt;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        int a = MainActivityKt.methodWithBlock(3, 4);
        System.out.println(a);

        System.out.println("input the number : ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MainActivityKt.readNumber(br);
    }
}
