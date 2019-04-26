package mytest;

class InnerClassTest{
	public static void main(String[] args) {
		Outer outer=new Outer(22);
		Outer.Inner inner=outer.new Inner();
		inner.timeInc();
		outer.printTime();
		Outer.Inner inner1=new Outer(22).new Inner();
	}
}
