package fr.iut2.tc4.projet;

import java.io.IOException;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.torque.Torque;
import org.apache.torque.TorqueException;
import org.apache.torque.util.Criteria;

import fr.iut2.tc4.projet.torque.*;


@SuppressWarnings("serial")
public class ServletInit extends GenericServlet {

	private static final String TORQUE_PROPS = new String("Torque.properties");

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
	}

	@SuppressWarnings("unchecked")
	@Override
	public void init() throws ServletException {
		super.init();

		// Initialisation de la connection Torque
		if (!Torque.isInit()) {
			try {

				PropertiesConfiguration pc = new PropertiesConfiguration();
				pc.load(this.getClass().getClassLoader().getResourceAsStream(
						TORQUE_PROPS));
				Torque.init(pc);

			} catch (ConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TorqueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		// ATTENTION :
		// Ci-desssous des exemples d'utilisation de Torque en vue de cr�er, modifier, 
		// supprimer, rechercher des �l�ments dans une BD
		// Nous vous demandons pour la suite de supprimer ou commenter ce code 
		// qui ne doit pas apparaitre dans la servlet d'initialisation de la connection Torque
		
//		try {
//
//			if (BookPeer.doSelectAll().size() == 0) {
//				// Create publisher
//				Publisher addison = new Publisher();
//				addison.setName("Addison Wesley Professional");
//				addison.save();
//
//				// Create Author
//				Author bloch = new Author();
//				bloch.setFirstName("Joshua");
//				bloch.setLastName("Bloch");
//				bloch.save();
//
//				// Create Author
//				// An alternative method to inserting rows in your database.
//				Author stevens = new Author();
//				stevens.setFirstName("W.");
//				stevens.setLastName("Stevens");
//				AuthorPeer.doInsert(stevens);
//
//				// Create Book
//				// Using the convenience methods to handle the foreign keys.
//				Book effective = new Book();
//				effective.setTitle("Effective Java");
//				effective.setISBN("0-618-12902-2");
//				effective.setPublisher(addison);
//				effective.setAuthor(bloch);
//				effective.save();
//
//				// Create Book
//				// Inserting the foreign-keys manually.
//				Book tcpip = new Book();
//				tcpip.setTitle("TCP/IP Illustrated, Volume 1");
//				tcpip.setISBN("0-201-63346-9");
//				tcpip.setPublisherId(addison.getPublisherId());
//				tcpip.setAuthorId(stevens.getAuthorId());
//				tcpip.save();
//
//				/*
//				 * Selecting all books from the database and printing the
//				 * results to stdout using our helper method defined in BookPeer
//				 * (doSelectAll).
//				 */
//				System.out.println("Booklist :");
//				List<Book> bookList = BookPeer.doSelectAll();
//				printBookList(bookList);
//
//				/*
//				 * Selecting specific objects. Just search for objects that
//				 * match this criteria (and print to stdout).
//				 */
//				System.out.println("Booklist (specific ISBN) :");
//				Criteria crit = new Criteria();
//				crit.add(BookPeer.ISBN, "0-201-63346-9");
//				bookList = BookPeer.doSelect(crit);
//				printBookList(bookList);
//
//				/*
//				 * Updating data. These lines will swap the authors of the two
//				 * books.
//				 */
//				effective.setAuthor(stevens);
//				effective.save();
//
//				tcpip.setAuthor(bloch);
//				BookPeer.doUpdate(tcpip);
//
//				System.out.println("Booklist (authors swapped) :");
//				bookList = BookPeer.doSelectAll();
//				printBookList(bookList);
//
//				// Create reader1
//				Reader reader1 = new Reader();
//				reader1.setName("reader1");
//				ReaderPeer.doInsert(reader1);
//
//				// Create reader1
//				Reader reader2 = new Reader();
//				reader2.setName("reader2");
//				ReaderPeer.doInsert(reader2);
//
//				// Relation n-m
//				Reference reference1 = new Reference();
//				reference1.setBook(effective);
//				reference1.setReader(reader1);
//				reference1.save();
//
//				Reference reference2 = new Reference();
//				reference2.setBook(effective);
//				reference2.setReader(reader2);
//				ReferencePeer.doInsert(reference2);
//
//				Reference reference3 = new Reference();
//				reference3.setBook(tcpip);
//				reference3.setReader(reader1);
//				reference3.save();
//
//				Reference reference4 = new Reference();
//				reference4.setBook(tcpip);
//				reference4.setReader(reader2);
//				ReferencePeer.doInsert(reference4);
//
//				System.out.println("Effective reader : ");
//				for (Reader reader : effective.getReaders()) {
//					System.out.println(" " + reader.getName());
//				}
//
//				System.out.println("Reader 1 Book : ");
//				for (Book book : reader1.getBooks()) {
//					System.out.println(" " + book.getTitle());
//				}
//
////				/*
////				 * Deleting data. These lines will delete the data that matches
////				 * the specified criteria.
////				 */
////				crit = new Criteria();
////				crit.add(BookPeer.ISBN, "0-618-12902-2");
////				BookPeer.doDelete(crit);
////
////				crit = new Criteria();
////				crit.add(BookPeer.ISBN, "0-201-63346-9");
////				crit.add(BookPeer.TITLE, "TCP/IP Illustrated, Volume 1");
////				BookPeer.doDelete(crit);
////
////				/*
////				 * Deleting data by passing Data Objects instead of specifying
////				 * criteria.
////				 */
////				AuthorPeer.doDelete(bloch);
////				AuthorPeer.doDelete(stevens);
////				PublisherPeer.doDelete(addison);
////
////				ReferencePeer.doDeleteAll();
////				ReaderPeer.doDeleteAll();
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

//	private void printBookList(List<Book> bookList) {
//		try {
//			for (Book book : bookList) {
//				System.out.println("Title: " + book.getTitle());
//				System.out.println("ISBN:  " + book.getISBN());
//				System.out.println("Publisher: " + book.getBookId() + " "
//						+ book.getPublisher().getName());
//				System.out.println("Author: " + book.getAuthor().getLastName()
//						+ ", " + book.getAuthor().getFirstName() + "\n");
//			}
//			System.out.println();
//
//		} catch (TorqueException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
