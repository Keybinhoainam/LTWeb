package NHLStore.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import NHLStore.domain.CartItem;

public interface CartItemService {

	<S extends CartItem> List<S> findAll(Example<S> example, Sort sort);

	<S extends CartItem> List<S> findAll(Example<S> example);

	CartItem getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends CartItem> entities);

	CartItem getOne(Long id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	<S extends CartItem, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(CartItem entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	<S extends CartItem> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<CartItem> entities);

	<S extends CartItem> long count(Example<S> example);

	void deleteInBatch(Iterable<CartItem> entities);

	<S extends CartItem> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends CartItem> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Long id);

	<S extends CartItem> S saveAndFlush(S entity);

	void flush();

	<S extends CartItem> List<S> saveAll(Iterable<S> entities);

	Optional<CartItem> findById(Long id);

	List<CartItem> findAllById(Iterable<Long> ids);

	List<CartItem> findAll(Sort sort);

	Page<CartItem> findAll(Pageable pageable);

	List<CartItem> findAll();

	<S extends CartItem> Optional<S> findOne(Example<S> example);

	<S extends CartItem> S save(S entity);

	

}
