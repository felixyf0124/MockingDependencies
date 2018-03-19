package point.of.sale;

public class ArrayStorage extends HashStorage {

	int size = 999;
	String[] array;
	public ArrayStorage() {
		array = new String[size];
	}
	
	public void forklift() {
		for (String barcode : hashMap.keySet()) {
			array[Integer.parseInt(barcode)] = hashMap.get(barcode);
		}
	}
	
	@Override
	public void loadStorage(String filename) {
		// TODO Auto-generated method stub
		super.loadStorage(filename);
	}

	@Override
	public void put(String barcode, String item) {
		// TODO Auto-generated method stub
		super.put(barcode, item);
	}

	@Override
	public String barcode(String barcode) {
		// TODO Auto-generated method stub
		return super.barcode(barcode);
	}

	@Override
	public void persistStorage(String filename) {
		// TODO Auto-generated method stub
		super.persistStorage(filename);
	}

	//new should be the same as the old
	public int checkConsistency() {
		int inconsistencies = 0;
		for (String barcode : hashMap.keySet()) {
			String expected = hashMap.get(barcode);
			String actual = array[Integer.parseInt(barcode)];
			if (!expected.equals(actual)) {
				inconsistencies++;
				violation(barcode, expected, actual);		
			}
		}
		return inconsistencies;
	}
	
	private void violation(String barcode, String expected, String actual) {
		System.out.println("Consistency Violation!\n" + 
				"barcode = " + barcode +
				"\n\t expected = " + expected
				+ "\n\t actual = " + actual);
	}

}
