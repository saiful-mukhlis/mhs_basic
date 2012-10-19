package com.bmb.main.project;

import java.util.List;

import com.bmb.dao.entity.DaoUsr;
import com.bmb.entity.model.Usr;
import com.bmb.util.Db;

public class Main {
	  public static void main(String[] args) {
		  System.out.println("test");
		  DaoUsr d=(DaoUsr) Db.USR.get();
		  List<Usr> us=d.getAll();
		  for (Usr usr : us) {
			System.out.println(usr.getUsername());
		}
		  
		  System.out.println("test");
		  DaoUsr dx=(DaoUsr) Db.USR.get();
		  List<Usr> usx=dx.getAll();
		  for (Usr usr : usx) {
			System.out.println(usr.getUsername());
		}
		  
		  System.out.println("test");
		  DaoUsr ds=(DaoUsr) Db.USR.get();
		  List<Usr> uss=ds.getAll();
		  for (Usr usr : uss) {
			System.out.println(usr.getUsername());
		}
	  }
}
