package mytest;

import java.util.Arrays;

public class Test2{ public static void main(String[] args) { int[] arr = {10,23,4,27,5,48}; sort(arr); System.out.println(Arrays.toString(arr)); } public static void sort(int[] arr){ for(int i=0; i<arr.length-1; i++){ for(int j=0; j<arr.length-i-1; j++){ if(arr[j]<arr[j+1]){ int t = arr[j]; arr[j] = arr[j+1]; arr[j+1] = t; } } } } }