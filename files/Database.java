import java.io.BufferedWriter;
import java.io.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Database
{
	private static Database instance;
	ArrayList<Account> account = new ArrayList<Account>();

	public static Database getInstance()
	{
		if(instance==null)
		{
			instance=new Database();
		}
		return instance;
	}
	
	Account getAccount(String n)
	{
		for(int i=0;i<account.size();i++)
		{
			if(account.get(i).getAccountNo().equals(n))
			{
				return account.get(i);
			}
		}
		
		return null;
	}
	
	Account getAccount(String n, String p)
	{
		for(int i=0;i<account.size();i++)
		{
			if(account.get(i).getAccountNo().equals(n) && account.get(i).getPIN().equals(p))
			{
				return account.get(i);
			}
		}
		
		return null;
	}
	
	void addNewAccount(Account ac)
	{
		this.account.add(ac);
	}
	
	boolean isAccountNumberUnique(String n)
	{
		for(int i=0;i<account.size();i++)
		{
			if(account.get(i).getAccountNo().equals(n))
			{
				return false;
			}
		}
		
		return true;
	}
	
	void saveData()
	{
		try
		{
			Encryption encr=new Encryption();
			String key=Long.toString(System.currentTimeMillis()),encstr="";
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("AccountList.txt")));
			bw.write(key+'\n');
			for(int i=0;i<account.size();i++)
			{
				encstr+=String.valueOf(account.get(i));
			}
			encstr=encr.encrypt(encstr,key);
			bw.write(encstr);
			bw.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		System.out.println("saved");
	}
	
	
	void loadData()
	{
		try
		{
			FileReader fr = new FileReader("AccountList.txt");
			Encryption encr=new Encryption();
			String type,datastr="",key="";
			int i;
			i=fr.read();
			while (i!=-1 && i!='\n')
            {	key+=(char)i;
				i=fr.read();}
			while ((i = fr.read()) != -1)
            	datastr+=(char)i;
			datastr=encr.decrypt(datastr,key);
			int c=0;
			String data[]=datastr.split("\n");
			while(c<data.length && data.length>1 )
			{
				type=data[c++];
				Account ac;
				if(data[c]!=""){
				if(type.equals(String.valueOf(Account.SAVINGS_ACCOUNT)))
				{
					ac=new SavingsAccount(data[c++],data[c++],Double.parseDouble(data[c++]),
							new UserInformation(data[c++], data[c++], data[c++], data[c++], data[c++],
									data[c++], data[c++], data[c++]));
					ac.isActivated=Boolean.getBoolean(data[c++]);
				}
				else
				{
					ac=new CurrentAccount(data[c++],data[c++],Double.parseDouble(data[c++]),
							new UserInformation(data[c++], data[c++], data[c++], data[c++], data[c++],
									data[c++], data[c++], data[c++]));
					ac.isActivated=Boolean.getBoolean(data[c++]);
				}
				addNewAccount(ac);
				}
			}
			fr.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (NumberFormatException e)
		{	
			e.printStackTrace();
		}
	}
}
