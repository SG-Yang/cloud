package com.ahb.common.region;

import com.ahb.common.Conf;
import com.ahb.common.ConfImpl;
import com.ahb.common.domain.Domain;
import com.google.gson.Gson;
import org.xerial.snappy.Snappy;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by aheroboy on 17/3/2018.
 */
public class StoreImpl implements Store {

    public enum StoreHolder {
        INSTANCE;
       public Store store;

        StoreHolder() {
            Conf storeConf = new ConfImpl();
            store = new StoreImpl(storeConf);
        }

    }

    @Override
    public Collection<Domain> getAll() {
        return Collections.EMPTY_LIST;
    }

    private StoreImpl(Conf conf) {
    }

    public StoreImpl(){}
    @Override
    public void save(Domain domain) {
        try {
            Gson gson = new Gson();
            String strs = gson.toJson(domain);
            System.out.println(strs);
            byte[] str = strs.getBytes();
            System.out.println(str.length);
            byte[] compressed = Snappy.compress(gson.toJson(domain));
            System.out.println(compressed.length);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Domain get(String domainId) {
        return null;
    }
}