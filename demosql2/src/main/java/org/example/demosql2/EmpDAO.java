package org.example.demosql2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {
    Connection c;
    Statement stmt;
    PreparedStatement ps;
    DB_Connection db;

    public EmpDAO(){
        db = new DB_Connection();
    }

    public void dropTable(){
        String sql="DROP TABLE `Emp` ;";
        c = db.get_connection();
        try {
            ps = c.prepareStatement(sql);
            ps.execute();
            c.close();
        }catch (Exception e){
            System.out.println("Erro no dropTable");
            e.printStackTrace();
        }
    }

    public void createTable(){
        c = db.get_connection();
        String sql="CREATE TABLE IF NOT EXISTS `Emp` (\n" +
                "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `name` varchar(100) NOT NULL,\n" +
                "  `salary` decimal(7,2) NOT NULL,\n" +
                "  `designation` varchar(100) NOT NULL,\n" +
                "  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
                "  PRIMARY KEY (`id`)\n" +
                ") ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;";
        try {
            ps = c.prepareStatement(sql);
            ps.execute();
            c.close();

        }catch (Exception e){
            System.out.println("Erro no createTable");
            e.printStackTrace();
        }
    }

    public void insertOne(){
        c = db.get_connection();
        String sql="insert into Emp(name,salary,designation) values('marcelot',1000.00,'sales')";
        try {
            ps = c.prepareStatement(sql);
            ps.executeUpdate();
            c.close();

        }catch (Exception e){
            System.out.println("Erro no insertOne");
            e.printStackTrace();
        }
    }

    public int insert(Emp emp){
        c = db.get_connection();
        String sql="insert into Emp(name,salary,designation) values(?,?,?)";
        int result=0;
        try {
            ps = c.prepareStatement(sql);
            ps.setString(1, emp.getName());
            ps.setFloat( 2, emp.getSalary());
            ps.setString(3, emp.getDesignation());
            ps.executeUpdate();
            c.close();
            result=1;
        }catch (Exception e){
            System.out.println("Erro no insert");
            e.printStackTrace();
            result=-1;
        }

        return result;
    }

    public int update(Emp emp){
        c = db.get_connection();
        String sql="update Emp set name=?, salary=?, designation=? where id=?";
        int result=0;
        try {
            ps = c.prepareStatement(sql);
            ps.setString(1, emp.getName());
            ps.setFloat( 2, emp.getSalary());
            ps.setString(3, emp.getDesignation());
            ps.setInt(4, emp.getId());
            ps.executeUpdate();
            c.close();
            result=1;
        }catch (Exception e){
            System.out.println("Erro no update");
            e.printStackTrace();
            result=-1;
        }
        return result;

    }

    public int delete(int id){
        c = db.get_connection();
        int result=0;
        String sql="delete from Emp where id="+id+"";
        try {
            stmt = c.createStatement();
            stmt.executeUpdate(sql);
            c.close();
            result=1;
        }catch (Exception e){
            System.out.println("Erro no delete");
            e.printStackTrace();
            result=-1;
        }
        return result;
    }

    public Emp getEmpById(int id){
        c = db.get_connection();
        Emp emp;
        emp = new Emp();
        String sql="select * from Emp where id=?";
        try {
            ps = c.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet resultado;
            resultado = ps.executeQuery();
            emp = new Emp();
            resultado.next();
            emp.setId(resultado.getInt("id"));
            emp.setName(resultado.getString("name"));
            emp.setSalary(resultado.getFloat("salary"));
            emp.setDesignation(resultado.getString("designation"));
            c.close();

        }catch (Exception e){
            System.out.println("Erro no getEmpById");
            e.printStackTrace();
        }
        return emp;
    }
    public ArrayList<Emp> getEmployees(){
        c = db.get_connection();
        Emp emp;
        ArrayList<Emp> emps = new ArrayList<>();
        String sql="select * from `Emp`";
        System.out.println(sql);
        try {
            //DB_Connection db;
            //db = new DB_Connection();
            //c=db.get_connection();
            stmt = c.createStatement();
            stmt.executeQuery(sql);

            ResultSet resultado;
            resultado = stmt.executeQuery(sql);
            while(resultado.next()){
                emp = new Emp();
                emp.setId(resultado.getInt("id"));
                emp.setName(resultado.getString("name"));
                emp.setSalary(resultado.getFloat("salary"));
                emp.setDesignation(resultado.getString("designation"));
                emps.add(emp);
            }
            c.close();

        }catch (Exception e){
            System.out.println("Erro na getEmployees");
            e.printStackTrace();
        }
        return emps;

    }
}
