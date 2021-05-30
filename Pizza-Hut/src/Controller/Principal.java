package Controller;
import processing.core.PApplet;
import processing.core.PImage;
import view.FirstScreen;
import view.RegisterScreen;
import view.CatalogScreen;
import view.PaymentScreen;
import view.GoodScreen;
import view.SummaryScreen;
import view.OutScreen;
public class Principal extends PApplet {

	PImage img;

	public static void main(String[] args) {
		PApplet.main("Principal");
	}
	FirstScreen firstscreen;
	RegisterScreen registerscreen;
	CatalogScreen catalogscreen;
	PaymentScreen paymentscreen;
	GoodScreen goodscreen;
	SummaryScreen summaryscreen;
	OutScreen outscreen;
	
	public boolean error = false;
	public int loginYes=0;
	public int loginMay=0;
	public int schange=0;
	public int ticketOne=0;
	public int ticket1=0;
	public int ticketTwo=0;
	public int ticket2=0;
	public int ticketThree=0;
	public int ticket3=0;

	@Override
	public void settings() // void Awake
	{
		size(1440, 1024);
		img = loadImage("Pantalla Inicio.png");
	}


	public void setup() // void Start
	{
		//firstscreen= new FirstScreen(0,this);
		//registerscreen= new RegisterScreen(0,this);
		//catalogscreen= new CatalogScreen(0,this);
		//paymentscreen= new PaymentScreen(0,this);
		//goodscreen= new GoodScreen(0,this);
		//summaryscreen= new SummaryScreen(0,this);
		//outscreen= new OutScreen(0,this);
	
		
	}

	
	public void draw() // void Update
	{
		image(img, 0, 0);
	}

}
