package com.example.Myproject.Service;

import com.example.Myproject.Entity.MyBookList;
import com.example.Myproject.Repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookService {
    @Autowired
    private MyBookRepository myBookRepository;
    public void saveMyBooks(MyBookList myBookList) {
        myBookRepository.save(myBookList);
    }

    public List<MyBookList> getMyBooks(){
        return myBookRepository.findAll();
    }

    public void deleteById(int id){
        myBookRepository.deleteById(id);
    }

}
