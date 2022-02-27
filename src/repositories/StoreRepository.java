package repositories;

import entities.Store;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StoreRepository {

    private static final String path = System.getProperty("user.dir") + "/store";

    private void writeAll(List<Store> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (Store store : list) {
                bw.write(store.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Store> readAll() {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            List<Store> stores = new ArrayList<>();

            String line = br.readLine();

            String[] storeLine;

            String id;
            String ownerName;
            String email;
            long phoneNumber;
            double balance;
            String userName;
            String cnpj;
            String ownerCpf;

            while (line != null) {
                storeLine = line.split(",");

                id = storeLine[0];
                ownerName = storeLine[1];
                email = storeLine[2];
                phoneNumber = Long.parseLong(storeLine[3]);
                balance = Double.parseDouble(storeLine[4]);
                userName = storeLine[5];
                cnpj = storeLine[6];
                ownerCpf = storeLine[7];

                Store store = new Store(id, ownerName, email, phoneNumber, balance, userName, cnpj, ownerCpf);
                stores.add(store);

                line = br.readLine();

            }
            return stores;
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public List<Store> findAll() {
        return readAll();
    }

    public Store findById(String id) {
        List<Store> stores = readAll();
        Store store = null;
        for (Store object : stores) {
            if (object.getId().equals(id)) store = object;
        }
        if (store == null) throw new RepositoryException("Store dont found");
        return store;
    }

    public void saveAll(List<Store> list) {
        List<Store> stores = readAll();
        for (Store store : list) {
            if (stores.contains(store)) throw new RepositoryException("Store already exists on the data base");
            stores.add(store);
        }
        writeAll(stores);
    }

    public void save(Store store) {
        List<Store> stores = readAll();
        if (stores.contains(store)) throw new RepositoryException("Store already exists on the data base");
        stores.add(store);
        writeAll(stores);
    }

    public void deleteAll() {
        writeAll(new ArrayList<>());
    }

    public void delete(Store store) {
        List<Store> stores = readAll();
        if (!stores.contains(store)) throw new RepositoryException("Store dont found");
        stores.remove(store);
        writeAll(stores);
    }

    public void deleteById(String id) {
        List<Store> stores = readAll();
        stores.remove(findById(id));
        writeAll(stores);
    }

    public static StoreRepository factory(){
        return new StoreRepository();
    }


}
