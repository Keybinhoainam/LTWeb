package NHLStore.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import NHLStore.domain.CartItem;
import NHLStore.reponsitory.CartItemResponsitory;
import NHLStore.service.CartItemService;
@Service
public class CartItemServiceImpl implements CartItemService{
	@Autowired
	CartItemResponsitory cartItemResponsitory;

	public CartItemServiceImpl(CartItemResponsitory cartItemResponsitory) {
		super();
		this.cartItemResponsitory = cartItemResponsitory;
	}

	

	@Override
	public void DeleteCartItem(Long id) {
		cartItemResponsitory.DeleteCartItem(id);
	}



	@Override
	public <S extends CartItem> S save(S entity) {
		return cartItemResponsitory.save(entity);
	}

	@Override
	public List<CartItem> findCartItem(Long id) {
		return cartItemResponsitory.findCartItem(id);
	}

	@Override
	public <S extends CartItem> Optional<S> findOne(Example<S> example) {
		return cartItemResponsitory.findOne(example);
	}

	@Override
	public List<CartItem> findAll() {
		return cartItemResponsitory.findAll();
	}

	@Override
	public Page<CartItem> findAll(Pageable pageable) {
		return cartItemResponsitory.findAll(pageable);
	}

	@Override
	public List<CartItem> findAll(Sort sort) {
		return cartItemResponsitory.findAll(sort);
	}

	@Override
	public List<CartItem> findAllById(Iterable<Long> ids) {
		return cartItemResponsitory.findAllById(ids);
	}

	@Override
	public Optional<CartItem> findById(Long id) {
		return cartItemResponsitory.findById(id);
	}

	@Override
	public <S extends CartItem> List<S> saveAll(Iterable<S> entities) {
		return cartItemResponsitory.saveAll(entities);
	}

	@Override
	public void flush() {
		cartItemResponsitory.flush();
	}

	@Override
	public <S extends CartItem> S saveAndFlush(S entity) {
		return cartItemResponsitory.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return cartItemResponsitory.existsById(id);
	}

	@Override
	public <S extends CartItem> List<S> saveAllAndFlush(Iterable<S> entities) {
		return cartItemResponsitory.saveAllAndFlush(entities);
	}

	@Override
	public <S extends CartItem> Page<S> findAll(Example<S> example, Pageable pageable) {
		return cartItemResponsitory.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<CartItem> entities) {
		cartItemResponsitory.deleteInBatch(entities);
	}

	@Override
	public <S extends CartItem> long count(Example<S> example) {
		return cartItemResponsitory.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<CartItem> entities) {
		cartItemResponsitory.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return cartItemResponsitory.count();
	}

	@Override
	public <S extends CartItem> boolean exists(Example<S> example) {
		return cartItemResponsitory.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		cartItemResponsitory.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		cartItemResponsitory.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(CartItem entity) {
		cartItemResponsitory.delete(entity);
	}

	@Override
	public <S extends CartItem, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return cartItemResponsitory.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		cartItemResponsitory.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		cartItemResponsitory.deleteAllInBatch();
	}

	@Override
	public CartItem getOne(Long id) {
		return cartItemResponsitory.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends CartItem> entities) {
		cartItemResponsitory.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		cartItemResponsitory.deleteAll();
	}

	@Override
	public CartItem getById(Long id) {
		return cartItemResponsitory.getById(id);
	}

	@Override
	public <S extends CartItem> List<S> findAll(Example<S> example) {
		return cartItemResponsitory.findAll(example);
	}

	@Override
	public <S extends CartItem> List<S> findAll(Example<S> example, Sort sort) {
		return cartItemResponsitory.findAll(example, sort);
	}

	
}
