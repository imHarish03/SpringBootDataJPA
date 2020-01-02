package lab.spring.data.rest.exception;

public class RecordNotFoundException extends RuntimeException {

	public RecordNotFoundException(String exception) {
		super(exception);
	}
}
