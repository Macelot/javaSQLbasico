package org.example.demosql2;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
        System.out.println("Iniciando");
        EmpDAO empDAO = new EmpDAO();

        empDAO.dropTable();
        empDAO.createTable();
        empDAO.insertOne();

        System.out.println("List data");
        //list data-------------------------------
        ArrayList<Emp> emps = empDAO.getEmployees();

        for (int i=0;i<emps.size();i++){
            System.out.println(emps.get(i).toString());
        }

        System.out.println("Insert Data");
        //insert data--------------------------------
        Emp emp;
        emp = new Emp();
        emp.setName("Marcelot");
        emp.setSalary(28000.00f);
        emp.setDesignation("Development");
        empDAO.insert(emp);

        System.out.printf("List data after Insert");
        //list data again------------------------------
        emps = empDAO.getEmployees();
        for (int i=0;i<emps.size();i++){
            System.out.println(emps.get(i).toString());
        }

        System.out.println("Read Data, only id 1");
        //read data-----------------------------------
        emp = empDAO.getEmpById(1);
        System.out.println(emp.toString());

        System.out.println("Update Data");
        //update data---------------------------------
        emp.setSalary(0);
        empDAO.update(emp);

        System.out.printf("List data after update");
        //list data again------------------------------
        emps = empDAO.getEmployees();
        for (int i=0;i<emps.size();i++){
            System.out.println(emps.get(i).toString());
        }

        //delete data
        empDAO.delete(1);

        System.out.printf("List data after delete");
        //list data again------------------------------
        emps = empDAO.getEmployees();
        for (int i=0;i<emps.size();i++){
            System.out.println(emps.get(i).toString());
        }


    }
}
