package mytest;

public class BaseClass {
 int x,y,z,w;
 public BaseClass(int a,int b){
	 x=a;
	 y=b;
 }
 public BaseClass(int a,int b,int c,int d){
	 this(a,b);
	 w=d;
	 z=c;
 }
}
/*
public class Base{ 
int w, x, y ,z; 
public Base(int a,int b) { 
x=a; y=b; 
} 
public Base(int a, int b, int c, int d) { 
// ... 
w=d; 
z=c; 
} 
} */