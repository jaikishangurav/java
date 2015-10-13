package callback.example2;

public class Caller {
	 public void register(CallBack callback) {
	        callback.methodToCallBack();
	    }

	    public static void main(String[] args) {
	        Caller caller = new Caller();
	        CallBack callBack = new CallBackImpl();
	        caller.register(callBack);
	    }
}
