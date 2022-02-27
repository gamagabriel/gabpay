package entities.builders;

import entities.Store;

public class StoreBuilder {

    private String id;
    private String ownerName;
    private String email;
    private Long phoneNumber;
    private Double balance;
    private String storeName;
    private String cnpj;
    private String ownerCpf;

    public StoreBuilder id(String id){
        this.id = id;
        return this;
    }

    public StoreBuilder ownerName(String ownerName){
        this.ownerName = ownerName;
        return this;
    }

    public StoreBuilder email(String email){
        this.email = email;
        return this;
    }

    public StoreBuilder phoneNumber(Long phoneNumber){
        this.phoneNumber = phoneNumber;
        return this;
    }

    public StoreBuilder balance(Double balance){
        this.balance = balance;
        return this;
    }

    public StoreBuilder storeName(String storeName){
        this.storeName = storeName;
        return this;
    }

    public StoreBuilder cnpj(String cnpj){
        this.cnpj = cnpj;
        return this;
    }

    public StoreBuilder ownerCpf(String ownerCpf){
        this.ownerCpf = ownerCpf;
        return this;
    }

    public Store build(){
        return new Store(id, ownerName, email, phoneNumber, balance, storeName, cnpj, ownerCpf);
    }
}
