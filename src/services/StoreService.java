package services;

import entities.Store;
import repositories.RepositoryException;
import repositories.StoreRepository;
import utils.IdGenerator;

import java.util.List;

public class StoreService {

    private final StoreRepository repository;

    public StoreService() {
        this.repository = StoreRepository.factory();
    }

    public List<Store> findAll(){
        return repository.findAll();
    }

    public Store findById(String id){
        return repository.findById(id);
    }
    
    public Store findByCnpj(String cnpj) {
    	return repository.findByCnpj(cnpj);
    }

    public Store save(Store store){
        checkUniqueFields(store);
        checkNullFields(store);
        var id = IdGenerator.getRandomId();
        store.setId(id);
        repository.save(store);
        return findById(id);
    }

    public void deleteById(String id){
        repository.deleteById(id);
        return;
    }

    private void checkUniqueFields(Store store){
        var stores = findAll();
        for (Store s : stores) {
            if (s.getCnpj().equals(store.getCnpj())) throw new RepositoryException("CNPJ already exists in the data base");
            if (s.getStoreName().equals(store.getStoreName())) throw new RepositoryException("StoreName already exists in the data base");
            if (s.getEmail().equals(store.getEmail())) throw new RepositoryException("Email name already exists in the data base");
            if (s.getPhoneNumber().equals(store.getPhoneNumber())) throw new RepositoryException("PhoneNumber name already exists in the data base");
        }
    }

    private void checkNullFields(Store store){
        if (store.getPhoneNumber() == null) throw new RepositoryException("PhoneNumber can not be null");
        if (store.getEmail() == null) throw new RepositoryException("Email can not be null");
        if (store.getCnpj() == null) throw new RepositoryException("CPF can not be null");
        if (store.getStoreName() == null) throw new RepositoryException("StoreName can not be null");
        if (store.getOwnerCpf() == null) throw new RepositoryException("OwnerCpf name can not be null");
        if (store.getOwnerName() == null) throw new RepositoryException("OwnerName can not be null");
        if (store.getBalance() == null) throw new RepositoryException("Balance can not be null");
    }

}
