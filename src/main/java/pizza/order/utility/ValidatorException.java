package pizza.order.utility;

public class ValidatorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String validationMessage;

	public ValidatorException() {

	}

	public ValidatorException(String validationMessage) {
		super();
		this.validationMessage = validationMessage;
	}

	public String getValidationMessage() {
		return validationMessage;
	}

	public void setValidationMessage(String validationMessage) {
		this.validationMessage = validationMessage;
	}

}
