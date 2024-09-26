package org.example.bo;

import org.example.bo.customer.IMPL.CustomerBoImpl;
import org.example.bo.customer.IMPL.ItemBoImpl;

import static com.sun.java.accessibility.util.EventID.ITEM;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){
    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BOFactory() : boFactory;
    }

    public enum BOTypes{
        CUSTOMER,ITEM
    }


    public SuperBo getBO(BOTypes types){
        switch (types){
            case CUSTOMER:
                return new CustomerBoImpl();
            case ITEM:
                return new ItemBoImpl();
            default:
                return null;
        }
    }
}
