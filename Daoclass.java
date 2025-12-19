package org.example;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class Daoclass {

    @Autowired
    private JdbcTemplate jd;

    //Create table
    public void createTable(){
        String sql="create table student (" +
                "id int,"+
                "name varchar(20),"+
                "age int)";
        jd.execute(sql);
    }

    //Select all values
    public List<Map<String,Object>> selectAll(){
        String sql="select * from student";
        return jd.queryForList(sql);
    }

    public Map<String,Object> selectOne(int id){
        String sql="select * from student where id=?";
        return jd.queryForMap(sql,id);
    }

    //Insert values
    public void insertValues(Student student){
        String sql="insert into student (id,name,age) values (?,?,?)";
        jd.update(sql,student.getId(),student.getName(),student.getAge());

    }

    // Update values
    public void updateValues(String name,int id){
        String sql="update student set name=? where id=?";
        jd.update(sql,name,id);
    }

    //Delete values
    public void deleteValues(int id){
        String sql= "delete from student where id=?";
        jd.update(sql,id);
    }

}
