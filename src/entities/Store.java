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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Store store = (Store) o;
        return storeName.equals(store.storeName) && cnpj.equals(store.cnpj) && ownerCpf.equals(store.ownerCpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), storeName, cnpj, ownerCpf);
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeName='" + storeName + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", ownerCpf='" + ownerCpf + '\'' +
                "} " + super.toString();
    }
}
