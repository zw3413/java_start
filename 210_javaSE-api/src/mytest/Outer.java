package mytest;

class Outer {
	static{
		System.out.println("Outer static block was excuted");
	}
    private int time;
    private Inner inner;
    Outer(int time) {
        this.time = time;
        inner = new Inner();
        inner.timeInc();
        System.out.println("Outer constructer was excuted");
    }
    public void printTime() {
    	final int a=0;
        System.out.println(time);
    }
    class Inner {
        public void timeInc() {
            time++;
            
        }
    }
}