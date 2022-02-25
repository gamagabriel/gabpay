package entities;

import java.util.Objects;

public class Store extends User{
    private String storeName;
    private String cnpj;
    private String ownerCpf;

    public Store() {}

    public Store(String ownerName, String email, Long phoneNumber, Double balance, String storeName, String cnpj, String ownerCpf) {
        super(ownerName, email, phoneNumber, balance);
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

    @Override
    public String toString() {
        return  super.toString() + ","
                + storeName + ","
                + cnpj + ","
                + ownerCpf;
    }
}
