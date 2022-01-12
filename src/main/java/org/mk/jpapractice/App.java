package org.mk.jpapractice;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.mk.jpapractice.domain.BankAccount;


/**
 * JPA Hello world!
 *
 */

public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory entityManagerFactory = null;
    	EntityManager entityManager = null;
    	EntityTransaction entityTransaction = null;
        
    	try {
    		entityManagerFactory = Persistence.createEntityManagerFactory("jpa-maven");
    		entityManager = entityManagerFactory.createEntityManager();
    		entityTransaction = entityManager.getTransaction();
    		entityTransaction.begin();
    		
    		// Add Object BankAccount
    		
    		BankAccount bankAccount = new BankAccount();
    		
    		//bankAccount.setId(10);
    		bankAccount.setName("Michel");
    		bankAccount.setSalary(1532);
    		
    		entityManager.persist(bankAccount);
    		
    		entityTransaction.commit();
    		
    		Query q = entityManager.createQuery("select s from Bank s");

			List<BankAccount> resultList = q.getResultList();
			System.out.println("num of banck account:" + resultList.size());
			for (BankAccount next : resultList) {
				System.out.println("next bank account: " + next);
				
			}
			
			 BankAccount ba = entityManager.find(BankAccount.class, 1);
			 System.out.println("le resultat est: " + ba);

		} catch (Exception e) {
			System.out.println(e);
			entityTransaction.rollback();
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
    }
}
