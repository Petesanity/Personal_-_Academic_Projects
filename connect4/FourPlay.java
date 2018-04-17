package Connect4;


public class FourPlay {
	
	public static void main(String [] args){
			javax.swing.SwingUtilities.invokeLater(new Runnable(){
				@Override 
				public void run(){
					 Connect_4_gui gui =  new Connect_4_gui ();
				}
			});
	}
}


