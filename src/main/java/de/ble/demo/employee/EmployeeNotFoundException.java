package de.ble.demo.employee;

class EmployeeNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7157106696443434854L;

	EmployeeNotFoundException(Long id) {
		super("Could not find employee " + id);
	}
}