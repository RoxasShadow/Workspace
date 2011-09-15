import org.python.util.PythonInterpreter;
import org.python.core.PyObject;
import org.python.core.PyException;

public class TestJyth {
	private final PythonInterpreter interpreter;
	
	public TestJyth() {
		interpreter = new PythonInterpreter();
		
		interpreter.set("string", "Hey Python, how are you?");
		interpreter.execfile("plugin.py");
		PyObject res = interpreter.get("res");
		System.out.println("Python says: "+res);
	}
	
	public static void main(String[] args) {
		new TestJyth();
	}
}
