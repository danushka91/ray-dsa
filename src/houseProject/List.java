package houseProject;

public abstract class List {
	protected Listable[] myList;
	protected int noOfItems;
	protected int cpos;
	
	public List(int max){
		noOfItems = 0;
		myList = new Listable[max];
	}
	
	public boolean canAdd(){
		return (myList.length <= noOfItems);
	}
	
	public int length(){
		return noOfItems;
	}
	
	public abstract boolean isOnList (Listable item);

	public abstract Listable get(Listable item);

	public abstract void put (Listable item);
	
	public abstract void remove (Listable item);

	
	public void reset(){
		cpos = 0;
	}
	
	public Listable getNextItem (){
	
	Listable next = myList[cpos];
	
	if (cpos == noOfItems-1)
		cpos = 0;
	else
		cpos++;
		return next.copy();
	}
}
