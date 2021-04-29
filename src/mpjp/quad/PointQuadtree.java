package mpjp.quad;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import mpjp.shared.HasPoint;

public class PointQuadtree<T extends HasPoint> implements Iterable<T> {
	Trie<T> top;
	
	public PointQuadtree(double width,double height) {
		this(0, height, width,0);
	}
	public PointQuadtree(double width,	double height,double margin) {
		this(-margin, height+margin, width+margin,-margin);
	}
	
	public PointQuadtree(double topLeftX, double topLeftY, double bottomRightX,	double bottomRightY) {
		this.top=new LeafTrie<T>(topLeftX,topLeftY,bottomRightX,bottomRightY);	
	}
	
	private boolean verificar(double x, double y) {
		return (x <= top.bottomRightX && 
		   x >= top.topLeftX && 
		   y <= top.topLeftY && 
		   y >= top.bottomRightY);
	}
	
	public T find​(T point) {
		if(verificar(point.getX(), point.getY()))
			return this.top.find(point);
		return null;
	}
	public void insert​(T point) {
		if(verificar(point.getX(), point.getY()))
			this.top=top.insert(point);
		else {
			throw new PointOutOfBoundException();
		}
	}
	public void insertReplace​(T point) {
		if(verificar(point.getX(), point.getY()))
			top=this.top.insertReplace(point);	
		else {
			throw new PointOutOfBoundException();
		}
	}
	public Set<T> findNear​(double x, double y,double radius){
		Set<T> pontos= new HashSet<T>();
		this.top.collectNear(x, y, radius, pontos);
		return pontos;
	}
	
	public void delete​(T point) {
		if(verificar(point.getX(), point.getY()))
			this.top.delete(point);
	}
	
	public Set<T> getAll(){
		Set<T> pontos= new HashSet<T>();
		this.top.collectAll(pontos);
		return pontos;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new PointIterator();
	}
	
	class PointIterator implements Iterator<T>, Runnable, Visitor<T>{
		T nextPoint;
		boolean terminated;
		Thread thread;

		public PointIterator() {
			thread=new Thread(this, "Point iterator");
			thread.start();
		}
		
		@Override
		public boolean hasNext() {
			synchronized (this) {
				if(!terminated)
					handshake();
			}
			return nextPoint !=null;
		}
		
		@Override
		public T next() {
			var p = this.nextPoint;
			synchronized(this){
				this.nextPoint=null;
			}
			return p;
		}
		
		@Override
		public void run() {
			this.terminated=false;
			top.accept(this);
			synchronized(this) {
				this.terminated=true;
				handshake();
			}
		}
		
		@Override
		public void visit(LeafTrie<T> leaf) {
			for(T p: leaf.getPoints()) {
				synchronized(this) {
					if(nextPoint!=null)
						handshake();
					nextPoint=p;
					handshake();
				}
			}
		}

		private void handshake() {
			notify();
			try {
				wait();
			}catch (InterruptedException cause){
				throw new RuntimeException("Unexpected interruption while waiting", cause);
			}
			
		}

		@Override
		public void visit(NodeTrie<T> node) {
			for(Trie<T> q:node.getTries()) {
				q.accept(this);
			}
			
		}
		
	}

}
