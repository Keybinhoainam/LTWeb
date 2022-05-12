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

import NHLStore.domain.Category;
import NHLStore.reponsitory.CategoryReposity;
import NHLStore.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{
	CategoryReposity categoryResposity;

	public CategoryServiceImpl(CategoryReposity categoryResposity) {
		this.categoryResposity = categoryResposity;
	}
	
	

	@Override
	public <S extends Category> S save(S entity) {
		return categoryResposity.save(entity);
	}

	

	@Override
	public List<Category> findByNameContaining(String name) {
		return categoryResposity.findByNameContaining(name);
	}



//	@Override
//	public Page<Category> findByNameContaining(String name, Pageable pageable) {
//		return categoryResposity.findByNameContaining(name, pageable);
//	}



	@Override
	public <S extends Category> Optional<S> findOne(Example<S> example) {
		return categoryResposity.findOne(example);
	}

	@Override
	public List<Category> findAll() {
		return categoryResposity.findAll();
	}

	@Override
	public Page<Category> findAll(Pageable pageable) {
		return categoryResposity.findAll(pageable);
	}

	@Override
	public List<Category> findAll(Sort sort) {
		return categoryResposity.findAll(sort);
	}

	@Override
	public List<Category> findAllById(Iterable<Long> ids) {
		return categoryResposity.findAllById(ids);
	}

	@Override
	public Optional<Category> findById(Long id) {
		return categoryResposity.findById(id);
	}

	@Override
	public <S extends Category> List<S> saveAll(Iterable<S> entities) {
		return categoryResposity.saveAll(entities);
	}

	@Override
	public void flush() {
		categoryResposity.flush();
	}

	@Override
	public <S extends Category> S saveAndFlush(S entity) {
		return categoryResposity.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return categoryResposity.existsById(id);
	}

	@Override
	public <S extends Category> List<S> saveAllAndFlush(Iterable<S> entities) {
		return categoryResposity.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Category> Page<S> findAll(Example<S> example, Pageable pageable) {
		return categoryResposity.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Category> entities) {
		categoryResposity.deleteInBatch(entities);
	}

	@Override
	public <S extends Category> long count(Example<S> example) {
		return categoryResposity.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Category> entities) {
		categoryResposity.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return categoryResposity.count();
	}

	@Override
	public <S extends Category> boolean exists(Example<S> example) {
		return categoryResposity.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		categoryResposity.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		categoryResposity.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Category entity) {
		categoryResposity.delete(entity);
	}

	@Override
	public <S extends Category, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return categoryResposity.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		categoryResposity.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		categoryResposity.deleteAllInBatch();
	}

	@Override
	public Category getOne(Long id) {
		return categoryResposity.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Category> entities) {
		categoryResposity.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		categoryResposity.deleteAll();
	}

	@Override
	public Category getById(Long id) {
		return categoryResposity.getById(id);
	}

	@Override
	public <S extends Category> List<S> findAll(Example<S> example) {
		return categoryResposity.findAll(example);
	}

	@Override
	public <S extends Category> List<S> findAll(Example<S> example, Sort sort) {
		return categoryResposity.findAll(example, sort);
	}

	
	
}
