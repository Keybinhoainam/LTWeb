package NHLStore.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import NHLStore.domain.Account;
import NHLStore.reponsitory.AcountRepository;
import NHLStore.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
    private AcountRepository acountRepository;
    // @Override
	// public Account login(String username, String password)
    // {
    //     Optional<Account> optExist=findByUsername(username);
	// 	System.out.println(optExist.get().getPassword());
	// 	System.out.println(optExist.isPresent());
	// 	// System.out.println(Optional);
    //     if(optExist.isPresent() && bCryptPasswordEncoder.matches(password, optExist.get().getPassword()))
    //     {
	// 		System.out.println("password "+optExist.get().getPassword());
    //         optExist.get().setPassword("");
    //         return optExist.get();
    //     }
    //     return null;
    // }
	
	
	
	@Override
	public <S extends Account> S save(S entity) {
		return acountRepository.save(entity);
	}

	public Optional<Account> findByUserName(String name) {
		return acountRepository.findByUserName(name);
	}

	@Override
	public <S extends Account> Optional<S> findOne(Example<S> example) {
		return acountRepository.findOne(example);
	}

	@Override
	public List<Account> findAll() {
		return acountRepository.findAll();
	}

	@Override
	public Page<Account> findAll(Pageable pageable) {
		return acountRepository.findAll(pageable);
	}

	@Override
	public List<Account> findAll(Sort sort) {
		return acountRepository.findAll(sort);
	}

	@Override
	public List<Account> findAllById(Iterable<Long> ids) {
		return acountRepository.findAllById(ids);
	}

	@Override
	public Optional<Account> findById(Long id) {
		return acountRepository.findById(id);
	}

	@Override
	public <S extends Account> List<S> saveAll(Iterable<S> entities) {
		return acountRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		acountRepository.flush();
	}

	@Override
	public <S extends Account> S saveAndFlush(S entity) {
		return acountRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return acountRepository.existsById(id);
	}

	@Override
	public <S extends Account> List<S> saveAllAndFlush(Iterable<S> entities) {
		return acountRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Account> Page<S> findAll(Example<S> example, Pageable pageable) {
		return acountRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Account> entities) {
		acountRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Account> long count(Example<S> example) {
		return acountRepository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Account> entities) {
		acountRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return acountRepository.count();
	}

	@Override
	public <S extends Account> boolean exists(Example<S> example) {
		return acountRepository.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		acountRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		acountRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Account entity) {
		acountRepository.delete(entity);
	}

	@Override
	public <S extends Account, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return acountRepository.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		acountRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		acountRepository.deleteAllInBatch();
	}

	@Override
	public Account getOne(Long id) {
		return acountRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Account> entities) {
		acountRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		acountRepository.deleteAll();
	}

	@Override
	public Account getById(Long id) {
		return acountRepository.getById(id);
	}

	@Override
	public <S extends Account> List<S> findAll(Example<S> example) {
		return acountRepository.findAll(example);
	}

	@Override
	public <S extends Account> List<S> findAll(Example<S> example, Sort sort) {
		return acountRepository.findAll(example, sort);
	}
	

}