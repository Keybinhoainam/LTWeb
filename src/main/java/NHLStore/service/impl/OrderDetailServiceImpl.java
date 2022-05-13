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

import NHLStore.domain.OrderDetail;
import NHLStore.reponsitory.OrderDetailResponsitory;
import NHLStore.service.OrderDetailService;
@Service
public class OrderDetailServiceImpl implements OrderDetailService{
	@Autowired
	OrderDetailResponsitory orderDetailResponsitory;

	public OrderDetailServiceImpl(OrderDetailResponsitory orderDetailResponsitory) {
		super();
		this.orderDetailResponsitory = orderDetailResponsitory;
	}

	@Override
	public <S extends OrderDetail> S save(S entity) {
		return orderDetailResponsitory.save(entity);
	}

	@Override
	public <S extends OrderDetail> Optional<S> findOne(Example<S> example) {
		return orderDetailResponsitory.findOne(example);
	}

	@Override
	public List<OrderDetail> findAll() {
		return orderDetailResponsitory.findAll();
	}

	@Override
	public Page<OrderDetail> findAll(Pageable pageable) {
		return orderDetailResponsitory.findAll(pageable);
	}

	@Override
	public List<OrderDetail> findAll(Sort sort) {
		return orderDetailResponsitory.findAll(sort);
	}

	@Override
	public List<OrderDetail> findAllById(Iterable<Long> ids) {
		return orderDetailResponsitory.findAllById(ids);
	}

	@Override
	public Optional<OrderDetail> findById(Long id) {
		return orderDetailResponsitory.findById(id);
	}

	@Override
	public <S extends OrderDetail> List<S> saveAll(Iterable<S> entities) {
		return orderDetailResponsitory.saveAll(entities);
	}

	@Override
	public void flush() {
		orderDetailResponsitory.flush();
	}

	@Override
	public <S extends OrderDetail> S saveAndFlush(S entity) {
		return orderDetailResponsitory.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return orderDetailResponsitory.existsById(id);
	}

	@Override
	public <S extends OrderDetail> List<S> saveAllAndFlush(Iterable<S> entities) {
		return orderDetailResponsitory.saveAllAndFlush(entities);
	}

	@Override
	public <S extends OrderDetail> Page<S> findAll(Example<S> example, Pageable pageable) {
		return orderDetailResponsitory.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<OrderDetail> entities) {
		orderDetailResponsitory.deleteInBatch(entities);
	}

	@Override
	public <S extends OrderDetail> long count(Example<S> example) {
		return orderDetailResponsitory.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<OrderDetail> entities) {
		orderDetailResponsitory.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return orderDetailResponsitory.count();
	}

	@Override
	public <S extends OrderDetail> boolean exists(Example<S> example) {
		return orderDetailResponsitory.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		orderDetailResponsitory.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		orderDetailResponsitory.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(OrderDetail entity) {
		orderDetailResponsitory.delete(entity);
	}

	@Override
	public <S extends OrderDetail, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return orderDetailResponsitory.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		orderDetailResponsitory.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		orderDetailResponsitory.deleteAllInBatch();
	}

	@Override
	public OrderDetail getOne(Long id) {
		return orderDetailResponsitory.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends OrderDetail> entities) {
		orderDetailResponsitory.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		orderDetailResponsitory.deleteAll();
	}

	@Override
	public OrderDetail getById(Long id) {
		return orderDetailResponsitory.getById(id);
	}

	@Override
	public <S extends OrderDetail> List<S> findAll(Example<S> example) {
		return orderDetailResponsitory.findAll(example);
	}

	@Override
	public <S extends OrderDetail> List<S> findAll(Example<S> example, Sort sort) {
		return orderDetailResponsitory.findAll(example, sort);
	}
	
}
