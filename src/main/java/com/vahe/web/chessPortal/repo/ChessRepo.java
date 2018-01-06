package com.vahe.web.chessPortal.repo;

import javax.persistence.EntityManager; 
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import static javax.transaction.Transactional.TxType.*;

import java.util.List;

import com.vahe.web.chessPortal.model.Chess;

@Transactional(SUPPORTS)
public class ChessRepo {

	@PersistenceContext(unitName="PersistChess")
	private EntityManager em;
	
	public List<Chess> findAll(){
		TypedQuery<Chess> query = em.createQuery("Select cs from Chess cs order by cs.name", Chess.class);
		return query. getResultList();
		}
	
	public Long countAll(){
		TypedQuery<Long> query = em.createQuery("Select count(cs) from Chess cs", Long.class);
		return query.getSingleResult();
		} 
	
	public Chess find(Long id) {
		return em.find(Chess.class, id);
	}
	@Transactional(REQUIRED)
	public Chess create(Chess chess) {
		em.persist(chess);
		return chess;
	}
	@Transactional(REQUIRED)
	public void delete(Chess id) {
		em.remove(em.getReference(Chess.class, id));
	}
}
