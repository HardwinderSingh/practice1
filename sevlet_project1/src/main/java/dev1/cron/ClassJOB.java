package dev1.cron;



import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import dev1.dao.LogOutDAO;

public class ClassJOB implements Job{

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
		LogOutDAO loginDAO=new LogOutDAO();
		loginDAO.updateLock();
		System.out.println("update Lock User by cron");
	}

}
