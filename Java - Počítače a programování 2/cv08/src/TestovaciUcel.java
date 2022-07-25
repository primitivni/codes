/**
 * Trida pro testovaci ucely
 */
public class TestovaciUcel {
	public static void main(String[] args) throws Exception {
        LinkList myList = new LinkList();
		MyIterator myIter1 = new MyIterator(myList);
		MyIterator myIter2 = new MyIterator(myList);
		
		myIter1.moveToFirst();
		myIter1.insert('a');
		myIter2.printList();
		myIter1.insert('k');
		myIter2.printList();
		myIter1.insert('l'); 
		myIter2.printList();
		myIter1.next();
		myIter1.insert('a');
		myIter2.printList();
		myIter1.next();
		myIter1.insert('s');
		
		myIter1.printList();
		
		myIter1.moveToFirst();
		myIter1.insert('v');
		myIter2.printList();
		myIter1.insert('i');
		myIter2.printList();
		myIter1.insert('p');
		myIter2.printList();
		myIter1.next();
		myIter1.next();
		myIter1.next();
		myIter1.remove();
		myIter2.printList();
		myIter1.remove();
		myIter2.printList();
		myIter1.remove();
		myIter2.printList();
		myIter1.remove();
		myIter2.printList();
		myIter1.insert('o');
		myIter2.printList();
		myIter1.next();
		myIter1.remove();

		myIter1.printList();
		
		/*myList.insert('a');
		myList.insert('k');
		myList.insert('l');
		myList.next();
		myList.insert('a');
		myList.next();
		myList.insert('s');
			
		printList(myList);
		
		myList.moveToFirst();
		myList.insert('v');
		myList.insert('i');
		myList.insert('p');
		myList.next();
		myList.next();
		myList.next();
		myList.remove();
		myList.remove();
		myList.remove();
		myList.remove();
		myList.insert('o');
		myList.next();
		myList.remove();

		printList(myList);*/
		
		/*myIter.moveToFirst();
		myIter.insert('a');
		myIter.insert('k');
		myIter.insert('s'); 
		myIter.insert('a'); 
		myIter.insert('l'); 
		myIter.next();
		myIter.next();
		myIter.next();
		myIter.next();
		myIter.next();
		
		myIter.printList();
		
		myIter.moveToFirst();
		myIter.insert('o');
		myIter.insert('v'); 
		myIter.insert('i');
		myIter.insert('p');
		myIter.next();
		myIter.next();
		myIter.next();
		myIter.next();
		myIter.remove();
		myIter.remove();
		myIter.remove();
		myIter.remove();
		myIter.remove();

		myIter.printList();*/
	}
}
