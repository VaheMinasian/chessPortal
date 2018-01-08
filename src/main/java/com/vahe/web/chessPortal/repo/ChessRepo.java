package com.vahe.web.chessPortal.repo;

import javax.inject.Inject; 
import javax.persistence.EntityManager; 
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

import static javax.transaction.Transactional.TxType.*;

import java.util.List;

import com.vahe.web.chessPortal.model.Chess;
import com.vahe.web.chessPortal.util.TextUtil;

@Transactional(SUPPORTS)
public class ChessRepo {

	@PersistenceContext(unitName="PersistChess")
	private EntityManager em;
	
	@Inject
    private TextUtil textUtil;
	
	public List<Chess> findAll(){
		TypedQuery<Chess> query = em.createQuery("Select cs from Chess cs order by cs.name", Chess.class);
		return query. getResultList();
		}
	
	public Long countAll(){
		TypedQuery<Long> query = em.createQuery("Select count(cs) from Chess cs", Long.class);
		return query.getSingleResult();
		} 
	
	public Chess find(@NotNull Long id) {
		return em.find(Chess.class, id);
	}
	@Transactional(REQUIRED)
	public Chess create(@NotNull Chess chess) {
        chess.setName(textUtil.sanitize(chess.getName()));
		em.persist(chess);
		return chess;
	}
	@Transactional(REQUIRED)
	public void delete(@NotNull Chess id) {
		em.remove(em.getReference(Chess.class, id));
	}
}
