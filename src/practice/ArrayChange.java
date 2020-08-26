package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayChange {


    /**
     * 给出一个长度为 n 的数组，和一个正整数 d。
     * 你每次可以选择其中任意一个元素 a[i] 将其变为 a[i] + d 或 a[i] - d，这算作一次操作。
     * 你需要将所有的元素全部变成相等元素，如果有解，请输出最小操作次数，
     * 如果无解请输出 -1。
     */
    public static void main(String[] args) {
        System.out.println("请按照提示输入n(1<=n<=100000),d(1<=d<=100),a[i](1<=a[i]<=100000)");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数组长度n:");
        int n = sc.nextInt();
        if(n<1||n>100000) {
            System.out.println("输入的数组长度有误, 1<=n<=100000");
            return;
        }
        System.out.println("请输入数字d:");
        int d = sc.nextInt();
        if(d<1||d>100) {
            System.out.println("输入的数字d有误,1<=d<=100");
            return;
        }
        System.out.println("请输入数组长度为" + n + "的数组a[i]");
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            if(a[i]<1 || a[i] > 100000) {
                System.out.println("输入的数组数据有误, 1<=a[i]<=100000");
                return;
            }
        }
        int r = a[0] % d;
        for(int i = 0; i < n; i++) {
            if(r != a[i]%d) {
                System.out.println("无解，输出:-1");
                return;
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if(a[j]<a[i]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        System.out.println("排序后的数组为:");
        for(int i = 0; i< n; i++) {
            System.out.print(a[i]);
        }
        int step = 0;
        int index = n%2==0?n/2-1:(n+1)/2-1;
        for(int i = 0; i < index; i++) {
            step += (a[index]-a[i])/d;
        }
        for(int i = index + 1; i < n; i ++) {
            step += (a[i]- a[index])/d;
        }
        System.out.println();
        System.out.println("最优解为" + step + "步");
    }


    public ArrayList<ArrayList<Integer>> getSubsets(int[] A, int n) {
        // write code here
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
        if(n==0) {
            return arrayList;
        }
        if(n==1) {
            ArrayList<Integer> aList = new ArrayList<Integer>(A[0]);
            arrayList.add(aList);
            return arrayList;
        }
        for(int i = 0; i < n; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int j = i+1; j<n; j++) {
                list.add(i);
                for(int k = j; k < n; k++) {
                    list.add(A[k]);
                    list.set(i, list.get(j));
                    list.set(j, 1);
                    ArrayList<Integer> tempList = new ArrayList<Integer>();
                    tempList = list;
                    arrayList.add(tempList);
                }
                list.clear();
            }
        }
        return arrayList;
    }

}
