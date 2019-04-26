package mytest;

class Demo {
int x;
public static void main(String[] args) {
Demo d = new Demo();
d.x = 8;
show(d);
System.out.println("x="+d.x);
}
public static void show(Demo d)	{
d.x = 7;
}
}