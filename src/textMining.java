import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class textMining 
{

	public String everything;
	public File file;

	//constructor
	textMining(File filePath)
	{
		file=filePath;

		try(BufferedReader br = new BufferedReader(new FileReader(filePath.getCanonicalFile()))) 
		{
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			everything = sb.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//System.out.println(everything);

	}


	public String fileName() //returns the filename
	{
		String fileName="";
		//System.out.println("File Path: "+file.getCanonicalPath());
		fileName=file.getName();
		fileName=fileName.substring(0, fileName.length()-4); 	//removes extension from file name
		//System.out.println("File Name: "+fileName);


		return fileName;

	}

	public String defendantName() 

	{
		String defendantName="";
		StringTokenizer tokens = new StringTokenizer(everything,"\n");

		while(tokens.hasMoreTokens())
		{
			if(tokens.nextToken().contains("DEFENDANT"))
			{


				while(tokens.nextToken()=="")
					tokens.nextToken();

				StringTokenizer test =new StringTokenizer(tokens.nextToken(),",");
				defendantName=test.nextToken();
				if(defendantName.length()>0)
				{
					try{
						defendantName=defendantName.substring(4, defendantName.length());
						break;
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				else
				{
					test =new StringTokenizer(tokens.nextToken(),",");
					defendantName=test.nextToken();
					defendantName=defendantName.substring(4, defendantName.length());
					break;
				}
			}


		}
		//System.out.println(defendantName);
		return defendantName;

	}



	public String companyName()
	{
		String companyName="";
		StringTokenizer tokens = new StringTokenizer(everything,"\n");
		String company="";
		
		String rep="";

		while(tokens.hasMoreTokens())
		{
			try
			{
				companyName=tokens.nextToken();

				//companyName=companyName.toLowerCase();
				//if(tempToken.contains("corp.")||tempToken.contains("inc.")||tempToken.contains("ltd.")||tempToken.contains("co.")||tempToken.contains("corporation")||tempToken.contains("limited"))
				if (companyName.contains("against"))
				{
					companyName +=tokens.nextToken();
					companyName +=tokens.nextToken();
					System.out.println(companyName);
					String [] words=companyName.split("against");
					//company=words[0];
					System.out.println(words[1]);
					company=companyName;
					break;


				}
			}
			catch(Exception e)
			{

			}


		}

		

		//System.out.println(companyName);
		return company;

	}

	//	public String companyName()
	//	{
	//		String companyName="";
	//		StringTokenizer tokens = new StringTokenizer(everything,"\n");
	//		String tempToken="";
	//
	//		while(tokens.hasMoreTokens())
	//		{
	//			tempToken=tokens.nextToken();
	//			tempToken=tempToken.toLowerCase();
	//			if(tempToken.contains("corp.")||tempToken.contains("inc.")||tempToken.contains("ltd.")||tempToken.contains("co.")||tempToken.contains("corporation")||tempToken.contains("limited"))
	//			{
	//				//System.out.println("FOUND A CORPORATION");
	//				companyName=tempToken;
	//			
	//				
	//			}
	//
	//
	//		}
	//		//System.out.println(companyName);
	//		return companyName;
	//
	//	}

	public String caseType()
	{

		try 
		{
			String fileLocation=file.getCanonicalPath();
			if(fileLocation.contains("Litigation"))
			{
				return "Litigation";
			}
			else if(fileLocation.contains("Administrative"))
			{
				return "Administrative Action";
			}
			else
			{
				return "Not Defined";
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Not Defined";
		}


	}





	public String dateCheck()
	{
		StringTokenizer tokens = new StringTokenizer(everything,"\n");
		String str="";
		String date="not found";
		while(tokens.hasMoreTokens())
		{
			str=tokens.nextToken();

			if (str.contains("Dated:")) 
			{
				date= str.substring(7,str.length());

			}
		}

		return date;
	}


	public String orderCheck()
	{
		String test="";
		try(BufferedReader br = new BufferedReader(new FileReader("C:/Users/s4494660/Google Drive/Saint Mary's University/Programming/Java/TextMining/order.txt"))) 
		{
			//StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) 
			{
				line=line.toLowerCase();
				//System.out.println(line);
				if(everything.contains(line))
				{
					//System.out.println("Found: "+line);
					test=line;
					break;
				}

				line = br.readLine();

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return test;

	}


	public String resolutionCheck()
	{
		String text="";
		try(BufferedReader br = new BufferedReader(new FileReader("C:/Users/s4494660/Google Drive/Saint Mary's University/Programming/Java/TextMining/resolution.txt"))) 
		{
			//StringBuilder sb = new StringBuilder();
			String line = br.readLine();


			while (line != null) 
			{
				line=line.toLowerCase();
				//System.out.println(line);
				if(everything.contains(line))
				{
					//System.out.println("Found: "+line);
					text=line;
					break;
				}

				line = br.readLine();


			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return text;

	}

	public String positionCheck()
	{
		StringTokenizer tokens = new StringTokenizer(everything,"\n");
		String str="";
		String position="";
		while(tokens.hasMoreTokens())
		{
			str=tokens.nextToken();

			if (str.contains("CEO")) 
			{
				position="CEO";
				System.out.println(str);
				break;
			}
			else if (str.contains("CFO")) 
			{
				position="CFO";
				break;
			}
			else if (str.contains("COO")) 
			{
				position="COO";
				break;
			}
			else if (str.contains("President")) 
			{
				position="President";
				break;
			}
			else if (str.contains("VP")) 
			{
				position="VP";
				break;
			}
			else
			{
				position="unknown";
			}
		}

		return position;

	}

}
