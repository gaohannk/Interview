package fidessa;

public class Draw {
  public static void main(String[] args){
	  Shape[] shaps=new Shape[20];
	
	shaps[0]= new Triangle();
	shaps[1]= new Square();
	shaps[0].draw();
	shaps[1].draw();
  }
}
