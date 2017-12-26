package com.vahe.web.chessPortal.repo;

import javax.persistence.EntityManager; 
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static javax.transaction.Transactional.TxType.*;

import com.vahe.web.chessPortal.model.ChessSet;

@Transactional(SUPPORTS)
public class ChessRepo {

	@PersistenceContext(unitName="PersistChess")
	private EntityManager em;
	public ChessSet find(Long id) {
		return em.find(ChessSet.class, id);
	}
	@Transactional(REQUIRED)
	public ChessSet create(ChessSet chessSet) {
		em.persist(chessSet);
		return chessSet;
	}
	@Transactional(REQUIRED)
	public void delete(ChessSet id) {
		em.remove(em.getReference(ChessSet.class, id));
	}
}
