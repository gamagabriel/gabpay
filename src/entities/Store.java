package entities;

import entities.builders.StoreBuilder;

public class Store extends User{
    private String storeName;
    private String cnpj;
    private String ownerCpf;

    public Store() {}

    public Store(String id, String ownerName, String email, Long phoneNumber, Double balance, String storeName, String cnpj, String ownerCpf) {
        super(id, ownerName, email, phoneNumber, balance);
        this.storeName = storeName;
        this.cnpj = cnpj;
        this.ownerCpf = ownerCpf;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getOwnerCpf() {
        return ownerCpf;
    }

    public void setOwnerCpf(String ownerCpf) {
        this.ownerCpf = ownerCpf;
    }

    public static StoreBuilder builder(){
        return new StoreBuilder();
    }

    @Override
    public String toString() {
        return  super.toString() + ","
                + storeName + ","
                + cnpj + ","
                + ownerCpf;
    }
}
