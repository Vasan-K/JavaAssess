package satTest;
import java.util.*;

class Fishes{
	static List<Integer> fish = new ArrayList<>(Arrays.asList(0,0,1,1,1,0,0,1,0,1
			,0,0,1,1,1,0,0,1,0,1)); //0=male, 1=female
	synchronized void fun() {
		Random r=new Random();
		int x=21,y=21;
		x=r.nextInt(fish.size());
		y=r.nextInt(fish.size());
		while(x==y) y=r.nextInt(fish.size());
		System.out.println("Random Positions generated are :"+x+","+y);
		synchronized(fish) {
			if(fish.get(x)==0 && fish.get(y)==0) {
				fish.remove(x);
				fish.remove(y);
				System.out.println("Two male fishes met : "+fish);
				System.out.println("And the size is : "+fish.size());
			}
			else if(fish.get(x)==1 && fish.get(y)==1) {
				int d=new Random().nextBoolean()?x:y;
				fish.remove(d);
				System.out.println("Two Female Fishes met : "+fish);
				System.out.println("And the size is : "+fish.size());
			}
			else if((fish.get(x)==0 && fish.get(y)==1)||(fish.get(x)==1 && fish.get(y)==0)) {
				int z=r.nextInt(2);
				int z1=r.nextInt(2);
				fish.add(z);fish.add(z1);
				System.out.println("A male and Female fish met : "+fish);
				System.out.println("And the size is : "+fish.size());
			}
		}
	}
}
class fishpond extends Thread{
	Fishes t;
	fishpond(Fishes t){
		this.t=t;
	}
	public void run() {
		t.fun();
	}
}
public class InfinitePond {
	public static void main(String args[]) {
		Fishes t=new Fishes();
	   
		fishpond d=new fishpond(t);d.start();
		fishpond d1=new fishpond(t);d1.start();
		fishpond d2=new fishpond(t);d2.start();
		fishpond d3=new fishpond(t);d3.start();		
		fishpond d4=new fishpond(t);d4.start();		
		
	}
}




