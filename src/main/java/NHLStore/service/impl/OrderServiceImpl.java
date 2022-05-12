package NHLStore.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import NHLStore.domain.Order;
import NHLStore.reponsitory.OrderResponsitory;
import NHLStore.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService{
	OrderResponsitory orderResponsitory;

	public OrderServiceImpl(OrderResponsitory orderResponsitory) {
		super();
		this.orderResponsitory = orderResponsitory;
	}

	@Override
	public <S extends Order> S save(S entity) {
		return orderResponsitory.save(entity);
	}

	@Override
	public <S extends Order> Optional<S> findOne(Example<S> example) {
		return orderResponsitory.findOne(example);
	}

	@Override
	public List<Order> findAll() {
		return orderResponsitory.findAll();
	}

	@Override
	public Page<Order> findAll(Pageable pageable) {
		return orderResponsitory.findAll(pageable);
	}

	@Override
	public List<Order> findAll(Sort sort) {
		return orderResponsitory.findAll(sort);
	}

	@Override
	public List<Order> findAllById(Iterable<Long> ids) {
		return orderResponsitory.findAllById(ids);
	}

	@Override
	public Optional<Order> findById(Long id) {
		return orderResponsitory.findById(id);
	}

	@Override
	public <S extends Order> List<S> saveAll(Iterable<S> entities) {
		return orderResponsitory.saveAll(entities);
	}

	@Override
	public void flush() {
		orderResponsitory.flush();
	}

	@Override
	public <S extends Order> S saveAndFlush(S entity) {
		return orderResponsitory.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return orderResponsitory.existsById(id);
	}

	@Override
	public <S extends Order> List<S> saveAllAndFlush(Iterable<S> entities) {
		return orderResponsitory.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Order> Page<S> findAll(Example<S> example, Pageable pageable) {
		return orderResponsitory.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Order> entities) {
		orderResponsitory.deleteInBatch(entities);
	}

	@Override
	public <S extends Order> long count(Example<S> example) {
		return orderResponsitory.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Order> entities) {
		orderResponsitory.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return orderResponsitory.count();
	}

	@Override
	public <S extends Order> boolean exists(Example<S> example) {
		return orderResponsitory.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		orderResponsitory.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		orderResponsitory.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Order entity) {
		orderResponsitory.delete(entity);
	}

	@Override
	public <S extends Order, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return orderResponsitory.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		orderResponsitory.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		orderResponsitory.deleteAllInBatch();
	}

	@Override
	public Order getOne(Long id) {
		return orderResponsitory.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Order> entities) {
		orderResponsitory.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		orderResponsitory.deleteAll();
	}

	@Override
	public Order getById(Long id) {
		return orderResponsitory.getById(id);
	}

	@Override
	public <S extends Order> List<S> findAll(Example<S> example) {
		return orderResponsitory.findAll(example);
	}

	@Override
	public <S extends Order> List<S> findAll(Example<S> example, Sort sort) {
		return orderResponsitory.findAll(example, sort);
	}
	
}
