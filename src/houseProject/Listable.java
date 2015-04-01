package houseProject;

public interface Listable {
	
	public abstract int compareTo(Listable anything);
	
	public abstract Listable copy();
}
