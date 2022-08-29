package code.dao;

import java.util.List;

import code.pojo.StatePojo;

public class client {
public static void main(String[] args) {
	StateDetailDao stDao=new StateDetailDao();
	List<StatePojo> list = stDao.getStateList();

	System.out.println("list is"+list);
	
}
}
