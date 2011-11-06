/**
	LoaderState.java
	(C) Giovanni Capuano 2011
*/
public class LoaderState {
	public static final int START = 0;
	public static final int MODULE = 1;
	public static final int RESOURCE = 2;
	public static final int DONE = 3;
	public static final int EXCEPTION = 4;
	public static final int LOADERS = 5;
	public int code;
	public int n = 0;
	public int total = 0;
	public boolean module;
	public Object msg;
	
	public LoaderState(int code, Object msg, int n, int total) {
		this.code = code;
		this.msg = msg;
		this.n = n;
		this.total = total;
		this.module = true;
	}
	
	public LoaderState(int code, Object msg) {
		this.code = code;
		this.msg = msg;
		this.module = false;
	}
}
