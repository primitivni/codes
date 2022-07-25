/**
 * Fronta operatoru
 */
class OperatorQueue {
	private Operator first;
	private Operator last;

	/**
	 * Metoda pro novy call
	 * @param call
	 */
	public void add(FreeOperator call) {
		Operator nl = new Operator();
		nl.data = call;
		
		if (first == null) {
			first = nl;
			last = nl;
		} else {
			last.next = nl;
			last = nl;
		}
	}

	/**
	 * Metoda pro ziskani volneho operatora
	 * @return
	 */
	public FreeOperator get() {
		if (first == null) {
			return null;
		} else {
			return first.data;
		}
	}
	
	public void removeFirst() {
		if (first != null) {
			first = first.next;
		} else {
			System.out.println("Remove call on empty queue. Probably error, continuing...");
		}
	}
}
