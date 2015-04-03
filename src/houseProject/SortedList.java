package houseProject;

public class SortedList extends List {
	public SortedList(int max) {
		super(max);
	}
	
	public SortedList() {
		super(100);
	}

	@Override
	public boolean isOnList(Listable item) {
		// TODO Auto-generated method stub
		int compareResult;
		int midPoint;
		int first = 0;
		int last = noOfItems - 1;
		boolean moreToSearch = (first <= last);
		boolean found = false;
		
		while (moreToSearch && !found){
			midPoint = (first + last) / 2;
			compareResult = item.compareTo(myList[midPoint]);
		
			if (compareResult == 0)
				found = true;
			else if (compareResult < 0){
				last = midPoint - 1;
				moreToSearch = (first <= last);
			}
			else{
				first = midPoint + 1;
				moreToSearch = (first <= last);
			}
		}
		return found;
	}

	@Override
	public Listable get(Listable item) {
		// TODO Auto-generated method stub
		int compareResult;
		int first = 0;
		int last = noOfItems - 1;
		int midPoint = (first + last) / 2;
		boolean found = false;
		
		while (!found){
		
			midPoint = (first + last) / 2;
			compareResult = item.compareTo(myList[midPoint]);
			
			if (compareResult == 0)
				found = true;
			else if (compareResult < 0) 
				last = midPoint - 1;
			else
				first = midPoint + 1;
		}
		return myList[midPoint].copy();
	}

	@Override
	public void put(Listable item) {
		// TODO Auto-generated method stub
		int location = 0;
		boolean moreToSearch = (location < noOfItems);
		while (moreToSearch){
			if (item.compareTo(myList[location]) < 0) 
				moreToSearch = false;
			else{
				location++;
				moreToSearch = (location < noOfItems);
			}
		}
		for (int index = noOfItems; index > location; index--)
			myList[index] = myList[index - 1];
		myList[location] = item.copy();
		noOfItems++;
	}

	@Override
	public void remove(Listable item) {
		// TODO Auto-generated method stub
		int location = 0;
		while (item.compareTo(myList[location]) != 0)
			location++;
		
		for (int index = location + 1; index < noOfItems; index++)
			myList[index - 1] = myList[index];
		noOfItems--;
	}
}
