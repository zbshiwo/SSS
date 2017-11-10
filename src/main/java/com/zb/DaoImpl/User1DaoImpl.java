package com.zb.DaoImpl;

import com.zb.Dao.User1Dao;
import com.zb.model.User1;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Component("user1Dao")
@Transactional
public class User1DaoImpl extends HibernateDaoSupport implements User1Dao {
    public User1DaoImpl(){}

    @Override
    public void save(User1 user1) {
        this.getHibernateTemplate().save(user1);
    }

    @Override
    public User1 getUser1(String name) {
        String hql = "from User1 u where u.username = ?";
//        List user1List = this.getHibernateTemplate().find(hql, name);
        List a = this.getHibernateTemplate().find(hql, name);
        if(a.size() == 0){
            return null;
        }
        else return (User1) a.get(0);
    }

    @Override
    public void delete(int id) {
        this.getHibernateTemplate().delete(this.findById(id));
    }

    @Override
    public void update(User1 user1) {
        this.getHibernateTemplate().update(user1);
    }

    @Override
    public User1 findById(int id) {
        User1 user1 = (User1)this.getHibernateTemplate().get(User1.class, id);
        return user1;
    }

    @Override
    public List<User1> findAll() {
        String hql = "from User1";
        List user1List = this.getHibernateTemplate().find(hql);

        return user1List;
    }
//    public static void main(String[] args){
//        User1DaoImpl a = new User1DaoImpl();
//        List b = (List<Integer>)a.find();
////        List b = a.find();
//        for (int i = 0; i < b.size(); i++){
//            System.out.println(b.get(i));
//            System.out.println(b.get(i).getClass());
//        }
//    }
//    public List<?> find(){
//        List a = new ArrayList();
//        a.add(1);
//        a.add("qwe");
//        a.add(3);
//        return a;
//    }
}
